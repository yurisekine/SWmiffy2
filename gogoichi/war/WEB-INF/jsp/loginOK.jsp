<%-- 
    Document   : loginOK
    Created on : 2015/12/22, 13:14:00
    Author     : Mari
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>GoGo壱番屋</title>
    </head>
    <body bgcolor="#ffd700">
        <center>
        <br>
        <p>ようこそ！<c:out value="${userId}"/>さん</p>
        <a href="/ad5807/SelectServlet">商品選択へ</a><br><br>
        </center>
    </body>
</html>