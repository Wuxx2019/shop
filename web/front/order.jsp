<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/10/18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <base href="<%=basePath%>">
    <title>Title</title>
    <%@include file="/static/common/header.jsp"%>
    <link rel="stylesheet" href="/static/piugins1/bootstrap/bootstrap.min.css" />
    <link rel="stylesheet" href="/static/piugins1/layui/css/layui.css" />
    <link rel="stylesheet" href="/static/piugins1/awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="/static/piugins1/eleme-ui/index.css" />
    <link rel="stylesheet" href="/static/css/CivilMilitaryIntegration/ShoppingCartAdress.css" />
</head>
<body>
<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="#">首页</a>
        </p>
        <div class="sn-quick-menu">
            <div class="login"><a href="/front/login.jsp">登录</a></div>
            <div class="sp-cart"><a href="/front/shopcart.jsp">购物车</a><span>2</span></div>
        </div>
    </div>
</div>



<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="#" title="母婴商城">
                    <img src="static/image/logo.png">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="" class="layui-form" novalidate>
                    <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>


<div class="content content-nav-base shopcart-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="/front/commodity.jsp" class="active">所有商品</a>
                    <a href="/front/buytoday.jsp">今日团购</a>
                    <a href="/front/information.jsp">母婴资讯</a>
                    <a href="/front/about.jsp">关于我们</a>
                </div>
            </div>
        </div>
    </div>
