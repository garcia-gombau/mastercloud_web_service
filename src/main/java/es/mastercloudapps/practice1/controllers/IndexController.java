package es.mastercloudapps.practice1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.mastercloudapps.practice1.services.BookService;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index(Model model) {		
		
		model.addAttribute("books", new BookService().getAllBooks());

		return "index_template";
	}
}
