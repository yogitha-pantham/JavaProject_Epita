<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>jQuery Quiz Plugin</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel='stylesheet' href='https://raw.githubusercontent.com/jchamill/jquery-quiz/master/src/jquery.quiz.css'>

    
<style>
body {
  background: #0c1514;
  color: #fff;
}
h1 {
  color: #63c5bc;
}
.faded {
  color: #777;
}
#quiz-counter {
  color: #88449a;
}
.quiz-container {
    padding: 0.25em;
    max-width: 650px;
    margin: 1em auto;
}

.quiz-container a {
    text-decoration: none;
    color: #333;
}

#quiz-header,
#quiz-start-screen,
#quiz-results-screen,
#quiz-counter {
    text-align: center;
}

.question {
    font-size: 1.25em;
}

.answers {
    list-style: none;
    padding: 0;
}

.answers a {
    display: block;
    padding: 0.5em 1em;
    margin-bottom: 0.5em;
    background: #fff;
}

.answers a.correct {
    background: #090;
}
.answers a.incorrect {
    background: #c00;
}

.answers a.correct,
.answers a.incorrect {
    color: #fff;
}

#quiz-controls {
    background: #63c5bc;
    color: #111;
    padding: 0.25em 0.5em 0.5em;
    text-align: center;
}

#quiz-response {}
#quiz-results {
    font-size: 1.25em;
}

#quiz-buttons a,
.quiz-container .quiz-button {
    display: inline-block;
    padding: 0.5em 1em;
    background: #88449a;
    color: #fff;
}
#quiz-buttons a {
    background: #fff;
    color: #333;
}

/* Quiz State Overrides */

.quiz-results-state #quiz-controls {
    background: none;
    padding: 0;
}
.quiz-results-state #quiz-buttons a {
    background: #88449a;
    color: #fff;
}
</style>
  
</head>

<body>
    <div id="quiz">
    <div id="quiz-header">
      <h1>${descrption}</h1>
      <p class="faded">A quiz about to improve the knowledge</p>
    </div>
    <div id="quiz-start-screen">
      <p><a href="#" id="quiz-start-btn" class="quiz-button">Start</a></p>
    </div>
  </div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://jchamill.github.io/jquery-quiz/jquery.quiz-min.js'></script>

  

    <script>
  
	
	
	$(document).ready(function() {
		 $.ajax({
			  type : "GET",
				url : "/sendExamquestions",
				dataType : 'json',
				contentType : "application/json;charset=UTF-8",
				xhrFields : {
					withCredentials : true
				},success : function(data) {
					debugger;
					
						  //resultsScreen: '#results-screen',
						  //counter: false,
						  //homeButton: '#custom-home',
						 
						  var dataarray=[];
						  
						  for (var i = 0; i < data.questions.length; i++) {
							 
							  var x= data.questions[i].option3;
							  if(x==null){
								  dataarray.push({'q':data.questions[i].question,'options': [
									  data.questions[i].option1,
									  data.questions[i].option2,
									  ],
									  'correctIndex': parseInt(data.questions[i].correctIndex),
									  'correctResponse': 'Good job, that was obvious.',
								      'incorrectResponse': 'Well, if you don\'t include it, your quiz won\'t work'})
							  }else{
							  dataarray.push({'q':data.questions[i].question,'options': [
								  data.questions[i].option1,
								  data.questions[i].option2,
								  data.questions[i].option3,
								  data.questions[i].option4,
								  ],
								  'correctIndex': parseInt(data.questions[i].correctIndex),
								  'correctResponse': 'Good job, that was obvious.',
							      'incorrectResponse': 'Well, if you don\'t include it, your quiz won\'t work'})
							  }
								 
							      
				}
						  $('#quiz').quiz({
							  counterFormat: 'Question %current of %total',
							  questions: dataarray
					});
				}
	});
	});
	</script>




</body>

</html>
