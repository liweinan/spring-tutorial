package support;

import java.util.List;

import model.Registration;
import model.dao.RegistrationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class RegistrationValidator {

	public void validate(Registration registration, Errors errors) {
		if (!StringUtils.hasLength(registration.getUsername())) {
			errors.rejectValue("username", "required");
		}

		List<Registration> registrations = dao.findByUsername(registration
				.getUsername());
		if (registrations != null)
			for (Registration r : registrations)
				if (r.getClazz().getId()
					.equals(registration.getClazz().getId()))
					errors.rejectValue("username", "duplicate");
	}

	@Autowired
	private RegistrationDao dao;
}
