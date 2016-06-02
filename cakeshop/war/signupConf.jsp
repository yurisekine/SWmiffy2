<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ケーキ屋さん</title>
</head>
<body>
	<p>
        名前: <c:out value="${name}"/><br>
        ID:<c:out value="${userId}"/><br>
        パス:<c:out value="${pass}"/><br>
        メールアドレス:<c:out value="${mail}"/><br>
        電話番号:<c:out value="${tell}"/><br>
        住所:<c:out value="${address}"/><br>
    </p>
        <form action="/cakeshop/SignupServlet" method="post">            
            <input type="submit" value="変更">
        </form>
        <form action="/cakeshop/SignupOKServlet" method="post">            
            <input type="submit" value="完了">
        </form>
</body>
</html>