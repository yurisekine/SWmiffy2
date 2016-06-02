<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ケーキ屋さん</title>
</head>
<body>
 <h1>新規登録</h1>
        <form action="/cakeshop/SignupConfServlet" method="post">
            名前:<input type="text" name="name"><br>
            ID:<input type="text" name="userId"><br>
            パスワード:<input type="password" name="pass"><br>
            メールアドレス:<input type="text" name="mail"><br>
            電話番号:<input type="text" name="tell"><br>
            住所:<input type="text" name="address"><br>            
            <input type="submit" value="登録">
        </form>
</body>
</html>