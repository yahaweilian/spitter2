package com.habuma.spitter.util;

import java.util.Comparator;

/**
 * @author Administrator
 *
 */
public class TupleComparator implements Comparator<Tuple>{

	/* 
	 * Sort Tuples starting from the newest ones.
	 */
	@Override
	public int compare(Tuple o1, Tuple o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
