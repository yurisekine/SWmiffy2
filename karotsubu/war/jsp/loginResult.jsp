<%-- 
    Document   : loginResult
    Created on : 2016/01/05, 13:05:55
    Author     : kaho
--%>


<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
User ansUser = (User) session.getAttribute("ansUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>かろつぶ</title>
    </head>
    <body>
        <h1>かろつぶログイン</h1>
        <% if(loginUser != null){ %>
        <p>ログインに成功しました</p>
        <p>ようこそ<%= ansUser.getName() %>さん</p>
        <a href="/Kadai7/jsp/klmain.jsp">カロリー入力へ</a>
        <%-- <% } else if(ansUser.getId() != loginUser.getId()){ %>
        <p>IDがちがいます。</p>
        <a href="/Kadai7">TOPへ</a>--%>
        <% } else { %>
        <p>ログインに失敗しました。</p>
        <a href="/Kadai7">TOPへ</a>
        <% } %> 
    </body>
</html>
