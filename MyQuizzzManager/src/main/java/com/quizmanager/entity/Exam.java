package com.quizmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer examId;

	@Column
	private String questionHeading;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examId", referencedColumnName = "examId")
	private List<Questions> questions;

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getQuestionHeading() {
		return questionHeading;
	}

	public void setQuestionHeading(String questionHeading) {
		this.questionHeading = questionHeading;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", questionHeading=" + questionHeading + ", questions=" + questions + "]";
	}

}
