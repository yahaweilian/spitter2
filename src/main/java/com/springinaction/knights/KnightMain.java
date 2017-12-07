package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

	public static void main(String[] args) throws QuestException {
		
		//ClassPathXmlApplicationContext ��������������λ��Ӧ��ϵͳ classpath �µ�һ������ XML�ļ�
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knights/knights.xml");
		
		Knight knight = (Knight) context.getBean("knight");
		
		knight.embarkOnQuest();
	}
}
