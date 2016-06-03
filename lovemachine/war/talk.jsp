<%-- 
    Document   : talk
    Created on : 2015/12/15, 10:48:22
    Author     : g14906hr
--%>

<%-- @page import="model.Account" --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
     "http://www.w3.org/TR/html4/loose.dtd">
    
<html>


<script type="text/javascript" src="lib.js"></script>
        <script type="text/javascript">
        <!--
        function callback(request){
            var json = eval(request.responseText);
            var res = '';
            if (json.length == 1){
                res += '<tr><td>' + json[0].id +'</td></tr>';
                res += '<tr><td>' + json[0].title +'</td></tr>';
                res += '<tr><td>' + json[0].url +'</td></tr>';
                //res += '<tr><td>' + json[0].comment +'</td></tr>';
            } else {
                for (var i = 0;i < json.length;i++){
                    //res += '<tr><td><a href="javascript:return false;" onclick="getData(' + json[i].id +');">' + json[i].id + '</a></td>';
                    res += '<tr><td>'+json[i].title +'</td>' +  '<td>'+json[i].url +'</td></tr>';
                   // '<td><a href="edit.html?id=' + json[i].id + '">Edit</td>' +
                    //'<td><a href="del.html?id=' + json[i].id + '">Delete</td></tr>';
                }
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
        }
        //-->
        </script>



<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOVEマシーン♡</title>
    </head>
    <body  background="heart.jpg" onload="getData(null);">
        <h1>恋愛広場♡</h1>
      
        <a href="/homereturn">戻る</a></p>


<table>
        <form method="post" action="/mutter">
            <tr><th>UserID:</th><td><input type="text" name="title"></td></tr>
            <tr><th>Comment:</th><td><input type="text" name="url"></td></tr>
            <!-- <tr><th>COMMENT:</th><td><textarea name="comment"></textarea></td></tr> -->
            <tr><th></th><td><input type="submit" value="会話を送信する"></td></tr>
        </form>
        </table>


    
    <table id="datatable" border="1">
      <tr>
        <td>wait...</td>
      </tr>
    </table>






    </body>
</html>