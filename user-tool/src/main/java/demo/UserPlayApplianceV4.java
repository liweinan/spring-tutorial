package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserPlayApplianceV4 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"configV3.xml");
		UserV4 peter = (UserV4) ctx.getBean("peter");
		System.out.println(peter.getUsername() + " is using "
				+ peter.getAppliance().use());

	}

}
