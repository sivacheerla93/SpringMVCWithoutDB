package com.siva.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.siva.model.Employee;

@Controller
public class FirstController {

	ArrayList<Employee> list = new ArrayList<Employee>();

	// Insert Employee
	@RequestMapping("/insert")
	public ModelAndView callInsertForm() {
		return new ModelAndView("insertpage", "command", new Employee());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView insertEmployee(@ModelAttribute("siva") Employee emp) {
		list.add(emp);
		return new ModelAndView("redirect:index.jsp");
	}

	// Delete Operation
	@RequestMapping("/delete")
	public ModelAndView callDeletePage() {
		return new ModelAndView("deletepage", "command", new Employee());
	}

	@RequestMapping(value = "/delete1", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute Employee emp) {
		Iterator<Employee> it = list.iterator();
		while (it.hasNext())
			if (emp.getId() == it.next().getId())
				it.remove();
		return new ModelAndView("redirect:index.jsp");
	}

	// Update Employee
	@RequestMapping("/update")
	public ModelAndView callUpdatePage() {
		return new ModelAndView("updatepage", "command", new Employee());
	}

	@RequestMapping(value = "/update1", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute Employee emp) {
		String msg = "Empty set";
		Iterator<Employee> it = list.iterator();
		if (it.hasNext())
			if (emp.getId() == it.next().getId()) {
				it.remove();
				list.add(emp);
				msg = "Updated Successfully!";
			}
		return new ModelAndView("updateout", "msg", msg);
	}

	// Find Employee
	@RequestMapping("/find")
	public ModelAndView callFindPage() {
		return new ModelAndView("findpage", "command", new Employee());
	}

	@RequestMapping(value = "/find1", method = RequestMethod.POST)
	public ModelAndView FindEmployee(@ModelAttribute("siva") Employee emp) {
		Iterator<Employee> it = list.iterator();
		Employee emp3 = null;

		while (it.hasNext()) {
			Employee emp1 = (Employee) it.next();
			if (emp1.getId() == emp.getId())
				emp3 = emp1;
		}
		return new ModelAndView("findout", "emp", emp3);
	}

	// View All Employees
	@RequestMapping("/viewall")
	public ModelAndView viewemp() {
		return new ModelAndView("viewall2", "list", list);
	}

	// To Go Back
	@RequestMapping("/back")
	public ModelAndView BackPage() {
		return new ModelAndView("redirect:index.jsp");
	}
}
