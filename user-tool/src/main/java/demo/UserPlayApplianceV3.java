package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserPlayApplianceV3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"configV2.xml");
		UserV3 peter = (UserV3) ctx.getBean("peter");
		System.out.println(peter.getUsername() + " is using "
				+ peter.getAppliance().use());
	}

}
