package org.perscholas.childcare.db;


import org.perscholas.childcare.dto.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

    Parent findByEmail(String email);

}
