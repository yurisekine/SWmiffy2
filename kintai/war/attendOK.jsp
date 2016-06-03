<%-- 
    Document   : attendOK
    Created on : 2016/01/07, 13:54:59
    Author     : g14944sy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>給料管理</title>
    </head>
    <body>
        <p><c:out value="${name}"/>さん、</p>           

        日付、労働時間を登録しました。
        <p>
            <a href="money.jsp">給料確認画面へ</a>
            <a href="top.jsp">トップ画面に戻る</a>
        </p>
    </body>
</html>
