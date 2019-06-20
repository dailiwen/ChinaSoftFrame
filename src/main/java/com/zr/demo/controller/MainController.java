package com.zr.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zr.demo.producer.IMessageProducerService;
import com.zr.demo.service.MailService;
import com.zr.demo.service.UserService;
import com.zr.model.User;

@RestController
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private IMessageProducerService iMessageProducerService;

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/abc")
	public User home() {
		return userService.selectUserById(3);
	}

	@RequestMapping(value = "/q")
	public void q() {
		for (int x = 0; x < 10; x++) {
			this.iMessageProducerService.sendMessage1("study - " + x);
		}
	}

	@RequestMapping(value = "/x")
	public void x() {
		mailService.SendMail();
	}

	@RequestMapping(value = "/r")
	public List<User> r() {
		return userService.findAllUsers();
	}

}
