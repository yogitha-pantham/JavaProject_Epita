<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
  <title>Quix Search </title>
  <style type="text/css">
  html,body {
  height: 90%;
  width: 100%;
}



.wrapper {
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper h1 {
  display: flex;
  justify-content: center;
  font-family: 'Expletus Sans', cursive;
      font-size: 50px;
    letter-spacing: 10px;
}

header h1{
  font-family: 'Expletus Sans', cursive;
  letter-spacing: 10px;
  margin: 5px;
}

.logo:hover{
  text-decoration: none;
}


.logo:focus{
  text-decoration: none;
}

input {
  width: 500px;
  height: 30px;
}
.button {
         width: 136px;
    height: 36px;
}

.search_buttons {
  display: flex;
  justify-content: space-around;
  padding: 20px;
}

.hidden {
  display: none;
}

nav {
  display: flex;
  align-items: center;
  padding: 5px;
  height: 90px;
  width: 100%;
  background-color: #eee;
}

nav h3{
  margin: 5px;
}


input#after_search{
  display: flex;
  align-items: center;
  margin: 15px;
  padding-left: 7px;
  height: 35px;
  font-size:20px;  
}



section{
    padding-left: 160px;
    padding-top: 30px;
}

.wiki_title{
  font-size: 1.5em;
}

.wiki_title a{
  color:#1717de;
}

.wiki_title a:visited{
  color:purple;
}

.wiki_snippet{
  width:500px;
  padding-bottom: 15px;
}

.wiki_snippet_8{
  padding-bottom:45px;
}

.search_buttons a{
  width: 100px;
}

.btn-primary {
   
    background-color: #eee;
    border-color: #eee;
    color: grey;
    font-weight: bold;
}    

.search_buttons a:hover{
  color: black;
  background-color: #eee;
  border-color: #bfb4b4;
}

.error{
  font-size:1.3em;
}

.after_search_container{
  display: flex; 
  align-items: center;
  
}

.after_search_container span{
  display: flex;
  height: 35px;
  font-size: 20px;
  justify-content: center;
  align-items: center;
  width: 35px;
  background-color:#3369E8;
  margin-left: -15px;
  color: white;
}

.after_search_container span i{
  margin-left: 6px;
}

.after_search_container span:hover{
  cursor:pointer;
}

/*Media Query*/

@media (min-width:521px) and (max-width:720px){
    input#after_search {
  width: 300px;
}
  
    input#before_search{
    width: 250px;
  }
  
  .wiki_snippet {
    width: 350px;
}

  section{
    padding-left: 35px;
  }
}

@media only screen and (max-width:520px)  {
 
  input#before_search{
    width: 250px;
  }
  
  input#after_search{
    width: 250px;
  }
  
  .wiki_snippet {
    width: 350px;
}

  section{
    padding-left: 20px;
  }
}

@media only screen and (max-width:470px)  {
 
  input#before_search{
    width: 300px;
  }
  
  input#after_search{
    width: 160px;
  }
  
  .wiki_snippet {
    width: 330px;
}

  section{
    padding-left: 20px;
  }
}
p{
  text-align:center;
}
.footer {
  font-face: arial;
  font-size: 15px;
  border-top: 1px solid black;
  bottom: 20px;
  width: 100%;
  min-width: 350px;
  padding: 1em 1em 0em 1em;
  position: bottom;
  display: flex;
}
.footer-logos {
  position: bottom;
  margin-top: -1em;
  font-size: 10px;
}
.footer-logos a {
    text-decoration: none;
}
.footer-logos i {
  
  text-align: center;
  margin: 0 0 1em 1em;
  padding-top: .25em;
  border: 1px solid rgba(100, 100, 100, .3);
  border-radius: 25%;
  vertical-align: -1.5em;
}
.footer-logos .genericon {
  width: 2em;
  height: 2em;
}
.footer-logos .fa {
  width: 2em;
  height: 2em;  
}
.footer .container-fluid {
  position: bottom;
  display: flex;
  max-width: 1000px;
}

.btnclass {
     width: 122px;
    height:30px;
}


  
  </style>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
</head>

<body>

 <!--Initially the searched result display will be hidden until user searches for something specific-->

    <div class="hidden" id="searched_results_display">
        <header>
            <nav>
                <a href="https://codepen.io/askhubchandani/full/rLKRoo/" class="logo"><h1><span style="color:#3369E8">Wel</span><span style="color:#D50F25">come</span><span style="color:#EEB211">2</span><span style="color:#009925">Quiz</span><h1></a>
            <div class="after_search_container">
                <input type="text" id="after_search"/ >
                <span><i class="glyphicon glyphicon-search"></i></span>
                </div>
        </nav>
        </header>
        
        
            
        
     </div>   
        
    
      
      <div class="wrapper">
        <div class="search_body">
        <h1><span style="color:#3369E8">Wel</span><span style="color:#D50F25">Come</span><span style="color:#EEB211">2</span><span style="color:#009925">Quiz</span></h1>
            <div><input type="text" placeholder="Search Quiz.." id="before_search" autofocus>
            <input type="button" class="button" value="Search" id="srchbtn">
              <input type="button" class="button" value="Add Questions" id="addbtn">
            
            </div>
            <div class="search_buttons1">
            
                 <c:forEach items="${examList}" var="exam">
                 <h4 id="hreflinks">
           <a href="./quizstart/${exam.examId}" style="display: inline; ">${exam.questionHeading} </a> 
           
<input type="button" class="btnclass" value="Export File" onclick="window.location.href='exportFile/${exam.examId}'"/>


               <br><br></h4>
           
           <input type="hidden" value="${exam.questionHeading}" class="abc">
                 </h4>
                  </c:forEach>
                
            </div>
            
            
            <div class="search_buttons2">
            
                 <h4 id="hreflinks2">
                 </h4>
                
            </div>
            
            
            
        </div>
        
        
      </div>
         

     
        </body>
        
        <script>
        $(document).ready(function() {
        	
        	$("#addbtn").click(function() {
        	
				window.location.href = ("/saveExam");

        		
        	});
        	$("#srchbtn").click(function() {
        	
  var data=$("#before_search").val();
  debugger;
        	  $.ajax({
  			type : "POST",
  			url : "/searchExam",
  			dataType : 'json',
  			data : data,
  			contentType : "application/json;charset=UTF-8",
  			xhrFields : {
  				withCredentials : true
  			},
  			success : function(data) {
  				if(data.length>0){
  				$(".search_buttons2").show("");
  				$(".search_buttons1").hide("");

  				for (var i = 0; i <data.length ; i++) {
  					
  					$("#hreflinks2").html(" <a href='./quizstart/"+data[i].examId+"' style='display: inline;'>"+data[i].questionHeading+" </a><br><br></h4>");
				}
  					
  					
  				}else{
  					alert("No Data Exist ");
  				}
  			},
  			error : function(xhr, status, error) {
  				
  			},
  		});
        	 


        	});

        	});
        </script>
</html>