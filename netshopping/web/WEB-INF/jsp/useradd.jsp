<%-- 
    Document   : useradd
    Created on : 2016/01/15, 19:31:15
    Author     : g14931mh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>SHOPPING SITE</title>
    </head>
    <body bgcolor="#ffe4e1">
        登録するユーザについての情報を入力してください。
        
        <form action="/docoTsubu/UserAddServlet" method="post">
           ユーザーID:<input type="text" name="userId"><br>
            パスワード:<input type="password" name="pass"><br>
               メールアドレス:<input type="text" name="mail"><br>
          名前:<input type="text" name="name"><br>
            年齢:<input type="text" name="age"><br>
            <input type="submit" value="ユーザ登録">
        </form>

    </body>

</html>
