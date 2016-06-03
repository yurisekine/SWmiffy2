<%-- 
    Document   : main
    Created on : 2016/01/05, 12:39:41
    Author     : kaho
--%>
<%@page import="model.User"%>
<%@page import="model.Kl"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Kl kl = (Kl) session.getAttribute("klkl");
    User loginUser = (User) session.getAttribute("loginUser");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>かろつぶ</title>
    </head>
    <body>
        <h1>かろつぶメイン</h1>
        <%-- もしカロリー入力失敗してたらのやつもつくっておくこと,名前の横にカロリー、ギブアップボタン --%>
        <%--<% if (kl != null) { %>--%>
        <p>
            <c:out value="${loginUser.name}" />さん、ログイン中<br>
            <a href="/Kadai7/Logout">ログアウト</a><br>
            <a href="/Kadai7/GiveUp">これ以上食べない</a><br>
        </p>
        <p><a href="/Kadai7/Main">更新</a></p><br>
        <form action="/Kadai7/Main" method="post">
            <input type="text" name="text">
            <input type="submit" value="つぶやく">
        </form>
        <c:if test="${not empty errorMsg}">
            <p>${errorMsg}</p>
        </c:if>
        <c:forEach var="mutter" items="${mutterList}">
            <p><c:out value="${mutter.userName}" />:(<c:out value="${mutter.userkl}" />kl)
                <c:out value="${mutter.text}" /></p>
            </c:forEach>
        <%--<% } else { %>
        <p>カロリーが正しく入力されていません。</p>
        <a href="/Kadai7/jsp/klmain.jsp">カロリー入力へ戻る</a>
        <% } %>--%>
    </body>
</html>

