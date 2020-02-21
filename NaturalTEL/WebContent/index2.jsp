<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello, Natural TEL</h1>
	<h1>加分測試#2</h1>
	<form action="aservlet?method=getAES256" method="post">
		<input type="submit" value="查詢">
	</form>
	<hr>	
	<form action="aservlet?method=addBase64AndAES256" method="post">
		<input type="text" name="jsonString" value="" placeholder="請輸入json字串">
		<input type="submit" value="輸入"> ${requestScope.info}
	</form>
	<hr>	
	
</body>
</html>