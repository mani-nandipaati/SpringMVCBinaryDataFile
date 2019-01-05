package com.cts.iiht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.iiht.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@GetMapping("/delSubject")
	public ModelAndView subjectDelAction(@RequestParam(value = "subjectId") Long subjectId,
			RedirectAttributes redirectAttributes) {
		subjectService.deleteSubject(subjectId);
		redirectAttributes.addFlashAttribute("message", "Subject has been deleted successfully");
		ModelAndView mv =  new ModelAndView("redirect:/home");
		return mv;
	}

	
}
