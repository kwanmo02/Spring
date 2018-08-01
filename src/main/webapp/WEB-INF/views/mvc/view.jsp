
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>





	view.jsp
	boardNum : ${boardNum}<br>
	
	<form action="/mvc/requestParam" method="post">
		<input type="text" name="mem_id" value="brown"><br>
		<input type="submit" value="전송">
		
	</form>
	
	<c:forEach var="board" items="${boardList}">
		${board}<br>
	</c:forEach>
	
	
	
	
	
</body>
</html>