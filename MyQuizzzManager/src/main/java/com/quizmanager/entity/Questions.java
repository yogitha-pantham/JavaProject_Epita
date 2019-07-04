package com.quizmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Questions")
public class Questions {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionId;
	@Column
	private String question;
	@Column
	private String option1;
	@Column
	private String option2;
	@Column
	private String option3;
	@Column
	private String option4;
	@Column
	private String correctIndex;

	/**
	 * @return the questionId
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the option1
	 */
	public String getOption1() {
		return option1;
	}

	/**
	 * @param option1 the option1 to set
	 */
	public void setOption1(String option1) {
		this.option1 = option1;
	}

	/**
	 * @return the option2
	 */
	public String getOption2() {
		return option2;
	}

	/**
	 * @param option2 the option2 to set
	 */
	public void setOption2(String option2) {
		this.option2 = option2;
	}

	/**
	 * @return the option3
	 */
	public String getOption3() {
		return option3;
	}

	/**
	 * @param option3 the option3 to set
	 */
	public void setOption3(String option3) {
		this.option3 = option3;
	}

	/**
	 * @return the option4
	 */
	public String getOption4() {
		return option4;
	}

	/**
	 * @param option4 the option4 to set
	 */
	public void setOption4(String option4) {
		this.option4 = option4;
	}

	/**
	 * @return the correctIndex
	 */
	public String getCorrectIndex() {
		return correctIndex;
	}

	/**
	 * @param correctIndex the correctIndex to set
	 */
	public void setCorrectIndex(String correctIndex) {
		this.correctIndex = correctIndex;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", question=" + question + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctIndex=" + correctIndex + "]";
	}

}
