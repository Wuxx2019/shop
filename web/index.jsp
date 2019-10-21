<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2019/10/13
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>$Title$</title> <%@include file="/static/common/header.jsp"%>
  </head>
  <body>
  $END$
  </body>
   <script>
    let id = {
        el: '#id',
        data: {
        
        },
        created() {
            layui.use('code', function(){
            });
        },
        methods:{
            
        }
    };
    new Vue(id);
    </script>
</html>