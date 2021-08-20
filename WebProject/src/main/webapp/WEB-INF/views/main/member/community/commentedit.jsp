<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>

.box1 td{
	border : 1px solid  #e9e2e2;

}


#container .post{
	width: 700px;

}


#container .box1{
	width: 800px;
	border-collapse: collapse;
	margin: auto;
	margin-bottom:40px;
}
#container { 
 width: 900px;
 margin: auto;
}

option {
margin-left:10px;
}

#container input::placeholder { color: #ddd6d6; }

#container textarea::placeholder { color: #ddd6d6; }


option selected{
color: #e9e2e2;
}
</style>
</head>
<body>
	<!--  -->
      	 <%@ include file="/inc/header.jsp"%>
	<section id="container" >
				
   </section>


	
      <%@ include file="/inc/footer.jsp"%>
	   <%@ include file="/inc/init.jsp"%>
	
   <script>
      
   </script>
</body>
</html>



