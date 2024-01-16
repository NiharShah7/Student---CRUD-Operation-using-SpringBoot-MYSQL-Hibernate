package com.demo.controller;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.studentRepository.StudentRepository;
import com.demo.students.Students;

@RestController
public class StudentController {

	@Autowired
	StudentRepository sr;

	public StudentController() {
		// for checking that controller is working.
		System.out.println("In student controller.... 1");
	}

	// 1. Add method student in DataBase table (http://localhost:8080/addStudent)
	@PostMapping(value = "/addStudent")
	public Students addStudentInDB(@RequestBody Students std) {

		System.out.println("In add student data method.. 2");
		Students savedStudent = sr.save(std);
		System.out.println("Saved data of student is :" + savedStudent);

		return savedStudent;
	}

	// 2. Delete student data from dataBase. (http://localhost:8080/deleteStudent/1)
	@DeleteMapping(value = "/deleteStudent/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int studentId) {
		System.out.println("Delete  method.. 2");
		System.out.println("Received student Id to be deleted :" + studentId);
		sr.deleteById(studentId);

		return "Data from table Deleted !";

	}

	// 3 . list of all data.(http://localhost:8080/showAllStudents)
	@GetMapping(value = "/showAllStudents")
	public List<Students> getAllStudents() {
		System.out.println("List of students.. 3");
		List findAll = sr.findAll();

		ListIterator<Students> itr = findAll.listIterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		return findAll;
	}

	// 4. update a single student.
	@PutMapping(value = "/updateStudent/{studentId}")
	public Students updateStudent(@RequestBody Students newStudentData, @PathVariable("studentId") int studentId) {
		System.out.println("Update student method..4");
		
		Students existingstudent = sr.findById(studentId).get();

		existingstudent.setStudentAge(newStudentData.getStudentAge());
		existingstudent.setStudentName(newStudentData.getStudentName());
		existingstudent.setGender(newStudentData.getGender());
		existingstudent.setStudentPhoneNumber(newStudentData.getStudentPhoneNumber());

		sr.save(existingstudent);
		System.out.println("Updated student : " + existingstudent);
		return existingstudent;
	}

	// 5. To find a Single student from list.
	@GetMapping(value = "/findStudent/{studentId}")
	public Students findStudent(@PathVariable("studentId") int studentId) {
		System.out.println("Find single student ..5");
		Students foundStudent = sr.findById(studentId).get();
		System.out.println("Student Data of id " + studentId + " : " + foundStudent);

		return foundStudent;

	}

}
