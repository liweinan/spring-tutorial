package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserPlayApplianceV2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"config.xml");
		UserV2 peter = (UserV2) ctx.getBean("peter");
		System.out.println(peter.getUsername() + " is using "
				+ peter.getAppliance().use());

		UserV2 tom = (UserV2) ctx.getBean("tom");
		System.out.println(tom.getUsername() + " is using "
				+ tom.getAppliance().use());

	}

}
