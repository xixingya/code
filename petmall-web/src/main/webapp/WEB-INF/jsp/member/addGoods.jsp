<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/theme.css">
	<style>
#footer {
    padding: 15px 0;
    background: #fff;
    border-top: 1px solid #ddd;
    text-align: center;
}
#topcontrol {
  color: #fff;
  z-index: 99;
  width: 30px;
  height: 30px;
  font-size: 20px;
  background: #222;
  position: relative;
  right: 14px !important;
  bottom: 11px !important;
  border-radius: 3px !important;
}

#topcontrol:after {
  /*top: -2px;*/
  left: 8.5px;
  content: "\f106";
  position: absolute;
  text-align: center;
  font-family: FontAwesome;
}

#topcontrol:hover {
    color: #fff;
    background: #18ba9b;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}

.label-type, .label-status, .label-order {
    background-color: #fff;
    color: #f60;
    padding : 5px;
    border: 1px #f60 solid;
}
#typeList  :not(:first-child) {
    margin-top:20px;
}
.label-txt {
    margin:10px 10px;
    border:1px solid #ddd;
    padding : 4px;
    font-size:14px;
}
.panel {
    border-radius:0;
}

.progress-bar-default {
    background-color: #ddd;
}
.tagclass.active {
    background-color: #f60; 
}
	</style>
  </head>
  <body>
 <div class="navbar-wrapper">
      <div class="container">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			  <div class="container">
				<div class="navbar-header">
				  <a class="navbar-brand" href="index.html" style="font-size:32px;">尚意购-创意产品购物平台</a>
				</div>
            <div id="navbar" class="navbar-collapse collapse" style="float:right;">
              <ul class="nav navbar-nav">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> 张三<span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="member.html"><i class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                    <li class="divider"></li>
                    <li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                  </ul>
                </li>
                <li><a href="mycart.html"><i class="glyphicon glyphicon-shopping-cart"></i> 购物车<span class="label label-danger">42</span></a></li>
              </ul>
            </div>
			  </div>
			</nav>
      </div>
    </div>

    <div class="container theme-showcase" role="main">

        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li>
                                    <a rel="nofollow" href="index.html"><i class="glyphicon glyphicon-home"></i> 首页</a>
                                </li>
                                <li >
                                    <a rel="nofollow" href="projects.html"><i class="glyphicon glyphicon-th-large"></i> 商品总览</a>
                                </li>
                                <li class="active">
                                    <a rel="nofollow" href="javascript:;"><i class="glyphicon glyphicon-edit"></i> 发布商品</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        
        
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="panel panel-default" >
                        <div class="panel-body">
<div class="container-fluid">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
				<b>
					商品及商家信息
				</b>
			</blockquote>
		</div>
		<div class="col-md-12 column">
			<div class="page-header" style="    border-bottom-style: dashed;">
				<h3>
					商品信息
				</h3>
			</div>
            <form id="goodsForm" action="${APP_PATH}/member/insertGoods" method="post" enctype="multipart/form-data" class="form-horizontal">
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">分类信息</label>
                <div class="col-sm-10">
                    <c:forEach items="${gcs}" var="gc" >
                     <label class="radio-inline">
                      <input type="radio" name="categoryid" id="categoryid" value="${gc.id}"> ${gc.name}
                    </label>
                    </c:forEach>
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">标签</label>
                <div class="col-sm-10">
                    <ul style="list-style:none;padding-left:0;">
                        <c:forEach items="${rootTag.children}" var="tag">
	                        <li style="margin:10px 0">[${tag.name}]
	                            <c:forEach items="${tag.children}" var="childTag">
	                                <span class="tagclass label-txt" style="cursor: pointer;">${childTag.name}</span>
	                                <input style="display:none;" type="checkbox" name="tags" value="${childTag.id}">
	                            </c:forEach>
	                        </li>
                        </c:forEach>
                    </ul>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">商品名称</label>
                <div class="col-sm-10">
                  <input type="text" name="name" class="form-control" >
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">一句话简介</label>
                <div class="col-sm-10">
                  <textarea name="remark" class="form-control" rows="5"></textarea>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">金额（元）</label>
                <div class="col-sm-10">
                  <input type="text" name="price" class="form-control" style="width:100px;" >
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">库存</label>
                <div class="col-sm-10">
                  <input type="text" name="stock" class="form-control" value="0" style="width:100px;" >
                  <label class="control-label">未设置，表示无限制</label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">商品头图</label>
                <div class="col-sm-10">
                  <button id="headerImgBtn" type="button" class="btn btn-primary btn-lg active">上传图片</button>
                  <input style="display:none;" type="file" name="goodsHeadImg">
                  <label class="control-label">图片上无文字,支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：740*457px</label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">商品详情</label>
                <div class="col-sm-10">
                  <button id="imgBtn" type="button" class="btn btn-primary btn-lg active">上传图片</button>
                  <input style="display:none;" type="file" name="goodsDetailImg">
                  <label class="control-label">支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：宽740px</label>
                </div>
              </div>
		</div>
		<div class="col-md-12 column">
			<div class="page-header" style="    border-bottom-style: dashed;">
				<h3>
					商家信息
				</h3>
			</div>
              <div class="form-group">
                <label class="col-sm-2 control-label">自我介绍</label>
                <div class="col-sm-10">
                  <input type="text" name="introduce" class="form-control" placeholder="一句话自我介绍，不超过40字">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">详细自我介绍</label>
                <div class="col-sm-10">
                  <textarea class="form-control" name="siremark" rows="5" placeholder="向支持者详细介绍你自己或你的团队及商品背景，让支持者在最短时间内了解你，不超过160字"></textarea>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-10">
                  <input type="text" name="tel" class="form-control" placeholder="">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">客服电话</label>
                <div class="col-sm-10">
                  <input type="text" name="cstel" class="form-control" placeholder="">
                </div>
              </div>
            </form>
		</div>
	</div>
</div>
                        </div>
                        <div class="panel-footer" style="text-align:center;">
                            <button type="button" class="btn  btn-warning btn-lg" onclick="doSubmit()">提交</button>
                            <button type="button" class="btn  btn-warning btn-lg" onclick="window.location.href='index.html'">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        <div class="container" style="margin-top:20px;">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div id="footer">
                        <div class="footerNav">
                             <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a rel="nofollow" href="http://www.layoutit.cn">服务条款</a> | <a rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a rel="nofollow" href="http://www.layoutit.cn">网站地图</a> | <a rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                        </div>
                        <div class="copyRight">
                            Copyright ?2017-2017layoutit.cn 版权所有
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
      
    </div> <!-- /container -->
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
    <script src="${APP_PATH}/script/back-to-top.js"></script>
	<script>
	$('#myTab a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
	
	$(function(){
		// 如何click方法增加参数，表示绑定，
		$("#headerImgBtn").click(function(){
			// this是当前元素的DOM对象
			// JQuery[0] ==> DOM
			// $(DOM) ==> JQuery
			var fileObj = $(this).next();
			//alert(fileObj);
			// 点击元素，click方法不传递任何参数
			fileObj.click();
			
			// $("#loginacct").val()
			// $("#loginacct").val("123");
		});
		
		$("#imgBtn").click(function(){
			var fileObj = $(this).next();
			fileObj.click();
		});
		
		$(".tagclass").click(function(){
			$(this).toggleClass("active");
			$(this).next()[0].checked = $(this).hasClass("active");
		});
	})
	
	function doSubmit() {
		$("#goodsForm").submit();
	}
	</script>
  </body>
</html>