package org.perscholas.childcare.db;

import org.perscholas.childcare.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
