<%-- 
    Document   : registerConfirm
    Created on : 2015/01/14, 13:40:10
    Author     : g13953ts
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User" %>
<% User registerUser = (User) session.getAttribute("registerUser");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/design.css">
        <title>ユーザー登録</title>
    </head>
    <body>
        <div id="header"></div>
        <div id="main">
            <p>下記のユーザーを登録します</p>
            <table class="confirm">
                <tbody>
                    <tr>
                        <th>ユーザーID：</th><td><%= registerUser.getUserId()%></td></tr>
                    <tr><th>パスワード：</th><td><%= registerUser.getPass()%></td></tr>
                    <tr><th>アドレス：</th><td><%= registerUser.getMail()%></td></tr>
                    <tr><th>名前：</th><td><%= registerUser.getName()%></td></tr>
                </tbody>
            </table><br />
            <ul class="menu2">
                <li><div class="btn2"><a href="../registerUser">戻る</a></div></li>
                <li><div class="btn2"><a href="../registerUser?action=done">登録</a></div></li>
            </ul>
        </div>
        <div id="footer"></div>

    </body>
</html>

