package jpa;

import java.util.UUID;

import jpa.model.Address;
import jpa.model.dao.PhoneBookService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEquals {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("model.xml");
		PhoneBookService phoneBookService = (PhoneBookService) ctx
				.getBean("phoneBookService");

		Address address = new Address();
		String id = UUID.randomUUID().toString();
		address.setId(id);
		address.setUsername("jack");
		address.setPhone_number("123123");

		phoneBookService.storeAddress(address);

		Address addressOfJack = phoneBookService.findAddressById(id);

		System.out.println(address.equals(addressOfJack)); // false

		System.out.println(address.getId().equals(addressOfJack.getId())); // true

		System.out.println(addressOfJack.hashCode());
		System.out.println(address.hashCode());

	}
}
