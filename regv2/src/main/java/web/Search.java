package web;

import java.util.List;

import model.dao.RegistrationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Search {
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@RequestParam("keyword")
	String keyword, Model model) {
		List l = dao.search(keyword);
		model.addAttribute("results", l);
		return "search";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showPage() {
		return "search";
	}

	@Autowired
	private RegistrationDao dao;
}
