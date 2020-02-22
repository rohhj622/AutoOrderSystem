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
		a:link { color: black; text-decoration: none;text-align: center;}
		a:visited { color: black; text-decoration: none;text-align: center;}
		a:hover { color: #595959; text-decoration: none;text-align: center;}	
		
	</style>
    
	<title>Home</title>
	
</head>
<body>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    
    <div class="container">
    	<div class="row">
    		<div class="col-lg-12">
    			<h2>auto order</h2>
    		</div>
    	</div>
    	<div class="row">
    		<div class="col-lg-12">
    			<a href="<c:url value='/addStudentPage'/>">
    				학생추가하기
    			</a>	
    		</div>
    	</div>
    </div>
    
	<h1>
		Hello world!  
	</h1>

	<P>The time on the server is ${serverTime}. </P>
</body>
</html>
