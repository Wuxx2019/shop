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
  <script type="text/javascript">

      layui.config({
          base: '/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
      }).use(['table'],function(){
         var laypage = layui.laypage,
             table = layui.table ;//表格
          //执行一个 table 实例
          table.render({
              elem: '#demo'
              ,height: 420
              ,url: '/demo/table/user/' //数据接口
              ,title: '商品分类'
              ,page: true //开启分页
              ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
              ,cols: [[ //表头
                  {type: 'checkbox', fixed: 'left'}
                  ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                  ,{field: 'parent_id', title: '父类型id', width:80, sort: true}
                  ,{field: 'goodstype', title: '类型名称', width:80}
                  ,{field: 'mark', title: '类型描述', width: 90, sort: true, totalRow: true}
                  ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
              ]]
          });

          //监听头工具栏事件
          table.on('toolbar(test)', function(obj){
              var checkStatus = table.checkStatus(obj.config.id)
                  ,data = checkStatus.data; //获取选中的数据
              switch(obj.event){
                  case 'add':
                      layer.msg('添加');
                      break;
                  case 'update':
                      if(data.length === 0){
                          layer.msg('请选择一行');
                      } else if(data.length > 1){
                          layer.msg('只能同时编辑一个');
                      } else {
                          layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                      }
                      break;
                  case 'delete':
                      if(data.length === 0){
                          layer.msg('请选择一行');
                      } else {
                          layer.msg('删除');
                      }
                      break;
              };
          });

          //监听行工具事件
          table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
              var data = obj.data //获得当前行数据
                  ,layEvent = obj.event; //获得 lay-event 对应的值
              if(layEvent === 'detail'){
                  layer.msg('查看操作');
              } else if(layEvent === 'del'){
                  layer.confirm('真的删除行么', function(index){
                      obj.del(); //删除对应行（tr）的DOM结构
                      layer.close(index);
                      //向服务端发送删除指令
                  });
              } else if(layEvent === 'edit'){
                  layer.msg('编辑操作');
              }
          });
      });
  </script>
</html>