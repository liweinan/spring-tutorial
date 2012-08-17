package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import model.Registration;

import org.springframework.util.StringUtils;

public class InMemoryRegistrationDaoImpl implements RegistrationDao {
	private static final List<Registration> registrationPool = new ArrayList<Registration>();

	public void store(Registration registration) {
		if (registration == null)
			return;
		boolean isNew = !StringUtils.hasLength(registration.getId());
		if (isNew) {
			registration.setId(UUID.randomUUID().toString());
			Date date = new Date();
			registration.setCreatedAt(date);
			registration.setUpdatedAt(date);
		} else {
			registration.setUpdatedAt(new Date());
		}
		registrationPool.add(registration);
		registration.getClazz().getRegistrations().add(registration);
	}

	public List<Registration> load() {
		return registrationPool;

	}

	public Registration findById(String id) {
		if (!StringUtils.hasLength(id))
			return null;
		for (Registration registration : registrationPool) {
			if (id.equals(registration.getId()))
				return registration;
		}
		return null;
	}

	public List<Registration> findByUsername(String username) {
		if (!StringUtils.hasLength(username))
			return null;
		List<Registration> list = new ArrayList<Registration>();
		for (Registration registration : registrationPool) {
			if (username.equals(registration.getUsername()))
				list.add(registration);
		}
		return list;
	}

	public List search(final String keyword) {
		return null;

	}

}
