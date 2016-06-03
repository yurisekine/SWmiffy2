<%-- 
    Document   : account
    Created on : 2016/01/05, 12:07:02
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
        <h2>ユーザー登録</h2>
        <form action="/Kadai7/Account" method="post">
            ID：<input type="text" name="id"><br>
            パスワード：<input type="password" name="pass"><br>
            <input type="submit" value="ユーザー登録">
        </form>
    </body>
</html>