package org.perscholas.childcare.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.perscholas.childcare.db.StudentRepository;
import org.perscholas.childcare.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public List<Student> listStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(int studentID) throws FileNotFoundException {
		Student student = studentRepository.findById(studentID).get();
		return student;
	}

	public List<Student> listStudentsByClass(int classId) {
		List<Student> allStudents = studentRepository.findAll();
		List<Student> studentsInAClass = new ArrayList<Student>();

		for (Student st : allStudents) {
			if (st.getClassId() == classId) {
				studentsInAClass.add(st);
			}
		} return studentsInAClass;
	}
}
