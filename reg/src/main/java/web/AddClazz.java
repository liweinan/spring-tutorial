package web;

import model.Clazz;
import model.dao.ClazzDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/addClazz.html")
public class AddClazz {

	@RequestMapping(method = RequestMethod.GET)
	protected String setupForm(Model model) {
		Clazz clazz = new Clazz();
		model.addAttribute("clazz", clazz);
		return "clazzForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("clazz")
	Clazz clazz, SessionStatus status) {
		dao.store(clazz);
		status.setComplete();
		return "redirect:viewRegistrations.html";

	}

	@Autowired
	private ClazzDao dao;
}
