package com.collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.collegefest.Model.Student;
import com.collegefest.services.StudentService;
import com.collegefest.services.StudentServiceImpl;

@Controller
@RequestMapping("/fest")
public class FestController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String getStudents(Model model){
		
		List<Student> students=studentService.findAll();
		System.out.println(students);
		model.addAttribute("student",students);
		return "list-students";
	}
	
	
	

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int theId) {
		
		studentService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/fest/list";
		
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student stu=new Student();
		theModel.addAttribute("student",stu);
		return "fest-form";
	}
	
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId,Model theModel) {
		
		Student stu=studentService.findById(theId);
		theModel.addAttribute("student",stu);
		return "fest-form";
	}
	
	
	@PostMapping("/save")
	public String saveForm(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("department")String department,@RequestParam("country") String country){
		
		Student stu;
		
		if(id !=0) {
		stu=studentService.findById(id);
		stu.setName(name);
		stu.setDepartment(department);
		stu.setCountry(country);
		}else 
			
			stu=new Student(id, name, department, country);
			
		studentService.save(stu);
		
		
		return "redirect:/fest/list";
		
	}
	
	
	
}
