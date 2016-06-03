<%-- 
    Document   : login
    Created on : 2015/12/07, 17:35:53
    Author     : g14940nm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <form action="/RestaurantPair/LoginServlet" method="post">
            メールアドレス:<input type="text" name="mail"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
            <a href="/RestaurantPair/RegisterMain">ユーザー登録</a>
        </form>
    </body>
</html>
