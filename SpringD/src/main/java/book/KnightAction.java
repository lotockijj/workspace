package book;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightAction {

	public static void main(String[] args) throws QuestException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
		context.registerShutdownHook();
		Knight quest = (Knight) context.getBean("knight");
		System.out.println("***********************************************************");
		quest.embarkOnQuest();
		context.close();
	}

}
