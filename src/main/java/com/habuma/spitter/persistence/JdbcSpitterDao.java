package com.habuma.spitter.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.spitter.domain.Spitter;

/**
 * JDBC DAO
 * @author Administrator
 *
 */
@Service("spitterDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JdbcSpitterDao implements SpitterDao {

	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;//数据访问模板
	//插入spitter语句
	private static String SQL_INSERT_SPITTER = 
			"insert into spitter (username, password, fullname)"
			+ "values (:username, :password, :fullname)";
	
	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addSpitter(Spitter spitter) {
		Map<String, Object> params = new HashMap<>();
		params.put("username", spitter.getUsername());
		params.put("password", spitter.getPassword());
		params.put("fullname", spitter.getFullName());
		
		jdbcTemplate.update(SQL_INSERT_SPITTER, params);
		spitter.setId(queryForIdentity());
	}

	private long queryForIdentity() {
		
		return 0;
	}
	
}
