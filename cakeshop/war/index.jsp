<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ケーキ屋さん</title>
</head>
<body>
<h1>ケーキ屋さんへようこそ</h1>
        <h3>ケーキ全品税込１００円そして送料無料！！！！！！</h3>
        <form action ="/cakeshop/OrderServlet" method ="post">
            <p><input type="radio" name="cakeName" value="ショートケーキ">ショートケーキ
            <input type="radio" name="cakeName" value="チョコレートケーキ">チョコレートケーキ
            <input type="radio" name="cakeName" value="チーズケーキ">チーズケーキ
            <input type="radio" name="cakeName" value="ロールケーキ">ロールケーキ
            <input type="radio" name="cakeName" value="シュークリーム">シュークリーム</p>
            個数：<input type="text" name="number">
            <input type="submit" value="注文">
        </form>
</body>
</html>