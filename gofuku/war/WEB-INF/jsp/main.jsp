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
            <h1>呉服屋さんメイン</h1>
            <p>
                ゲストさん、ログイン中
                <a href="../logout"> (ログアウト)</a><br /><br />
            </p>
            <p>商品を一つだけ選択してください</p>
            <p>商品を選択したら注文確定ボタンを押してください</p>
            <p>
            <form action="../main" method="post">
                <img src="wahuku.jpg" width="140" height="140" >
                <input type="checkbox" name="clothes[1]" value="和服">和服
                <img src="wahuku2.jpg" width="140" height="140" >
                <input type="checkbox" name="clothes[2]" value="和服2">和服2
                <img src="wahuku3.jpg" width="140" height="140" >
                <input type="checkbox" name="clothes[3]" value="和服3">和服3
                <img src="wahuku4.jpg" width="140" height="140" >
                <input type="checkbox" name="clothes[4]" value="和服4">和服4
                <img src="wahuku5.jpg" width="140" height="140" >
                <input type="checkbox" name="clothes[5]" value="和服5">和服5<br /><br />
                <input type="submit" value="注文確定">
            </form>
        </div>
        <div id="footer"></div>
    </body>
</html>
