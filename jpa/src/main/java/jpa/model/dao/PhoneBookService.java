package jpa.model.dao;

import java.util.List;

import jpa.model.Address;
import jpa.model.Category;

public interface PhoneBookService {

	public Address storeAddress(Address address);

	public Category storeCategory(Category category);

	public List<Address> findAddressesByUsername(String username);

	public Address findAddressById(String id);

	public Category getCategoryFromAddress(Address address);
}