<div class="row" id="myVue"  v-cloak>
    <div class="col-lg-10 col-lg-offset-1" ><br>
        <div class="contenter">
            <ul>
                <li>
                    <el-row>
                        <span class="addAddressCons">收货人信息</span>
                        <span class="addAddress" @click="AddressShowClick">新增收货地址</span>
                    </el-row>
                    <div class="scolleShow" >
                        <el-row  class="consignee" v-for="(items,index) in filterAddress"  >
                            <div v-on:mouseout="MouseOutList(items)" v-on:mouseleave="MouseOverList(items)">
                                <el-col :span='4'>
                                    <div class="consigneeList consigneeListWidth"  :class="{'consigneeListClick':items.addressDefult}" @click="currentIndexClick(items,index)">
                                        <span v-text="items.name"></span>
                                        <span v-text="items.city"></span>
                                        <div v-show="items.addressDefult">
                                            <div class="arrow-right"></div>
                                            <i class="fa fa-check" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </el-col>
                                <el-col class='rightAddress'  :span='20' :class='{BackColor:items.addressIsShow}'>
                                    <span v-text="items.name"></span>
                                    <span v-text="items.city"></span>
                                    <span v-text="items.area"></span>
                                    <span v-text="items.minarea"></span>
                                    <span v-text="items.phone"></span>
                                    <span v-if='items.isShowDefult' class="addressDefultClass">默认地址</span>
                                    <span v-if='items.addressIsShow' class='edmitAddre' >
									<span class='edmitSpan' @click="defultAddress(items)">设为默认地址</span>
									<span class='edmitSpan' @click="emitAddress(items,index)">编辑</span>
								</span>
								<span v-if='!items.isShowDefult' @click="deleAddressAlert(index)" class='edmitSpan edmitSpan-delete' >删除</span>
                                </el-col>
                                <div class="clearfix"></div>
                            </div>
                        </el-row>
                    </div>
                    <el-dialog>
                            title="新增收货地址"
                            :visible.sync="newAddressShow"
                            width="30%"
                    >
                        <el-form ref="form" :model="form" label-width="80px">
                            <el-form-item label="收货人" >
                                <el-input v-model="form.name" placeholder="请输入收货人姓名"></el-input>
                            </el-form-item>
                            <el-form-item label="地区" >
                                <el-input v-model="form.city" placeholder="请输入收货人地区"></el-input>
                            </el-form-item>
                            <el-form-item label="详细地址" >
                                <el-input v-model="form.minarea" placeholder="请输入收货人详细地址"></el-input>
                            </el-form-item>
                            <el-form-item label="手机号码" >
                                <el-input v-model="form.phone" placeholder="请输入收货人手机号码"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-checkbox-group v-model="form.isShowDefult">
                                    <el-checkbox  label="设为默认地址" name="type">设为默认地址</el-checkbox>
                                </el-checkbox-group>
                            </el-form-item>
                        </el-form>
                        <span slot="footer" class="dialog-footer">
							<el-button  type='danger' @click="dialogVisible = false">取 消</el-button>
							<el-button type="primary" @click="saveNewAdress(edmitType)">保存</el-button>
						</span>
                    </el-dialog>
                    <div v-if='!moreAddressData.length == 0' class="muchAddress">
						<span @click="moreAddress">更多地址
							<transition name="fade"  mode="out-in">
								<i key='up' v-if='isTranShow' class="fa fa-angle-double-down" ></i>
								<i key='down' v-else class="fa fa-angle-double-up" ></i>
							</transition>
						</span>
                    </div>
                    <div v-if='moreAddressData.length == 0' class="noAddress" >
                        <span>您还没有收货地址，请增加新的收货地址！</span>
                    </div>
                </li>
                <li>
                    <span class="addAddressCons">支付方式</span>
                    <div class="consignee">
						<span class="consigneeList" v-for="(paymentDatas,index) in paymentdatas" :class="{'consigneeListClick':paymentIndex == index}" @click="paymentIndex=index">
							<span v-text="paymentDatas.name"></span>
							<div v-show="paymentIndex == index">
								<div class="arrow-right"></div>
								<i class="fa fa-check" aria-hidden="true"></i>
							</div>
						</span>
                    </div>
                </li>
                <li>
                    <span class="addAddressCons">送货清单</span>
                    <span class="addAddress"><a href="/front/shopcart.jsp">返回修改购物车</a></span>
                    <div class="row deliverymode">
                        <div class="col-lg-3 deliverymodeLeft">
                            <p>配送方式：</p>
                            <div v-for="(deliverymodeDatas,index) in deliverymodedatas"  >
								<span class="consigneeList" @click="deliverymodeIndex=index" :class="{'consigneeListClick':deliverymodeIndex == index}">
									<span v-text="deliverymodeDatas.type" ></span>
									<div v-show="deliverymodeIndex == index">
										<div class="arrow-right"></div>
										<i class="fa fa-check" aria-hidden="true"></i>
									</div>
								</span>
                                <p class="deliverymodeLeftTit" v-text="deliverymodeDatas.name"></p>
                            </div>
                        </div>
                        <div class="col-lg-9 deliverymodeRight" >
                            <div class="layui-form">
                                <table class="layui-table">
                                    <tr>
                                        <td>
										<span class="goodName">
											<img class="goodImg" src="img/CivilMilitaryIntegration/CooperationZone/panner0.jpg" />
										</span>
                                            <span class="goodName goodsName">
											<h2 class="goodname"></h2>
											<p class="goodGary">
												<span>供应商：</span>
												<span>美国</span>
											</p>
											<p class="goodGary">
												<span>发货地：</span>
												<span>中国</span>
											</p>
										</span>
                                        </td>
                                        <td class="goodPrice">￥344534.00</td>
                                        <td class="goodNum">1</td>
                                    </tr>
                                    <tr>
                                        <td>
										<span class="goodName">
											<img class="goodImg" src="img/CivilMilitaryIntegration/CooperationZone/panner0.jpg" />
										</span>
                                            <span class="goodName goodsName">
											<h2 class="goodname"></h2>
											<p class="goodGary">
												<span>供应商：</span>
												<span>美国</span>
											</p>
											<p class="goodGary">
												<span>发货地：</span>
												<span>中国</span>
											</p>
										</span>
                                        </td>
                                        <td class="goodPrice">￥344534.00</td>
                                        <td class="goodNum">1</td>
                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>
                </li>
        </div>
        <div class="contenterFooter">
            <p>1件商品，1项服务，总金额：<span class="footerPrice">￥9600.00</span></p>
            <p>运费：<span class="footerPrice">￥100.00</span></p>
        </div>
        <div class="clearfix"></div>
        <div class="row footerRow">
            <span class="footerRowprice">应付金额：<span>￥9999.00</span></span>
            <span class="footerRowaddress"><span>商品收获地址：{{moreaddressCity + moreaddressArea + moreaddressMinarea}}</span><span>{{moreaddressName}}</span><span>13800138000</span></span>
        </div>
        <<button class="btn submitForm" @click="open"> 提交订单</button>
    </div>


</div>

<!--js类引用-->
<script type="text/javascript" src="/static/piugins1/layui/layui.js"></script>
<script type="text/javascript" src="/static/piugins1/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/static/piugins1/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/piugins1/vue/vue.js"></script>
<script type="text/javascript" src="/static/piugins1/eleme-ui/index.js"></script>
<script type="text/javascript" src="/static/js/CivilMilitaryIntegration/ShoppingCart.js"></script>
<!--<script type="text/javascript" src="js/CivilMilitaryIntegration/abc.js" ></script>-->

</body>
</html>
