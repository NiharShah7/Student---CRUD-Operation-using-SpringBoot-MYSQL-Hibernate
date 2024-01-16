package com.demo.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.students.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{

}
