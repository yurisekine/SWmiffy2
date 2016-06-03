<%-- 
    Document   : money
    Created on : 2016/01/07, 14:18:56
    Author     : g14944sy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>給料確認</title>
    </head>
    <body>
        
        <p><c:out value="${name}"/>　さん<br> 時給<c:out value="${salary}" />円、<br>
            総労働時間　<c:out value="${time}" />時間、<br>
            1月の給料は　<c:out value="${allmoney}" />　円です。お疲れ様です。</p>        
        <p> </p>
        
        <a href="attend.jsp">勤怠入力画面へ</a>
        <a href="/top.jsp">トップへ</a>
    </body>
</html>
