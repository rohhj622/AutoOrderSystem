<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>  
    
    <style type="text/css">		
		div{
			text-align: center;
			margin:auto;

		}		
		a:link { color: black; text-decoration: none;text-align: center;}
		a:visited { color: black; text-decoration: none;text-align: center;}
		a:hover { color: #595959; text-decoration: none;text-align: center;}	
		
	</style>
    
	<title>Home</title>
	
</head>
<script type="text/javascript">
 
  var count = 1;
 
	function check(){
		console.log("hi");
		if(frm.no.value){
			alert("아이디를 입력하시오.");
			return false;
		}
		if(frm.name.value){
			alert("비밀번호를 입력하시오.");
			return false;
		}
		if(frm.github.value){
			alert("이름을 입력하시오.");
			return false;
		}
	}
 
  function addForm(){
 
  var addedFormDiv = document.getElementById("addedFormDiv");

  var str = "";
/*  	str+="<div class='col-lg-1'>";
    str+= count
 	str+="</div>"; */

	str+="<div class='col-lg-3'>";
 	str+=count+". 학번"+" <input type='text' class='form-control' id='no' name='stu_no_"+count+"' placeholder='201844077' >";
 	str+="</div>";

	str+="<div class='col-lg-4'>";
 	str+="이름 <input type='text' class='form-control' id='name' name='stu_name_"+count+"' placeholder='노현진' >";
	str+="</div>";
	
	str+="<div class='col-lg-5'>";
	str+="GitHub <input type='text' class='form-control' id='addressGit' name='stu_github_"+count+"' placeholder='https://github.com/rohhj622' >";
 	str+="</div>";
  	// 추가할 폼(에 들어갈 HTML)
 
 
	var addedDiv = document.createElement("div"); // 폼 생성	 
	addedDiv.id = "added_"+count; // 폼 Div에 ID 부 여 (삭제를 위해)	 
	addedDiv.innerHTML = str; // 폼 Div안에 HTML삽입
	addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
 	count++;
 	document.baseForm.count.value=count;
 
  	// 다음 페이지에 몇 개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장
 
  }
 
 
 
  function delForm(){
	  var addedFormDiv = document.getElementById("addedFormDiv");

	  if(count >1){ // 현재 폼이 두개 이상이면
	 
	  var addedDiv = document.getElementById("added_"+(--count));
	  // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
	 
	  addedFormDiv.removeChild(addedDiv); // 폼 삭제
	 
	  }else{ // 마 지막 폼만 남아있다면
		 
	  document.baseForm.reset(); // 폼 내용 삭제
	 
	  }
 
  }

 
  </script>
<body onload="addForm();">

  <!-- 폼을 삽입할 DIV -->
	<div class="container" id="divcontainer">
		<div class="row">
    		<div class="col-lg-12">
    			<a href="<c:url value='/'/>">
    				<h1>autoOrder</h1>
    			</a>
    		</div>
    	</div>
	    <form name="baseForm" action="<c:url value='/addStudentProc'/>" method="post" name="frm" onsubmit="return check()">
	    	<input type="hidden" name="count" value="0">
		    	<div class="row">
		    		<div class="col-lg-1 col-lg-offset-10">
		    			<input type="button" class="btn btn-md btn-info" value="추가" onclick="addForm()">
		    		</div>
		    		<div class="col-lg-1 ">
		  				<input type="button" class="btn btn-md btn-info" value="삭제" onclick="delForm()">
		    		</div>
		    	</div>
		    	<div id="addedFormDiv" class="row"></div>
		    	<br> 
		    	<div class="row">    	
			    	<input type="submit" class="btn btn-md btn-info" value="학생추가하기">
		    	</div>
	    </form>
    </div>  
</body>

</html>
