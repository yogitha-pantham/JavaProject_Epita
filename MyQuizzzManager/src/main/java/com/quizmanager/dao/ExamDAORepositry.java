package com.quizmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizmanager.entity.Exam;

public interface ExamDAORepositry extends JpaRepository<Exam, Integer> {

	
	
}
