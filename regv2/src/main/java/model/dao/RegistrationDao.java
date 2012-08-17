package model.dao;

import java.util.List;

import model.Registration;

public interface RegistrationDao {

	public void store(Registration registration);

	public List<Registration> load();

	public Registration findById(String id);

	public List<Registration> findByUsername(String username);

	public List search(String keyword);
}
