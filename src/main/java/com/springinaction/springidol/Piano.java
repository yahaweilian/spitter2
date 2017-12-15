package com.springinaction.springidol;

/**
 * 钢琴
 * @author Administrator
 *
 */
public class Piano implements Instrument {

	public Piano() {
	}
	@Override
	public void play() {

		System.out.println("PLINK PLINK PLINK ");
	}

}
