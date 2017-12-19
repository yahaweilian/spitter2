package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

	public static void main(String[] args) throws QuestException {
		
		//ClassPathXmlApplicationContext 上下文容器加载位于应用系统 classpath 下的一个或多个 XML文件
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knights/knights.xml");
		
		Knight knight = (Knight) context.getBean("knight");
		
		knight.embarkOnQuest();
	}
}
