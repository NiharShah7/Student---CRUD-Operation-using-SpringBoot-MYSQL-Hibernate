package com.demo.service;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.studentRepository.StudentRepository;
import com.demo.students.Students;

@Component
public class Studentservice {

	@Autowired
	StudentRepository sr;

	// service 1
	public Students addStudent(Students student) {

		Students savedStudent = sr.save(student);

		System.out.println("Saved data of student is :" + savedStudent);

		return savedStudent;
	}

	// service 2
	public int deleteStudent(int studentId) {
		Students isStudentFound = sr.findById(studentId).orElse(null);

		if (isStudentFound != null) {
			sr.deleteById(studentId);
			return 1;
		} else {

			return 0;
		}

	}

	// service 3
	public List<Students> getAllstudents() {

		List studentList = sr.findAll();

		ListIterator<Students> itr = studentList.listIterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		return studentList;

	}
	
	// service 4 
	public Students updateStudent(Students student , int studentId) {
		
		
		Students existingstudent = sr.findById(studentId).orElse(null);

		if (existingstudent != null) {
			existingstudent.setStudentAge(student.getStudentAge());
			existingstudent.setStudentName(student.getStudentName());
			existingstudent.setGender(student.getGender());
			existingstudent.setStudentPhoneNumber(student.getStudentPhoneNumber());

			sr.save(existingstudent);
		}
		
		
		return existingstudent;
	}
	
	//service 5 
	public Students findSingleStudent(int studentId) {
		
		Students foundStudent=sr.findById(studentId).orElse(null);
		
		return foundStudent;
		
	}

}
