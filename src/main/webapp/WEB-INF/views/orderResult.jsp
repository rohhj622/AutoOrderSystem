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
	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <script type="text/javascript">
	    google.charts.load("current", {packages:["corechart"]});
	    google.charts.setOnLoadCallback(drawChart);
	    function drawChart() {
	      var data = google.visualization.arrayToDataTable([
	    	  /* ['학번' ,'누적순서',],
	          <c:forEach items="${eachSum}" var="result" varStatus="st">
	          	['${result.no}', '${result.orderNo}'],
	          </c:forEach> */
	        ["이름", "횟수", { role: "style" } ],
	        <c:forEach items="${eachSum}" var="result" varStatus="st">
          	['${result.name}', parseInt('${result.orderNo}'),"#99d6ff"],
          	</c:forEach>
	        /* ["Copper", 8.94, "#b87333"],
	        ["Silver", 10.49, "silver"],
	        ["Gold", 19.30, "gold"],
	        ["Platinum", 21.45, "color: #e5e4e2"]
	         */
	      ]);
	
	      var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 1,
	                         type: "string",
	                         role: "annotation" },
	                       2]);
	
	      var options = {
	        title: "순서 누적",
	        width: 600,
	        height: 400,
	        bar: {groupWidth: "95%"},
	        legend: { position: "none" },
	      };
	      var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
	      chart.draw(view, options);
	  }
 	</script>
   
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
    	<div class="row">
    		<div class="col-lg-8">
    			<div id="barchart_values" style="margin:auto; width=2em; "></div>
    		</div>
    		<div class="col-lg-4">
    			<br><br>
    			<table class="table table-striped">
    				<thead>
						<tr>
					    	<th scope="col">#</th>
					    	<th scope="col">이름</th>
					    	<th scope="col">GitHub</th>
						</tr>
					</thead>
    				<c:forEach items="${curOrder }" var="nO">
						<c:forEach items='${allMember}' var='allM'>
							<c:if test="${nO.no==allM.no}">
								<tr>	
									<td>${nO.orderNo}</td>
		    						<td>${allM.name }</td>
		    						<td><a href="${allM.address }">${allM.address }</a></td>
		    					</tr>
							</c:if>
					    </c:forEach>
					</c:forEach>
    			</table>
    		</div>
    	</div>
    </div>
    
<%--     <c:forEach items='${allOrder}' var='allO'>
    	${allO.no },${allO.orderNo }!
    </c:forEach>
    <c:forEach items='${allMember}' var='allM'>
    	${allM.name },${allM.address }!
    </c:forEach>

    <c:forEach items="${eachSum}" var="result" varStatus="st">
          	${result.no}, ${result.orderNo}
    </c:forEach>
    
   <c:forEach items="${curOrder }" var="nO">
			${nO.orderNo}
		</c:forEach>
     --%>
    
</body>
</html>
