package com.springinaction.springidol;


/**
 * 乐器演奏家
 * @author Administrator
 *
 */
public class Instrumentalist implements Performer {

	private String song;// 歌曲
	private Instrument instrument;//乐器
	private int age;//年龄
	
	public Instrumentalist() {}
	
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

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
