<%-- 
    Document   : search
    Created on : 2015/12/16, 16:38:13
    Author     : g14911ih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>履修登録</title>
<script type="text/javascript" src="lib.js"></script>
<script type="text/javascript">
        //<!--
        function callback(request){
            var json = eval(request.responseText);
            var res = '';
            if (json.length == 1){
                res += '<tr><td>' + json[0].className +'</td></tr>';
                res += '<tr><td>' + json[0].teacher +'</td></tr>';
                res += '<tr><td>' + json[0].explanation +'</td></tr>';
            } else {
                for (var i = 0;i < json.length;i++){
                	res += '<tr><td><a href="javascript:return false;" onclick="getData(' + json[i].id +');">' + json[i].id + '</a></td>';
                    res += '<td>' + json[i].className + '</td>' +
                    '<td>' + json[i].teacher+' </td>' +
                    '<td>' + json[i].term+' </td>' +
                    '<td>' + json[i].week+ json[i].period+' </td>' +
                    '<td>' + json[i].credit+' </td>' +
                    '<td>' + json[i].explanation +'</td>'+
                    '<td><a href ="add.jsp?id='+json[i].id + '">登録</a></td></tr>'
                }
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
        }
        //-->
        </script>
</head>
<body onload="getData(null);">
	<h1>授業を選択する</h1>
	<br>
	<a href="main">メニューへ</a>
	<br>
	<br>
	<table id="datatable" border="1">
		<tr>
			<td>wait...</td>
		</tr>
	</table>
	<br>
	<div>
	</div>
</body>
</html>