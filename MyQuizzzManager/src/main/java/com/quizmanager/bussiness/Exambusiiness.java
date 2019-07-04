package com.quizmanager.bussiness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizmanager.dao.ExamDAORepositry;
import com.quizmanager.entity.Exam;

@Service
public class Exambusiiness {

	@Autowired
	private ExamDAORepositry examDAORepositry;

	public List<Exam> findAllExam() {
		return examDAORepositry.findAll();

	}

	public Exam findById(Integer examId) {
		Optional<Exam> examById = examDAORepositry.findById(examId);
		Exam exam = null;
		if (examById.isPresent()) {
			exam = examById.get();
		}
		return exam;
	}

	public String getDescrptionofExam(Integer examID) {
		Optional<Exam> examById = examDAORepositry.findById(examID);
		Exam exam = null;
		if (examById.isPresent()) {
			exam = examById.get();
		}

		return exam.getQuestionHeading();

	}

	public List<Exam> searchExam(String searchExam) {
		List<Exam> dbexamlList = examDAORepositry.findAll();
		List<Exam> examlList = new ArrayList<Exam>();
		String string = null;
		for (Exam exam : dbexamlList) {
			string = exam.getQuestionHeading();
			Boolean found = Arrays.asList(string.split(" ")).contains(searchExam);
			if (found) {
				examlList.add(exam);
			}

		}

		if (examlList.isEmpty()) {
			String s1 = searchExam.substring(0, 1);
			searchExam = s1 + searchExam.substring(1, searchExam.length());

			dbexamlList = examDAORepositry.findAll();
			examlList = new ArrayList<Exam>();
			string = "";
			for (Exam exam : dbexamlList) {
				string = exam.getQuestionHeading();
				Boolean found = Arrays.asList(string.split(" ")).contains(searchExam);
				if (found) {
					examlList.add(exam);
				}

			}

		}
		return examlList;
	}

}
