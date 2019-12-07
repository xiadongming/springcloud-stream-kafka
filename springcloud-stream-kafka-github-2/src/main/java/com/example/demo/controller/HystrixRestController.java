package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloudstreamkafka.model.Address;
import com.springcloudstreamkafka.model.Message;
import com.springcloudstreamkafka.model.Project;
import com.springcloudstreamkafka.service.MessageSender;

@RestController
@RequestMapping("/web")
public class HystrixRestController {
	
	private final MessageSender messageSender;

	public HystrixRestController(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public void getGreetings() {
		System.out.println("===============stream======================");
		messageSender.send("===发送消息====11111=====");

	}
}
