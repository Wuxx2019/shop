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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户信息管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/plugins/layui/css/layui.css">
    <script src="/static/plugins/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<table id="userList" lay-filter="user"></table>
<script type="text/html" id="toolbarDemo">
    <a class="layui-btn layui-btn-normal" lay-event="add">添加</a>
    <a class="layui-btn layui-btn-primary" lay-event="btn-expand">全部展开</a>
    <a class="layui-btn layui-btn-primary" lay-event="btn-fold">全部折叠</a>
    <a class="layui-btn layui-btn-primary" lay-event="btn-refresh">刷新表格</a>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i></a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i></a>
</script>
</body>
<script type="text/javascript">
    layui.use('table', function(){
        let  table = layui.table;//表格
        //执行一个 table 实例
        table.render({
            elem: '#userList'
            ,method:'POST'
            ,where:{adminData:'PAGE'}
            ,url: '/adminData.do' //数据接口
            ,cols: [[
                {type:'checkbox'}
                ,{field:'id', width:80, title: 'ID', sort: true}
                ,{field:'username', width:80, title: '用户名'}
                ,{field:'password', width:80, title: '性别', sort: true}
                ,{field:'realname', width:80, title: '城市'}
                ,{field:'cardid', title: '签名', minWidth: 150}
                ,{field:'birthday', width:80, title: '积分', sort: true}
                ,{field:'phone', width:80, title: '评分', sort: true}
                ,{field:'userInfo', width:80, title: '职业'}
            ]]
            ,page: true
        });

    });
</script>
</html>