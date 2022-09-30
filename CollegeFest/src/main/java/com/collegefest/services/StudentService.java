package com.collegefest.services;

import java.util.List;

import com.collegefest.Model.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save (Student theStudent);
	
	public void deleteById(int theId);
	
	
}
