<%--
    Document   : main
    Created on : 2015/11/09, 16:33:59
    Author     : g14931mh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shopping site</title>
    </head>
    <body bgcolor="#ffe4e1">
        <h1><font size="60" color="f08080">shopping site</font></h1>
        <p>
            ログイン中
            <a href="/docoTsubu/Logout">ログアウト</a><a href="/docoTsubu/Main">更新</a><br>
               <a>きになる商品をクリックして注文しよう！</a>
            
           
        <form action="/docoTsubu/Main" method="post">
            <input type="text" name="text">
            <input type="submit" value="つぶやく">
        </form>
        
        <c:if test="${not empty errorMsg}">
            <p>${errorMsg}</p>
        </c:if>
            <c:forEach var="mutter" items="${mutterList}">
                <p><c:out value="${mutter.userName}" />:
                <c:out value="${mutter.text}" /></p>
            </c:forEach>
            
         
            
        </p>
        <%---
        <p><a href="/finalshopping/Main">更新</a></p>
        <form action="/finalshopping/Main" method="post">
        --%>
<a>
    <a href="/docoTsubu/Thanks"><img src="http://4.bp.blogspot.com/-buopaEekCK0/UO1Dq039R0I/AAAAAAAAKfM/T28Kw-CFyoo/s1600/sentaku_senzai.png" alt="写真" title="洗剤セット" width="200" height="200" border="0"></a>洗剤セット
                  <a href="/docoTsubu/Thanks"><img src="http://4.bp.blogspot.com/-z8yGQ-njKfE/VVGV36aNonI/AAAAAAAAtqI/--fZKmk4oxA/s800/sentaku_kona.png" alt="写真" title="粉末洗剤" width="200" height="200" border="0"></a>粉末洗剤
                  <a href="/docoTsubu/Thanks"><img src="http://3.bp.blogspot.com/-231AkGPgOto/U9zB2yZ8qeI/AAAAAAAAjo8/oMxt1cgS16w/s800/sentaku_junanzai.png" alt="写真" title="柔軟剤" width="200" height="200" border="0"></a>柔軟剤
                  <a href="/docoTsubu/Thanks"><img src="http://3.bp.blogspot.com/-gd_sUNW5DzM/Uf8zy6ipmxI/AAAAAAAAWyI/hUAqZ5YzvZo/s800/sentaku_hyouhakuzai.png" alt="写真" title="漂白剤" width="200" height="200" border="0"></a>漂白剤
                  <a href="/docoTsubu/Thanks"><img src="http://3.bp.blogspot.com/-GpuPh70wflY/UsZtIQZXddI/AAAAAAAAcx4/VNMwPMfHdA4/s800/hamigakiko.png" alt="写真" title="歯磨き粉" width="200" height="200" border="0"></a>歯磨き粉
                  <a href="/docoTsubu/Thanks"><img src="http://2.bp.blogspot.com/-a0WTZ-aViOg/Uf8zMXshmFI/AAAAAAAAWqU/Nt9FHDlspCI/s800/ofuro_shampoo.png" alt="写真" title="シャンプー" width="200" height=250" border="0"></a>シャンプー
                  <a href="/docoTsubu/Thanks"><img src="http://4.bp.blogspot.com/-s2DIdgMTMRI/Uf8zLphemgI/AAAAAAAAWp4/8dCAApmFFbY/s800/ofuro_rinse.png" alt="写真" title="リンス" width="200" height="250" border="0"></a>リンス
                  <a href="/docoTsubu/Thanks"><img src="http://2.bp.blogspot.com/-9co3lc3GWc4/Udy64YfTlZI/AAAAAAAAWPg/Wa9au9pzBuU/s800/ofuro_nyuyokuzai.png" alt="写真" title="入浴剤" width="200" height="200" border="0"></a>入浴剤


            </a>
        </form>
        
      
        </body>
</html>
<%--
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>どこつぶ</title>
    </head>
    <body bgcolor="#ffe4e1">
        <h1><font size="60" color="f08080">どこつぶメイン</font></h1>
        <p>
            <c:out value="${loginUser.name}" />さんログイン中
            <a href="/docoTsubu/Logout">ログアウト</a>
        </p>
        <p><a href="/docoTsubu/Main">更新</a></p>
        <form action="/docoTsubu/Main" method="post">
            <input type="text" name="text">
            <input type="submit" value="つぶやく">
        </form>
        
        <c:if test="${not empty errorMsg}">
            <p>${errorMsg}</p>
        </c:if>
            <c:forEach var="mutter" items="${mutterList}">
                <p><c:out value="${mutter.userName}" />:
                <c:out value="${mutter.text}" /></p>
            </c:forEach>
        </body>
</html>
--%>