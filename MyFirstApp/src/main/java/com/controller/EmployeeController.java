package main.java.com.controller;

import main.java.com.dao.Employee;
import main.java.com.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping(value = "/employee/create", method = RequestMethod.GET)
	public ModelAndView addEmployee(ModelMap model) {
		System.out.println("EmployeeController.addEmployee()");
		return new ModelAndView("employee/create", "employee", new Employee());
	}

	@RequestMapping(value = "/employee/save", method = RequestMethod.GET)
	public ModelAndView saveEmployee(
			@ModelAttribute("command") Employee employee) {
		if (employee.getId() != null) {
			// System.out.println("employee id :"+employee.getId());
			employeeRepository.save(employee);
		} else {
			employeeRepository.save(employee);
		}
		return new ModelAndView("index", "emp", employeeRepository.findAll());
	}

	@RequestMapping("/employee/edit/{id}")
	public ModelAndView editEmployee(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("employee", employeeRepository.findById(id));
		return new ModelAndView("employee/create", model);
	}
	
	@RequestMapping("/employee/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable("id") int id, ModelMap model) {
		employeeRepository.delete(id);
		return new ModelAndView("index", "emp", employeeRepository.findAll());
	}
}
