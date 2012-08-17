package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class FlowHandler extends AbstractFlowHandler {

	@Override
	public String handleExecutionOutcome(FlowExecutionOutcome outcome,
			HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/web/viewregistrations";
	}

	@Override
	public String handleException(FlowException e, HttpServletRequest request,
			HttpServletResponse response) {
		if (e instanceof NoSuchFlowExecutionException) {
			return "redirect:/";
		} else {
			throw e;
		}
	}

}
