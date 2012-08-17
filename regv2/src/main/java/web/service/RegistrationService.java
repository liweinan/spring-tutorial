package web.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import model.Registration;
import model.dao.RegistrationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@WebService
public class RegistrationService {

	@SuppressWarnings("unchecked")
	public ArrayList<String> searchUser(String keyword) {
		if (!StringUtils.hasLength(keyword))
			return null;
		
		List<Registration> results = dao
				.search(keyword.trim());
		
		ArrayList<String> users = new ArrayList<String>();
		for (Registration r : results) {
			users.add(r.getUsername());
		}
		return users;
	}

	@Autowired
	private RegistrationDao dao;
}
