package com.quizmanager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.quizmanager.bussiness.Exambusiiness;
import com.quizmanager.entity.Exam;
import com.quizmanager.utill.Utill;

@RestController
public class HomeController {

	@Autowired
	Exambusiiness exambusiiness;

	@Autowired
	HttpSession httpSession;
	@Autowired
	Utill utillservices;

	@GetMapping("/")
	public ModelAndView dashboard() {
		ModelAndView andView = new ModelAndView("dashboard");

		andView.addObject("examList", exambusiiness.findAllExam());

		return andView;
	}

	@GetMapping("/quizstart/{examID}")
	public ModelAndView startExam(@PathVariable Integer examID) {
		httpSession.setAttribute("examID", examID);
		ModelAndView andView = new ModelAndView("startExam");
		andView.addObject("descrption", exambusiiness.getDescrptionofExam(examID));
		return andView;
	}

	@GetMapping("/saveExam")
	public ModelAndView saveExam() {
		utillservices.saveExam();
		ModelAndView andView = new ModelAndView("dashboard");

		andView.addObject("examList", exambusiiness.findAllExam());

		return andView;
	}

	@GetMapping("/sendExamquestions")
	public Exam sendExamquestions() {
		Integer examId = (Integer) httpSession.getAttribute("examID");
		return exambusiiness.findById(examId);
	}

	@PostMapping("/searchExam")
	public List<Exam> searchExam(@RequestBody String searchExam) {
		return exambusiiness.searchExam(searchExam);
	}

	@GetMapping("/exportFile/{examId}")
	public String exportFile(@PathVariable Integer examId) {
		return utillservices.exportFile(examId);


	}

}
