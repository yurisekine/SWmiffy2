<%-- 
    Document   : index
    Created on : 2015/11/09, 16:32:44
    Author     : g14931mh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SHOPPING SITE</title>
    </head>
    <body bgcolor="#ffe4e1">
        <h1><font size="60" face="Impact" color="f08080">SHOPPING SITE</font></h1>
        <form action="/docoTsubu/Login" method="post">
            ユーザ名：<input type="text" name="name"><br>
            パスワード：<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
             <p>まだ会員ではありませんか？<a href="/docoTsubu/UserAddServlet">ユーザー登録 </a></p>
        </form>
    </body>
</html>
