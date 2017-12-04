package com.springinaction.springidol;

/**
 * ������-ͨ��ʹ��factory-method ��������������Ϊbean
 * @author Administrator
 *
 */
public class Stage {

	private Stage(){}
	
	private static class StageSingletonHolder{
		static Stage instance = new Stage(); //�ӳټ���ʵ��
	}
	
	public static Stage getInstance(){
		return StageSingletonHolder.instance;
	}
}
