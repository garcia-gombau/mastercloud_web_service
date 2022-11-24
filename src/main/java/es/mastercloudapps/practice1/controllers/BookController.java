package es.mastercloudapps.practice1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.mastercloudapps.practice1.services.BookService;

@Controller
@RequestMapping()
public class BookController {

	@GetMapping("/book/{id}")
	public String book(Model model, @PathVariable Long id) {
		
		model.addAttribute("book", new BookService().getBookById(id));

		return "book_template";
	}
}
