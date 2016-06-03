<%-- 
    Document   : login
    Created on : 2015/12/21, 16:37:56
    Author     : g14958ym
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>GoGo壱番屋</title>
    </head>
    <body bgcolor="#ffd700">
        <br>
        <br>
    <center>
        <h2><font face="メイリオ" color="#6a1917"><em>GoGo壱番屋</em> 会員様ログイン</font></h2>
        <form action="/login" method="post">
            ユーザーID:<input type="text" name="userId"><br><br>
            パスワード:<input type="password" name="pass"><br><br>
            <input type="submit" value="ログイン">
        </form>
    </center>
    
</body>
</html>