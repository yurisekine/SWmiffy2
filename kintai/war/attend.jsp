<%-- 
    Document   : attend
    Created on : 2016/01/07, 13:49:38
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
        
        <p>ログイン中</p><br>
        <br>
        勤務時間の情報を入力してください。<br>
     <table>   
        <form action="/attend" method="post">
            日付　　:<input type="text" name="day">
            　（例）1月1日→0101　と入力<br>
            労働時間:<input type="text" name="time">
            　 15分刻みで入力してください。
            　（例）1時間30分→1.5　と入力<br>
            <input type="submit" value="登録">
        </form>    
        </table>            
    </body>
</html>
