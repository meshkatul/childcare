package org.perscholas.childcare.db;

import org.perscholas.childcare.dto.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findByMessageTo(String messageTo);

}
