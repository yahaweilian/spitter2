package com.springinaction.springidol;


/**
 * ÀÖÆ÷Ñİ×à¼Ò
 * @author Administrator
 *
 */
public class Instrumentalist implements Performer {

	private String song;// ¸èÇú
	private Instrument instrument;//ÀÖÆ÷
	private int age;//ÄêÁä
	
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
