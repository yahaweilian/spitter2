package com.springinaction.springidol;

/**
 * ����
 * @author Administrator
 *
 */
public class Sonnet29 implements Poem {

	private static String[] LINES = {
			"��ǰ���¹⣬",
			"���Ƶ���˪��",
			"��ͷ�����£�",
			"��ͷ˼���硣"
	};
	
	@Override
	public void recite() {
		for (int i = 0; i < LINES.length; i++) {
			System.out.println(LINES[i]);
		}
	}

}
