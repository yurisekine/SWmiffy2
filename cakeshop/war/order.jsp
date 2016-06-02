<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ケーキ屋さん</title>
</head>
<body>
	カートの中身
	<p>ケーキ：<c:out value="${cakeName}"/><br>
       個数：<c:out value="${number}"/>個<br>
       合計：<c:out value="${number}"/>00円
	</p>
    <form action="/cakeshop/LoginServlet" method="post">
		<input type="submit" value="会員">
    </form>
    <form action="/cakeshop/SignupServlet" method="post">
        <input type="submit" value="初めて">
    </form>
</body>
</html>