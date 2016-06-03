<%-- 
    Document   : loginResult
    Created on : 2015/11/09, 16:33:34
    Author     : g14931mh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User" %>
<%
//セッションスコープからユーザー情報を取得
User loginUser = (User)session.getAttribute("loginUser");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SHOPPING SITE</title>
    </head>
    <body bgcolor="#ffe4e1">
        <h1><font size="60" color="f08080">WELCOME</font></h1>
        <% if(loginUser != null){ %>
        <p>ログインに成功しました</p>
        <p>ようこそ！</p>
        <a href="/docoTsubu/Main">つぶやき投稿・閲覧へ</a>
        <% }else{ %>
        <p>ログインに失敗しました</p>
        <a href="/docoTsubu/">TOPへ</a>
        <% } %>
    </body>
</html>
