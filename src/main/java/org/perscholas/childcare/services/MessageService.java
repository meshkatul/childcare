package org.perscholas.childcare.services;

import org.perscholas.childcare.db.MessageRepository;
import org.perscholas.childcare.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MessageService {

    @Autowired
    MessageRepository repository;

    @Autowired
    SecurityService securityService;

    public List<Message> listForCurrentUser() {
        return repository.findByMessageTo(securityService.getCurrentUser());
    }

    public List<Message> list() {
        return repository.findAll();
    }

    public Message get(int messageId) {
        return repository.findById(messageId).orElse(null);
    }


    public Message save(Message message) {
        if(message.getMessageFrom() == null) {
            message.setMessageFrom(securityService.getCurrentUser());
        }
        return repository.save(message);
    }
}
