package com.cts.iiht.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.iiht.model.Book;
import com.cts.iiht.model.Subject;
import com.cts.iiht.service.BookService;
import com.cts.iiht.service.SubjectService;

@Controller
public class WelcomeController {

	@Autowired
	BookService bookService;
	
	@Autowired
	SubjectService subjectService;

	@GetMapping({"/","/home"})
	public String welcomeAction() {
		return "index";	
	}

	@PostMapping("/search")
	public ModelAndView search(@RequestParam("searchType") String searchType, @RequestParam("id") Long id) {
		System.out.println(searchType + "-----" + id);
		if(searchType != null && "book".equalsIgnoreCase(searchType)) {
			Book book =  bookService.searchBook(id);
			List<Book> books = new ArrayList<>();
			if(book != null) {
				books.add(book);
			}
			return new ModelAndView("bookList", "books", books).addObject("messageTest", "testing");
		}else {
			Subject subject = subjectService.searchSubject(id);
			List<Subject> subjects = new ArrayList<>();
			if(subject != null) {
				subjects.add(subject);
			}
			return new ModelAndView("subjectList", "subjects", subjects);
		}
	}
}
