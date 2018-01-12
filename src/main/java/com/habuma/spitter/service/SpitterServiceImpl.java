package com.habuma.spitter.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.persistence.SpitterDao;
import com.habuma.spitter.util.EMailSender;
import com.habuma.spitter.util.EditSpitter;
import com.habuma.spitter.util.ImageAction;
import com.habuma.spitter.util.SecurityRole;
import com.habuma.spitter.util.ShortSpitter;

/**
 * @author Administrator
 *
 */
@Service("spitterServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SpitterServiceImpl implements SpitterService {
	
	private SpitterDao hibernateSpitterDao;
	private EMailSender emailSender;
	
	@Autowired
	public SpitterServiceImpl(SpitterDao hibernateSpitterDao) {
		this.hibernateSpitterDao = hibernateSpitterDao;
	}

	/*
	 * 传播行为被设置为REQUIRED，要求必须在事务中运行
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Spittle> getRecentSpittles(int defaultSpittlesPerPage) {
		return (List<Spittle>) hibernateSpitterDao.getRecentSpittles(defaultSpittlesPerPage);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Spitter getSpitter(String username) {
		
		return hibernateSpitterDao.findSpitterByUserameOrEmail(username);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Object getSpittlesForSpitter(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void savaSpitter(Spitter spitter) {
		
		hibernateSpitterDao.updateSpitter(spitter);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<ShortSpitter> getAllUsers() {
		return hibernateSpitterDao.getAllUsers();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<ShortSpitter> searchSpitters(String query) {
		return hibernateSpitterDao.searchSpitters(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteSpitter(String username) {
		hibernateSpitterDao.deleteSpitter(username);
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addSpitter(Spitter spitter) {

		//Encode password, md5.
		PasswordEncoder encoder = new Md5PasswordEncoder();
		spitter.setPassword(encoder.encodePassword(spitter.getPassword(), null));
		
		//Set avatar as default.
		spitter.setAvatar("default.jpg");
		spitter.setGrantedAuthority(SecurityRole.ROLE_USER);

		hibernateSpitterDao.addSpitter(spitter);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Spitter getSpitterByUsername(String username) {
		return hibernateSpitterDao.findSpitterByUserameOrEmail(username);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addSpitterToFollower(Spitter spitterMe, Spitter spitterToFollow) {
		
		spitterMe.getSpittersIFollow().add(spitterToFollow);
		hibernateSpitterDao.saveSpitter(spitterMe);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean isSpitterFollowedBy(Spitter spitterMe, String username) {
		
		//If the method is invoked for myself, return false.
		if(spitterMe.getUsername().equals(username)) {
			return false;
		}

		//Check each person that I follow whether they use searched username.
		for(Spitter item : spitterMe.getSpittersIFollow()) {
			if(item.getUsername().equals(username)) {
				return true;
			}
		}

		//None of the people I follow use given username, hence return false.
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void removeSpitterFromFollowers(Spitter spitterMe,
			String username) {
		
		for(Spitter item : spitterMe.getSpittersIFollow()) {
			if(item.getUsername().equals(username)) {
				spitterMe.getSpittersIFollow().remove(item);
				hibernateSpitterDao.saveSpitter(spitterMe);
				return;
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateSpitter(EditSpitter editSpitter) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		//Encode password, md5.
		PasswordEncoder encoder = new Md5PasswordEncoder();
		editSpitter.setPassword(encoder.encodePassword(editSpitter.getPassword(), null));
		
		if(!editSpitter.getFile().isEmpty()) {
			//The user has provided a valid image file.
			hibernateSpitterDao.updateSpitter(username, editSpitter, ImageAction.UPDATE);
		} else if(editSpitter.isRemoveAvatar()) {
			//No image file, but checked in the form to remove old picture.
			hibernateSpitterDao.updateSpitter(username, editSpitter, ImageAction.DELETE);
		} else {
			//No image file has been provided, and checkbox's reminded unchecked.
			//Therefore keep things in the same fashion as they were.
			hibernateSpitterDao.updateSpitter(username, editSpitter, ImageAction.MAINTAIN);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<ShortSpitter> getSpittersIFollow() {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return hibernateSpitterDao.getFollowing(username);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<ShortSpitter> getSpittersWhoFollowMe() {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return hibernateSpitterDao.getFollowers(username);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public int countFollowers() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return hibernateSpitterDao.countFollowers(username);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public int countFollowing() {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return hibernateSpitterDao.countFollowing(username);
	}


	/**
	 * Generate random string.
	 * @param rng Generator of random numbers.
	 * @param characters Set of characters from which string can be assembled.
	 * @param length The length of the string.
	 * @return
	 */
	private String generateString(Random rng, String characters, int length) {
		
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void remindPassword(String username, String email) {
		
		//Generate a new password.
		String newPassword = generateString(new Random(), "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM", 12);
		
		//Encode password (MD5).
		PasswordEncoder encoder = new Md5PasswordEncoder();
		String passwordEncoded = encoder.encodePassword(newPassword, null);
		
		//Update a new password to the database.
		if(hibernateSpitterDao.updateSpitterPassword(username, passwordEncoded)) {
		//Email new password to the user.		
			emailSender.sendEMail("spitter.reminder@gmail.com",
	 		   email,
	 		   "Spitter -- your new password", 
	 		   "Hi, " + username + "! \n\n New password: " + newPassword + "\n\n Regards, \n\n -Spitter Team");
		} 		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean confirmUserDetails(String username, String email) {
		
		return hibernateSpitterDao.confirmUserDetails(username, email);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void setBeanFactory(BeanFactory context) throws BeansException {
		
		emailSender = (EMailSender) context.getBean("emailSender");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean isUsernameAvailable(String username) {
		return hibernateSpitterDao.isUsernameAvailable(username);
	}

}
