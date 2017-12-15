package com.springinaction.springidol;

/**
 * 表演者
 * @author ynding
 * 
 */
public interface Performer {

	/**
	 * 表演
	 * @throws PerformanceException
	 */
	void perform() throws PerformanceException;
}
