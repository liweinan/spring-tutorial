package jpa;

import java.util.List;

import jpa.model.Address;
import jpa.model.dao.PhoneBookService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("model.xml");
		PhoneBookService phoneBookService = (PhoneBookService) ctx
				.getBean("phoneBookService");
		Address address = new Address();

		address.setId("1");
		address.setUsername("tom");
		address.setPhone_number("123456");
		phoneBookService.storeAddress(address);

		List<Address> addressesToFind = phoneBookService
				.findAddressesByUsername("tom");

		for (Address result : addressesToFind) {
			System.out.println("username: " + result.getUsername());
			System.out.println("phone number: " + result.getPhone_number());
		}

	}
}
