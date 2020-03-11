package org.perscholas.childcare.controllers;

import org.perscholas.childcare.dto.Message;
import org.perscholas.childcare.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("messages")
public class MessagesController {

    @Autowired
    MessageService service;

    @RequestMapping
    public String list(Model model) {
        List<Message> messageList = service.listForCurrentUser();
        model.addAttribute("messageList", messageList);

        return "messageList";
    }

    @RequestMapping(value = "{messageId}", method = RequestMethod.GET)
    public String sendMessage(@PathVariable int messageId, Model model) {
        Message message = service.get(messageId);

        if(message == null) {
            model.addAttribute("message", new Message());
            return "newMessage";
        } else {
            model.addAttribute("message", message);
            return "viewMessage";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String sendMessage(@ModelAttribute("message") Message message) {
        service.save(message);
        return "redirect:/messages";
    }

}
