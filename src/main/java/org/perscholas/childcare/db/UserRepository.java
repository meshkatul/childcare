package org.perscholas.childcare.db;


import org.perscholas.childcare.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
