<%-- 
    Document   : registerForm
    Created on : 2015/01/14, 13:40:45
    Author     : g13953ts
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/design.css">
        <title>ユーザー登録</title>
    </head>
    <body>
        <div id="header"></div>
        <div id="main">
            <form action="../registerUser" method="post">
                <input type="text" name="userId" placeholder="ユーザーID"><br />
                <input type="password" name="pass" placeholder="パスワード"><br />
                <input type="text" name="mail" placeholder="アドレス"><br />
                <input type="text" name="name" placeholder="名前"><br />
                <input type="submit" value="確認">
            </form>
        </div>
        <div id="footer"></div>
    </body>
</html>
