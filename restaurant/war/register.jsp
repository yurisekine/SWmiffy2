<%-- 
    Document   : register
    Created on : 2015/12/22, 13:28:36
    Author     : g14940nm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザー登録</title>
    </head>
    <body>
        <form action="/RestaurantPair/RegisterMain" method="post">
            メールアドレス：<input type="text" name="mail"><br>
            パスワード：<input type="password" name="pass"><br>
            名前:<input type="text" name="name"><br>
            <input type="submit" value="登録">
        </form>
    </body>
</html>
