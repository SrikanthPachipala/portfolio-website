package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Contact;
import com.example.model.User;
import com.example.service.ContactService;
import com.example.service.ProjectService;
import com.example.service.SkillService;
import com.example.service.UserService;

@Controller
public class PageController {
	@Autowired
	private final UserService userService;
	@Autowired
	private final SkillService skillService;
	@Autowired
	private final ProjectService projectService;
	@Autowired
	private final ContactService contactService;

	public PageController(UserService userService, SkillService skillService, ProjectService projectService,
			ContactService contactService) {
		this.userService = userService;
		this.skillService = skillService;
		this.projectService = projectService;
		this.contactService = contactService;
	}

	@GetMapping("/")
	public String home(Model model) {
		List<User> users = userService.getAllUsers();
		if (!users.isEmpty()) {
			model.addAttribute("user", users.get(0));
		} else {
			model.addAttribute("user", null); // fallback
		}
		return "index";
	}

	@GetMapping("/about")
	public String about(Model model) {
		List<User> users = userService.getAllUsers();
		if (!users.isEmpty()) {
			model.addAttribute("user", users.get(0));
		} else {
			model.addAttribute("user", null);
		}
		return "about";
	}

	@GetMapping("/skills")
	public String skills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "skills";
	}

	@GetMapping("/projects")
	public String projects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "projects";
	}

	@GetMapping("/contact")
	public String contactForm(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}

	@PostMapping("/contact")
	public String submitContact(@ModelAttribute Contact contact, Model model) {
		contactService.saveContact(contact);
		model.addAttribute("message", "Your message has been sent!");
		return "contact";
	}
}
