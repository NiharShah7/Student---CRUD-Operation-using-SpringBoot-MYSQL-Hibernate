package com.demo.controller;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.Studentservice;
import com.demo.studentRepository.StudentRepository;
import com.demo.students.Students;

@RestController
public class StudentController {

	@Autowired
	StudentRepository sr;
	@Autowired
	Studentservice studentService;

	public StudentController() {

		System.out.println("In student controller.... 1");
	}

	// 1. Add method student in DataBase table
	@PostMapping(value = "/student")
	public Students addStudentInDB(@RequestBody Students std) {

		System.out.println("In add student data method.. 2");
		Students receivedStudent = studentService.addStudent(std);
		return receivedStudent;
	}

	// 2. Delete student data from dataBase.
	@DeleteMapping(value = "/student/{studentId}")
	public Map deleteStudent(@PathVariable("studentId") int studentId) {
		System.out.println("Delete  method.. 2");
		System.out.println("Received student Id to be deleted :" + studentId);

		int num = studentService.deleteStudent(studentId);
		System.out.println("Returned num =" + num);
		if (num == 1) {
			return Map.of("status", "deleted");
		} else {
			return Map.of("status", "NO SUCH STUDENT FOUND");
		}
	}

	// 3 . list of all data.
	@GetMapping(value = "/student")
	public List<Students> getAllStudents() {
		System.out.println("List of students.. 3");

		List findAll = studentService.getAllstudents();
		return findAll;
	}

	// 4. update a single student.
	@PutMapping(value = "/student/{studentId}")
	public Students updateStudent(@RequestBody Students newStudentData, @PathVariable("studentId") int studentId) {
		System.out.println("Update student method..4");

		Students updatedStudent= studentService.updateStudent(newStudentData, studentId);	
		System.out.println("Updated student : " + updatedStudent);

		return updatedStudent;
	}

	// 5. To find a Single student from list.
	@GetMapping(value = "/student/{studentId}")
	public Students findStudent(@PathVariable("studentId") int studentId) {
		System.out.println("Find single student ..5");

//		Students foundStudent = sr.findById(studentId).orElse(null);
	Students receivedStudentData=studentService.findSingleStudent(studentId);
	System.out.println("Student Data of id " + studentId + " : " + receivedStudentData);

		return receivedStudentData;

	}

}
