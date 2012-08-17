package jpa.model.dao;

import java.util.List;

import jpa.model.Address;
import jpa.model.Category;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class JpaPhoneBookServiceImpl extends JpaDaoSupport implements
		PhoneBookService {

	@Transactional(readOnly = false)
	public Address storeAddress(Address address) {
		getJpaTemplate().merge(address);
		return address;
	}

	@SuppressWarnings("unchecked")
	public List<Address> findAddressesByUsername(String username) {
		return getJpaTemplate().find("from Address where username=?", username);
	}

	@Transactional(readOnly = false)
	public Address findAddressById(String id) {
		List list = getJpaTemplate().find("from Address where id=?", id);
		if (list.size() == 1)
			return (Address) list.get(0);
		return null;
	}

	@Transactional(readOnly = false)
	public Category storeCategory(Category category) {
		getJpaTemplate().merge(category);
		return category;
	}

	@Transactional(readOnly = true)
	public Category getCategoryFromAddress(Address address) {
		List list = getJpaTemplate().find(
				"select c from Category c, Address a where a.category=c and a=?",
				address);
		if (list.size() == 1)
			return (Category) list.get(0);
		return null;
	}

}
