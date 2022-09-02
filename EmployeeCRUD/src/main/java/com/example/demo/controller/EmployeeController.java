package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Controller
@Component
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeerepository;  //@Autowired here to avoid tight coupling
	                                                //@Autowired -@Component
	
	
	@GetMapping("/home")
	public String getHome(Model model) 
	{
		List <Employee> list=employeerepository.findAll();
		
		System.out.println("data-----------"+list.toString());
		model.addAttribute("employeeList", list);
		return "Home";
	}
	@GetMapping("/add")
	public String addEmployee()
	{
		return "AddEmployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee( Employee emp ,Model model)
	{
		
		employeerepository.save(emp);
		List <Employee> list=employeerepository.findAll();
		model.addAttribute("employeeList", list);
		
		return "Home";
	}
	@GetMapping("/delete")
	public String deleteEmployee(Model model,@RequestParam("eid") Integer id)
	{
		employeerepository.deleteById(id);
		List <Employee> list=employeerepository.findAll();
		model.addAttribute("employeeList", list);
		
		System.out.println("Inside Delete-----------------------");
		
		return "Home";
	}
	
	@GetMapping("/toupdate")
	public String toupdateEmployee(@RequestParam("eid") Integer id,Model model)
	{
		Optional<Employee> eoption=employeerepository.findById(id);
		
		Employee e=null;
		
		if(eoption.isPresent())
		{
			e=eoption.get();
			model.addAttribute("employee",e);
		}
		
		return "UpdateEmployee";
	}
	@PostMapping("/update")
	public String updateEmployee (Model model,@ModelAttribute ("employee") Employee employee )
	{
		employeerepository.save(employee);
		
		List<Employee> list=employeerepository.findAll();
		
		model.addAttribute("employeeList",list);
		
		return "Home";
	}

}
