package es.mastercloudapps.practice1.controllers;

import es.mastercloudapps.practice1.models.Book;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.mastercloudapps.practice1.services.BookService;

@Controller
@RequestMapping()
public class BookController {

	private static Logger LOG = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookService bookService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "index_template";
	}
	@GetMapping("/book/{id}")
	public String book(Model model, HttpSession session, @PathVariable Long id) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		model.addAttribute("review", book.getReviews().values());

		model.addAttribute("username", this.getUsernameFromSession(session));
		return "book_template";
	}

	@GetMapping("/book/{bookid}/review/{reviewid}")
	public String deleteReview(Model model, HttpSession session, @PathVariable Long bookid, @PathVariable Long reviewid) {
		Book book = bookService.deleteReview(bookid, reviewid);
		model.addAttribute("book", book);
		model.addAttribute("review", book.getReviews().values());
		return book(model, session, bookid);
	}

	@GetMapping("/book")
	public String newBook(Model model) {
		return "new_book";
	}

	@PostMapping("/book")
	public String postBook(Model model, HttpSession session, @RequestParam String title,  @RequestParam String synopsis, @RequestParam String author, @RequestParam String publisher, @RequestParam String publishYear){
		Book book = bookService.addNewBook(title, synopsis, author, publisher, publishYear);
		return this.book(model,session, book.getId());
	}

	@PostMapping("/book/{bookId}/review")
	public String postReview(Model model, HttpSession session, @PathVariable Long bookId, @RequestParam String username, @RequestParam String comment, @RequestParam String rate) {
		Book book = bookService.addReview(bookId, username, comment, rate);
		session.setAttribute("username", username);
		model.addAttribute("book", book);
		model.addAttribute("review", book.getReviews().values());
		return book(model, session, bookId);
	}

	private String getUsernameFromSession(HttpSession session){
		Object username = session.getAttribute("username");
		if (username == null){
			session.setAttribute("username", "");
		}
		return session.getAttribute("username").toString();
	}
}
