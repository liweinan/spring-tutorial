package jpa;

import java.util.UUID;

import jpa.model.Address;
import jpa.model.Category;
import jpa.model.dao.PhoneBookService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLazyFetch {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("model.xml");
		PhoneBookService phoneBookService = (PhoneBookService) ctx
				.getBean("phoneBookService");

		Category category = new Category();
		String categoryId = UUID.randomUUID().toString();
		category.setId(categoryId);
		category.setKeyword("friend");

		phoneBookService.storeCategory(category);

		Address address = new Address();
		String addressId = UUID.randomUUID().toString();

		address.setId(addressId);
		address.setUsername("lily");
		address.setPhone_number("123456");

		address.setCategory(category);

		phoneBookService.storeAddress(address);

		Address myAddress = phoneBookService.findAddressById(addressId);
//		Category myCategory = myAddress.getCategory();
//		System.out.println(myCategory);

		Category myCategory2 = phoneBookService
				.getCategoryFromAddress(myAddress);
		System.out.println(myCategory2);

	}
}
