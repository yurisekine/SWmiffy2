<%-- 
    Document   : home
    Created on : 2015/12/15, 10:37:50
    Author     : g14906hr
--%>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOVEマシーン♡</title>
    </head>
    <body background="heart.jpg">
        <h1>さんのホーム♡</h1>
        <!-- <a href="/ad0604/LogoutServlet">ログアウト♡</a><br><br> -->
        <a href="/talk.jsp">恋愛広場へ行くにはこちらへ♡</a><br><br>
        あなたに合った人を見つけましょう♡<br>
        見つけたい方は見つけるボタンを押してください♡<br><br>
        <form action="/ad0604/IntroduceServlet" method="post">
            <input type="submit" value="見つける">
        </form><br>
        <c:forEach var="account" items="${accountList}">
            <hr><p>♡<c:out value="${account.id}" />さん<br>
            生年月日：<c:out value="${account.birthYear}" />年
            <c:out value="${account.birthMonth}" />月
            <c:out value="${account.birthDay}" />日<br>
            年齢：<c:out value="${account.age}" />歳<br>
            身長：<c:out value="${account.height}" />cm<br>
            学歴：<c:out value="${account.education}" /><br>
            職業：<c:out value="${account.job}" /><br>
            年収：<c:out value="${account.money}" />万円以上<br>
            婚姻歴：<c:out value="${account.marrige}" /><br><br>
            希望年齢：<c:out value="${account.hfirstAge}" />歳～
            <c:out value="${account.hfinishAge}" />歳まで<br>
            希望身長：<c:out value="${account.hfirstHeight}" />cm～
            <c:out value="${account.hfinishHeight}" />cmまで<br>
            希望学歴：<c:out value="${account.heducation}" /><br>
            希望年収：<c:out value="${account.hmoney}" />万円以上<br>
            希望婚姻歴：<c:out value="${account.hmarrige}" /><br>
            ちょっとした自己紹介：<c:out value="${account.introduct}" /></p>
        </c:forEach>
    </body>
</html>
