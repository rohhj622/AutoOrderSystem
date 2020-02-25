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

		}		

		.myButton {
			background-color:#7892c2;
			border-radius:31px;
			display:inline-block;
			cursor:pointer;
			color:#ffffff;
			font-family:Arial;
			font-size:21px;
			padding:21px 51px;
			text-decoration:none;
			text-shadow:1px 2px 0px #283966;
		}
		.myButton:hover {
			background-color:#476e9e;
		}
		.myButton:active {
			position:relative;
			top:1px;
		}	
		
		a:link { color: black; text-decoration: none;text-align: center;} 
		a:visited { color: #ffffff; text-decoration: none;text-align: center;}
		a:hover { color: #ffffff; text-decoration: none;text-align: center;}
		
	</style>
	
    
	<title>Home</title>
	
</head>
<body>



		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    
    <div class="container">
    	<div class="row">
    		<div class="col-lg-12">
    			<a href="<c:url value='/'/>">
    				<h1>autoOrder</h1>
    			</a>
    		</div>
    	</div>
    	<br>
    	<div class="row">
    		<a href="<c:url value='/addStudentPage'/>" class="myButton">
    			학생 추가하기
    		</a>
    	</div>
    	<br><br>
    	<div class="row">
    		<a href="<c:url value='/ordering'/>" class="myButton">!!오늘의 순서!!</a>
    	</div>
    </div>
    
</body>
</html>
