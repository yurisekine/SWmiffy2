<%-- 
    Document   : login
    Created on : 2015/12/09, 13:48:46
    Author     : g14944sy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>給料管理</title>
    </head>
    <body>
        <form action="/salarymanagement/LoginServlet" method="post">
            名前　　　:<input type="text" name="name"><br>
            従業員No.:<input type="text" name="userId"><br>
            Pass　　　:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
