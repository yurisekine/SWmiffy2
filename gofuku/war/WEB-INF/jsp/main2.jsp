<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/design.css">
        <title>呉服屋さん</title>
        <script type="text/javascript" src="lib.js"></script>
        <script type="text/javascript">
        <!--
        function callback(request){
            var json = eval(request.responseText);
            var res = '';
            if (json.length == 1){
                res += '<tr><td>' + json[0].id +'</td></tr>';
                res += '<tr><td>' + json[0].name +'</td></tr>';
                res += '<tr><td>' + json[0].clothes +'</td></tr>';
            } else {
                for (var i = 0;i < json.length;i++){
                    res += '<tr><td><a href="javascript:return false;" onclick="getData(' + json[i].id +');">' + json[i].id + '</a></td>';
                    res += '<td><a href="' + json[i].name + '">' + json[i].clothes + '</a></td>';
                }
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
        }
        //-->
        </script>
    </head>
    <body onload="getData(null);">
        <div id="header"></div>
        <div id="main">
        <table id="datatable" border="1">
        <tr>
        <td>wait..</td>
        </tr>
        </table>
<!--
            <c:forEach var="order" items="${orderList}" begin="0" end="0"> 
                <p><c:out value="${order.userName}" />:
                    <c:out value="${order.clothes}" />
                </c:forEach>--> <br />
                <h3>注文することができました</h3>
            <ul>
                <li><div class="btn2"><a href="../main">戻る</a></div></li>
            </ul>
        </div>
        <div id="footer"></div>
    </body>
</html>