<%-- 
    Document   : klmain
    Created on : 2016/01/05, 12:33:59
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
        <h1>カロリー入力</h1>
        <form action="/Kadai7/KlMain" method="post">
            <p>前回入力した時以降の総カロリーを入力して下さい。</p>
            <p>カロリーを摂取していない場合は0を入力してください。</p>
            摂取したカロリー：<input type="text" name="kl"><br>
            <input type="submit" value="カロリー入力"><br>
        </form>
    </body>
</html>
