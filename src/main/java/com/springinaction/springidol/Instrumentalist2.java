package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * 乐器演奏家
 * @author Administrator
 *
 */
public class Instrumentalist2 implements Performer {

	/**
	 * value 直接装配值
	 */
	@Value("千里之外")
	private String song;// 歌曲
	/**
	 * autowired 标注字段时，可以把属性的setter方法删除
	 * autowired 默认具有强契约特征，其所标注的属性必须是可装配的。可以通过设置required=false来消除这种特征
	 * Qualifier 注解将尝试注入ID为piano的Bean
	 */
	@Autowired(required=false)
	@Qualifier("piano")
	private Instrument instrument;//乐器
	private int age;//年龄
	
	/**
	 * 当使用autowired标注多个构造器时，Spring就会从所有满足装配条件的构造器中选择入参最多的那个构造器
	 */
	@Autowired
	public Instrumentalist2() {}
	
	/**
	 * Autowired 可以标注构造器
	 * @param instrument
	 */
	@Autowired
	public Instrumentalist2(Instrument instrument) {
		super();
		this.instrument = instrument;
	}

	/**
	 * 使用Autowired注解时，Spring会尝试对该方法执行byType自动装配
	 * @param instrument
	 */
	@Autowired
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	/**
	 * Autowired 不仅能装配setter方法，还可以标注需要自动装配Bean引用的任意方法 
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
