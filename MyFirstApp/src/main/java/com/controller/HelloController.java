package main.java.com.controller;


import main.java.com.bean.EmployeeBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@Autowired
	EmployeeBean employeeBean;

	@RequestMapping("/")
	public ModelAndView index() {
		System.out.println("HelloController.index()");
		/*
		 * List<Employee> empList = new ArrayList<Employee>(); empList =
		 * (List<Employee>) employeeBean.getEmployeeRepository().findAll();
		 */
		// System.out.println(employeeBean.getEmployeeRepository().findAll());
		return new ModelAndView("index", "emp", employeeBean
				.getEmployeeRepository().findAll());
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView printHello(ModelMap model) {
		System.out.println("HelloController.printHello()");
		return new ModelAndView("hello", "message",
				"Hello Spring MVC Framework!");
	}
}
