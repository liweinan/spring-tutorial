package web;

import java.util.List;

import model.Registration;
import model.dao.ClazzDao;
import model.dao.RegistrationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import support.RegistrationValidator;

@Controller
public class AddRegistration {

	@RequestMapping(method = RequestMethod.GET)
	protected String setupForm(Model model) {
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		return "registrationForm";
	}

	@ModelAttribute("clazzList")
	public List populateClazzList() {
		return clazzDao.load();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("registration")
	Registration registration, BindingResult result, SessionStatus status) {
		validator.validate(registration, result);
		if (result.hasErrors()) {
			return "registrationForm";
		} else {
			registrationDao.store(registration);
			status.setComplete();
			return "redirect:/web/viewregistrations";

		}
	}

	@Autowired
	private RegistrationDao registrationDao;

	@Autowired
	private ClazzDao clazzDao;

	@Autowired
	private RegistrationValidator validator;

}
