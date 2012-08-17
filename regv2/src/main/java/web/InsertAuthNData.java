package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.criteria.AuthNData;
import model.dao.CriteriaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsertAuthNData {

	@Autowired
	private CriteriaDao dao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	protected String setupForm(Model model) {
		AuthNData data = new AuthNData();
		model.addAttribute("authNData", data);
		return "authNForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(@ModelAttribute("authNData")
	AuthNData data, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dao.insertAuthNData(data.getUsername(), passwordEncoder.encodePassword(
				data.getPassword(), null), data.getAuthority());

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("注册成功！");
		out.println("username: " + data.getUsername());
		out.println("authority: " + data.getAuthority());
		out.flush();
	}
}
