package com.quizmanager.utill;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizmanager.dao.ExamDAORepositry;
import com.quizmanager.entity.Exam;
import com.quizmanager.entity.Questions;

@Component
public class Utill {

	@Autowired
	private ExamDAORepositry examDAORepositry;

	public void saveExam() {
		getExam();
	}

	public Exam getExam() {
		List<Questions> q = new ArrayList<Questions>();
		Exam exam = new Exam();
		exam.setQuestionHeading("Information Techonogy Quiz");

		Questions questions = new Questions();
		questions.setQuestion("Which of the following languages is more suited to a structured program?");
		questions.setOption1("PL/1");
		questions.setOption2("FORTRAN");
		questions.setOption3("BASIC");
		questions.setOption4("PASCAL");
		questions.setCorrectIndex("0");
		q.add(questions);

		Questions questions1 = new Questions();
		questions1.setQuestion(
				"computer assisted method for the recording and analyzing of existing or hypothetical systems is");
		questions1.setOption1("Data flow");
		questions1.setOption2("Data capture");
		questions1.setOption3("Data processing");
		questions1.setOption4("Data transmission");
		questions.setCorrectIndex("1");
		q.add(questions1);

		Questions questions2 = new Questions();
		questions2.setQuestion("The brain of any computer system is");
		questions2.setOption1("ALU");
		questions2.setOption2("Memory");
		questions2.setOption3("CPU");
		questions2.setOption4("Control unit");
		questions.setCorrectIndex("2");
		q.add(questions2);

		exam.setQuestions(q);
		examDAORepositry.save(exam);
		// ---------end----------

		// ---------start new one----------

		List<Questions> q1 = new ArrayList<Questions>();
		Exam exam11 = new Exam();
		exam11.setQuestionHeading("Aptitude Test");

		Questions questions11 = new Questions();
		questions11.setQuestion("My child chooses to play with older kids and prefers adult company to that of peers.");
		questions11.setOption1("Never.");
		questions11.setOption2("Seldom");
		questions11.setOption3("Occasionally.");
		questions11.setOption4("Often.");
		questions.setCorrectIndex("2");
		q1.add(questions11);

		Questions questions12 = new Questions();
		questions12.setQuestion("My child is self-motivating and can work independently.");
		questions12.setOption1("Seldom.");
		questions12.setOption2("Occasionally.");
		questions12.setOption3("Often.  ");
		questions12.setOption4("Almost Always.");
		questions12.setCorrectIndex("2");
		q1.add(questions12);

		Questions questions13 = new Questions();
		questions13.setQuestion("Herbivores eat meat.");
		questions13.setOption1("YES");
		questions13.setOption2("NO");
		questions13.setCorrectIndex("0");
		q1.add(questions13);

		Questions questions14 = new Questions();
		questions14.setQuestion("My child loves to go to school..");
		questions14.setOption1("Never.");
		questions14.setOption2("Almost Always.");
		questions14.setOption3("Occasionally.");
		questions14.setOption4("Seldom");
		questions14.setCorrectIndex("0");
		q1.add(questions13);

		exam11.setQuestions(q1);
		examDAORepositry.save(exam11);

		// ---------end----------

		// ---------start new one----------

		List<Questions> q2 = new ArrayList<Questions>();
		Exam exam21 = new Exam();
		exam21.setQuestionHeading("Logical Reasoning Questions");

		Questions questions21 = new Questions();
		questions21.setQuestion("Look at this series: 2, 1, (1/2), (1/4), ... What number should come next?");
		questions21.setOption1("(1/3)");
		questions21.setOption2("(1/8)");
		questions21.setOption3("(2/8)");
		questions21.setOption4("(1/16)L");
		questions21.setCorrectIndex("1");
		q2.add(questions21);

		Questions questions22 = new Questions();
		questions22.setQuestion("7, 10, 8, 11, 9, 12, ... What number should come next?");
		questions22.setOption1("7");
		questions22.setOption2("10");
		questions22.setOption3("12");
		questions22.setOption4("13");
		questions22.setCorrectIndex("1");
		q2.add(questions22);

		Questions questions33 = new Questions();
		questions33.setQuestion("Look at this series: 36, 34, 30, 28, 24, ... What number should come next?");
		questions33.setOption1("20");
		questions33.setOption2("22");
		questions33.setOption3("23");
		questions33.setOption4("26");
		questions33.setCorrectIndex("1");
		q2.add(questions33);

		Questions questions34 = new Questions();
		questions34.setQuestion("Look at this series: 53, 53, 40, 40, 27, 27, ... What number should come next?");
		questions34.setOption1("12");
		questions34.setOption2("14");
		questions34.setOption3("27");
		questions34.setOption4("53");
		questions34.setCorrectIndex("1");
		q2.add(questions34);

		Questions questions35 = new Questions();
		questions35.setQuestion("Atomic bombs work by atomic fission.");
		questions35.setOption1("YES");
		questions35.setOption2("NO");
		questions35.setCorrectIndex("0");
		q2.add(questions35);

		exam21.setQuestions(q2);
		examDAORepositry.save(exam21);

		return exam;
	}

	public String exportFile(Integer examId) {

		List<Exam> examlist = examDAORepositry.findAll();

		for (Exam exam : examlist) {
			if (examId.equals(exam.getExamId())) {
				return writeFile(exam);
			}
		}

		return null;
	}

	public String writeFile(Exam exam) {
		String str = "\n";
		String path = "";
		FileOutputStream fout = null;
		try {
			path = "F:\\" + exam.getQuestionHeading() + " " + ".txt";
			fout = new FileOutputStream(path);
			str = exam.getExamId() + "\n ";
			List<Questions> e = exam.getQuestions();

			for (Questions exam2 : e) {

				str = str + exam2.getQuestion() + " \n " + "\n " + exam2.getOption1() + " " + exam2.getOption2() + " \n"
						+ exam2.getOption3() + " " + exam2.getOption4() + " \n" + exam2.getCorrectIndex() + " /n ";

			}

			byte[] b = str.getBytes();
			fout.write(b);
			fout.close();
		} catch (Exception e) {

			throw new RuntimeErrorException(null, " " + e);
		} finally {
			try {
				fout.close();
			} catch (IOException e) {
			}
		}
		return "File Downloaded : " + path;

	}

}
