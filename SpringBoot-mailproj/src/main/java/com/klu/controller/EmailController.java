package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.service.EmailService;


@RestController
@RequestMapping("/mail")
public class EmailController 
{
	@Autowired
	private EmailService emailservice;
	@GetMapping("/send")
	public String sendSimpleEmail(@RequestParam String to,@RequestParam String subject,@RequestParam String text)
	{
		return emailservice.sendSimpleMail(to, subject, text);
	}
	@PostMapping("/attach")
	public String sendSimpleEmailattach(@RequestParam String to,@RequestParam String subject,@RequestParam String text,@RequestParam String Path)
	{
		return emailservice.sendSimpleMailAttach(to, subject, text, Path);
	}

}