package org.perscholas.childcare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.perscholas.childcare.db.MessageRepository;
import org.perscholas.childcare.dto.Message;
import org.perscholas.childcare.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("messages")
public class MessagesController {

	@Autowired
	MessageService service;
	
	@Autowired
    MessageRepository repository;

	// get all message in inbox
	@RequestMapping
	public String list(Model model) {
		List<Message> messageList = service.listForCurrentUser();
		model.addAttribute("messageList", messageList);
		return "messageList";
	}
	
	
	// view message page
		@RequestMapping(value = "{messageId}", method = RequestMethod.GET)
		public String replyMessage(@PathVariable int messageId, Model model) {
			Message message = service.get(messageId);
			List<Message> messageList = new ArrayList<Message>();
					messageList = service.listForCurrentUser();
			if (message == null) {
				model.addAttribute("message", new Message());
				return "newMessage";
			} else if(messageList.contains(message)){
				model.addAttribute("message", message);
				return "viewMessage";
			} else {
				return "accessDenied";
			}
		}

	@RequestMapping(value = "/reply/{messageId}", method = RequestMethod.GET)
	public String sendMessage(@PathVariable("messageId") int messageId, Model model) {
		Message replyMessage = new Message();
		Message message = service.get(messageId);
		replyMessage.setMessageTo(message.getMessageFrom());
		
		model.addAttribute("message", replyMessage);
		return "replyMessage";
	}

	// sending new message
	@RequestMapping(method = RequestMethod.POST)
	public String sendMessage(@ModelAttribute("message") Message message) {
		service.save(message);
		return "redirect:/messages";
	}

}
