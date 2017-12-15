package com.springinaction.springidol;

/**
 * 单例类-通过使用factory-method 来将单例类配置为bean
 * @author Administrator
 *
 */
public class Stage {

	private Stage(){}
	
	private static class StageSingletonHolder{
		static Stage instance = new Stage(); //延迟加载实例
	}
	
	public static Stage getInstance(){
		return StageSingletonHolder.instance;
	}
}
