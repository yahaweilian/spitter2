package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * ���������
 * @author Administrator
 *
 */
public class Instrumentalist2 implements Performer {

	/**
	 * value ֱ��װ��ֵ
	 */
	@Value("ǧ��֮��")
	private String song;// ����
	/**
	 * autowired ��ע�ֶ�ʱ�����԰����Ե�setter����ɾ��
	 * autowired Ĭ�Ͼ���ǿ��Լ������������ע�����Ա����ǿ�װ��ġ�����ͨ������required=false��������������
	 * Qualifier ע�⽫����ע��IDΪpiano��Bean
	 */
	@Autowired(required=false)
	@Qualifier("piano")
	private Instrument instrument;//����
	private int age;//����
	
	/**
	 * ��ʹ��autowired��ע���������ʱ��Spring�ͻ����������װ�������Ĺ�������ѡ����������Ǹ�������
	 */
	@Autowired
	public Instrumentalist2() {}
	
	/**
	 * Autowired ���Ա�ע������
	 * @param instrument
	 */
	@Autowired
	public Instrumentalist2(Instrument instrument) {
		super();
		this.instrument = instrument;
	}

	/**
	 * ʹ��Autowiredע��ʱ��Spring�᳢�ԶԸ÷���ִ��byType�Զ�װ��
	 * @param instrument
	 */
	@Autowired
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	/**
	 * Autowired ������װ��setter�����������Ա�ע��Ҫ�Զ�װ��Bean���õ����ⷽ�� 
	 * @param instrument
	 */
	@Autowired
	public void heresYourInstrument(Instrument instrument){
		this.instrument = instrument;
	}
	@Override
	public void perform() throws PerformanceException {
		System.out.println("playing" + song + ":");
		instrument.play();
	}
	
	public String screamSong(){
		return song;
	}
	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
    
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
