package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"aspect.xml");
		Bolt bolt = (Bolt) ctx.getBean("bolt");
		bolt.run(false);

	}
}
