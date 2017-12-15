package com.springinaction.springidol;

/**
 * 萨克斯
 * @author Administrator
 *
 */
public class Saxophone implements Instrument {

	public Saxophone() {
	}
	@Override
	public void play() {
        System.out.println("TOOT TOOT TOOT");
	}

}
