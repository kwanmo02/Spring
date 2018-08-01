<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	multipartView.jsp
	
	<form action="/mvc/multipart/upload" enctype="multipart/form-data" method="post">
		<input type="text" name="userId" value="black"><br>
		<input type="file" name="uploadFile"><br><br>
		
		
		<input type="file" name="files"><br>
		<input type="file" name="files"><br>
		
		<input type="submit" value="전송">
	</form>
	
</body>
</html>