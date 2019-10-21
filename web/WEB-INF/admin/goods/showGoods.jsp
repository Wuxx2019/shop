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
    <title>$Title$</title>
      <%@include file="/static/common/header.jsp"%>
  </head>
  <body>
  <table class="layui-hide" id="demo" lay-filter="test"></table>

  <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  </script>
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