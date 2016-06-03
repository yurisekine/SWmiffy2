<%-- 
    Document   : kuchikomi
    Created on : 2015/12/23, 9:56:06
    Author     : g14940nm
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>口コミ投稿画面</title>
    </head>
    <body>
        <form action="/RestaurantPair/KuchikomiMain" method="post">
            <h1>口コミフォーム</h1>
            <p>評価</p>
            <select name="hyouka">

                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
            </select>
            <p>自由記入欄</p>

            <textarea name="msg" cols=40 rows=4>

            </textarea>
            <input type="submit" value="投稿">
        </form>
<p> <a href ="/RestaurantPair/Main">メインへ</a></p>
    </body>
</html>
