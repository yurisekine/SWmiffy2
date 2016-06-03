<%-- 
    Document   : loginOK
    Created on : 2015/12/09, 13:51:10
    Author     : g14944sy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン</title>
    </head>
    <body>
        <p>ようこそ<c:out value="${name}"/>さん</p>
        <a href="/attend.jsp">勤怠入力画面へ</a>
        <a href="/money.jsp">給料確認画面へ</a>
        <a href="/top.jsp">トップへ</a>
    </body>
</html>
