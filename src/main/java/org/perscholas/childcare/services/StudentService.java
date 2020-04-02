package org.perscholas.childcare.services;


import java.util.List;

import org.perscholas.childcare.db.ClassRoomRepository;
import org.perscholas.childcare.db.StudentRepository;
import org.perscholas.childcare.dto.Parent;
import org.perscholas.childcare.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassRoomRepository classRoomRepository;

	//get all students
	public List<Student> listStudents() {
		return studentRepository.findAll();
	}

	//get a particular student by id
	public Student getStudent(int studentID) {
		Student student = studentRepository.findById(studentID).get();
		return student;
	}
	
	//add new student
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

    //get a student by parent
	public Student getStudentByParent(Parent parent) {
		return studentRepository.findStudentByParent(parent);
	}
}
