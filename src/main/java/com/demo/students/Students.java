package com.demo.students;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="studentId")
	private int studentId;
	
	@Column(name="studentName")
	private String studentName;
	
	@Column(name="studentAge")
	private int studentAge;
	
	@Column(name="studentPhoneNumber")
	private int studentPhoneNumber;
	
	
	@Column(name="gender")
	private String gender;
	
	
	public Students() {
		super();
	}
	
	public Students(int studentId, String studentName, int studentAge, int studentPhoneNumber, String gender) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentPhoneNumber = studentPhoneNumber;
		this.gender = gender;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentPhoneNumber=" + studentPhoneNumber + ", gender=" + gender + "]";
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
	
		this.studentAge = studentAge;
	}
	public int getStudentPhoneNumber() {
		return studentPhoneNumber;
	}
	public void setStudentPhoneNumber(int studentPhoneNumber) {
		
		this.studentPhoneNumber = studentPhoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



}
