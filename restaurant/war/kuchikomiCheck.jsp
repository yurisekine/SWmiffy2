<%-- 
    Document   : kuchikomiCheck
    Created on : 2015/12/23, 9:59:44
    Author     : g14940nm
--%>
<%@page import="java.util.List"%>
<%@page import="model.Kuchikomi"%>
<% List<Kuchikomi> kuchikomiList = (List<Kuchikomi>) request.getAttribute("kuchikomi"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>口コミ確認画面</title>
    </head>
    <body>
        <h1>口コミ確認</h1>
        <p>口コミ一覧</p>

         <% for (Kuchikomi k : kuchikomiList) { %>
            <span>
                評価：<%= k.getValue() %>　　
            コメント：<%= k.getText() %>
            </span><br>
        <% } %>
        <p> <a href="/RestaurantPair/Logout"> ログアウトへ</a></p>
        <p><a href="/RestaurantPair/StaffMain">戻る</a></p>
    </body>
</html>