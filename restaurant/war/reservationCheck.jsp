<%-- 
    Document   : reservationCheck
    Created on : 2015/12/23, 10:06:11
    Author     : g14940nm
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>予約状況確認ページ</title>
        <script type="text/javascript" src="lib.js"></script>
        <script type="text/javascript">
        
      function callback(request){
            var json = eval(request.responseText);
            var res = '';
            if (json.length == 1){
                res += '<tr><td>' + json[0].id +'</td></tr>';
                res += '<tr><td>' + json[0].name +'</td></tr>';
                res += '<tr><td>' + json[0].mail +'</td></tr>';
                res += '<tr><td>' + json[0].reserveDate +'</td></tr>';
            } else {
                for (var i = 0;i < json.length;i++){
                    res += '<tr><td><a href="javascript:return false;" onclick="getData(' + json[i].id +');">' + json[i].id + '</a></td>';
                    res += '<td>'+json[i].name + '</td><td>'+json[i].mail +'</td><td>'+ json[i].reserveDate+'</td>' ;
                }
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
        }
       
        </script>
    </head>
    <%--<body>
         <h1>＜店用＞予約状況</h1>
        <p>予約一覧</p>
        <% for (Reserve r : reserveList) {%>
        <span>
            日付：<%= r.getDate()%>　　
            お名前：<%= r.getName()%>　　
            メールアドレス：<%= r.getMail()%>
        </span><br>
        <% }%>
        <p> <a href="/RestaurantPair/Logout"> ログアウトへ</a></p>
        <p><a href="/RestaurantPair/StaffMain">戻る</a></p>
    </body>--%>
    <body onload="getData(null);">
    <h1>データの表示</h1>
     
    <table id="datatable" border="1">
      <tr>
        <td>wait...</td>
      </tr>
    </table>
    <br>
  </body>
</html>
