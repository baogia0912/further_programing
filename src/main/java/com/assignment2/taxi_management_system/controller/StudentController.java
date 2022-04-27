package com.assignment2.taxi_management_system.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.assignment2.taxi_management_system.model.Student;
import com.assignment2.taxi_management_system.service.StudentService;
import java.util.List;
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping(path = "/students", method = RequestMethod.GET)
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}

	@RequestMapping(path = "/students", method = RequestMethod.POST)
	public int addStudent(@RequestBody Student student){
		return studentService.saveStudent(student);
	}
}