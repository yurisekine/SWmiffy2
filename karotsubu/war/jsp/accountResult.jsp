<%-- 
    Document   : accountResult
    Created on : 2016/01/05, 12:18:59
    Author     : kaho
--%>


<%@page import="model.User"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>かろつぶ</title>
    </head>
    <body>
        <h1>かろつぶユーザー登録結果</h1>
        <% if(loginUser != null){ %>
        <p>ユーザー登録に成功しました</p>
        <p>ようこそ<%= loginUser.getName() %>さん</p>
        <a href="/Kadai7/klmain">カロリー入力へ</a>
        <% } else { %>
        <p>ユーザー登録に失敗しました</p>
        <a href="/Kadai7/">TOPへ</a>
        <% } %>
    </body>
</html>
