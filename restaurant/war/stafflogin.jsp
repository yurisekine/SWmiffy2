<%-- 
    Document   : stafflogin
    Created on : 2015/12/23, 10:07:43
    Author     : g14940nm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>スタッフログインページ</title>
    </head>
    <body>
        <h1>スタッフ専用ログインページ</h1>
        　 <form action="/RestaurantPair/StaffLogin" method="post">
メールアドレス:<input type="text" name="mail">

パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
    </body>
</html>
