<%-- 
    Document   : loginOK
    Created on : 2014/12/22, 16:54:15
    Author     : g13953ts
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/design.css">
        <title>呉服屋さん</title>
    </head>
    <body>
        <div id="header"></div>
        <div id="main">
            <p>ようこそ<c:out value="${userId}" />さん</p><br />
            <ul>
                <li><div class="btn2"><a href="/db5453/WelcomServlet">トップへ</a></div></li>
                <li><div class="btn2"><a href="/db5453/Main">ショップへ</a></div></li>
            </ul>
        </div>
        <div id="footer"></div>
    </body>
</html>
