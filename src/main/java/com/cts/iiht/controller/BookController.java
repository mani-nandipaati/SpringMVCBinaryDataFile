package com.cts.iiht.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.iiht.model.Book;
import com.cts.iiht.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ModelAndView getAllBooks( ) {
		return new ModelAndView("bookList", "books", bookService.getAllBooks());
	}
	
	@GetMapping("/bookForm")
	public ModelAndView bookFormAction(@RequestParam(value="bookId", required = false) Long bookId) {
		Book book = bookId == null? new Book(): bookService.searchBook(bookId);
		ModelAndView mv = new ModelAndView("bookForm","book",book);
		return mv;
	}
	
	@PostMapping("/bookForm")
	public ModelAndView bookSaveAction(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes) {
		ModelAndView mv = null;
		
		if(bindingResult.hasErrors()) {
			mv = new ModelAndView("bookForm","book", book);
		}
		else {
			bookService.addBook(book);
			redirectAttributes.addFlashAttribute("message", "Book has been added successfully");
			mv =  new ModelAndView("redirect:/home");
		}
		return mv;
	}
	
	@GetMapping("/delBook")
	public ModelAndView bookDelAction(@RequestParam(value = "bookId") Long bookId, RedirectAttributes redirectAttributes) {
		bookService.deleteBook(bookId);
		redirectAttributes.addFlashAttribute("message", "Book has been deleted successfully");
		ModelAndView mv =  new ModelAndView("redirect:/home");
		return mv;
	}

}
