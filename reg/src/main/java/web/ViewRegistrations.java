package web;

import java.util.List;

import model.dao.ClazzDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/viewRegistrations.html")
public class ViewRegistrations {

	@ModelAttribute("clazzList")
	List populateClazzList() {
		return dao.load();
	}

	@RequestMapping(method = RequestMethod.GET)
	protected String setup() {
		return "viewRegistrations";
	}

	@Autowired
	private ClazzDao dao;

}
