<%-- 
    Document   : index
    Created on : 2016/01/05, 11:57:07
    Author     : kaho
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>かろつぶ</title>
    </head>
    <body>
        <h1>かろつぶへようこそ</h1>
        <form action="/kadai7/Login" method="post">
            ID：<input type="text" name="id"><br>
            パスワード：<input type="password" name="pass"><br>
            <input type="submit" value="ログイン"><br>
        </form>
        ユーザー登録がお済みでない方は<a href="/jsp/account.jsp">こちらへ</a>
    </body>
</html>

