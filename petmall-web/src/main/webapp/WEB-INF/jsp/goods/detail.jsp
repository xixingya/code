<%@page pageEncoding="UTF-8"%>
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
.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
    border-bottom-color: #ddd;
}
.nav-tabs>li>a {
    border-radius: 0;
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
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> ${loginMember.loginacct}<span class="caret"></span></a>
             <ul class="dropdown-menu" role="menu">
                    <li><a href="${APP_PATH}/member.html"><i class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                    <li class="divider"></li>
                    <li><a href="${APP_PATH}/index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                  </ul>
                </li>
                <li><a href="${APP_PATH}/member/cart"><i class="glyphicon glyphicon-shopping-cart"></i> 购物车<span class="label label-danger">42</span></a></li>
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
                                    <a rel="nofollow" href="${APP_PATH}/index.html"><i class="glyphicon glyphicon-home"></i> 首页</a>
                                </li>
                                <li >
                                    <a rel="nofollow" href="${APP_PATH}/goods/detail/${goods.id}"><i class="glyphicon glyphicon-th-large"></i> 商品总览</a>
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
                    <div class="jumbotron nofollow" style="    padding-top: 10px;">
                        <h3>${goods.name}</h3>
                        <div style="float:left;width:70%;">${goods.remark}</div>
                        <div style="float:right;">
                            <button type="button" class="btn btn-default"><i style="color:#f60" class="glyphicon glyphicon-heart"></i> 关注 ${goods.goodsInfo.favcnt}</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-8 column">
                            <img alt="140x140" width="740" src="${APP_PATH}/img/goods/${goods.iconpath1}" />
                           
                        </div>
                        <div class="col-md-4 column">
                            <div class="panel panel-default" style="border-radius: 0px;">
                                <div class="panel-heading" style="background-color: #fff;border-color: #fff;">
                                    <span class="label label-success"><i class="glyphicon glyphicon-tag"></i> 热卖中</span>
                                </div>
                                <div class="panel-body">
                                    <h3 >
                                        金额：￥<span style="color:red;">${goods.price}</span>
                                    </h3>
                                    <div>
                                     <p><span>已有629人购买该商品</p>
                                     <button type="button" class="btn  btn-warning btn-lg btn-block" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-shopping-cart"></i> 加入购物车</button>
                                    </div>
                                </div>
                                <div class="panel-footer" style="    background-color: #fff;
                                    border-top: 1px solid #ddd;
                                    border-bottom-right-radius: 0px;
                                    border-bottom-left-radius: 0px;">
                                <div class="container-fluid">
                                    <div class="row clearfix">
                                        <div class="col-md-3 column" style="padding:0;">
                                <img alt="140x140" src="${APP_PATH}/img/services-box2.jpg" data-holder-rendered="true" style="width: 80px; height: 80px;">
                                </div>
                                <div class="col-md-9 column">
                                    <div class="">
                                        <h4>
                                            <b>${goods.sellerInfo.introduce}</b> <span style="float:right;font-size:12px;" class="label label-success">已认证</span>
                                        </h4>
                                        <p style="font-size:12px">${goods.sellerInfo.remark}</p>
                                        <p style="font-size:12px">
                                        客服电话:${goods.sellerInfo.cstel}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
					<div class=" panel panel-default" style="border-radius: 0px;">
						<div class="panel-heading">
							<h3 >
								风险提示
							</h3>
						</div>
						<div class="panel-body">
                            <p>互联网金融交易存在风险，基于买卖双方的自愿，请谨慎决定是否继续执行交易内容。</p>
						</div>
					</div>
                    
                    <div><h2>为你推荐</h2><hr></div>
					<div class="prjtip panel panel-default" style="border-radius: 0px;">
						<div class="panel-body">
                            <img src="img/product-3.png" width="100%" height="100%">
						</div>
					</div>
                    
					<div class="prjtip panel panel-default" style="border-radius: 0px;">
						<div class="panel-body">
                            <img src="img/product-4.jpg" width="100%" height="100%">
						</div>
					</div>
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
                             <a rel="nofollow" href="http://www.atguigu.com">关于我们</a> | <a rel="nofollow" href="http://www.atguigu.com">服务条款</a> | <a rel="nofollow" href="http://www.atguigu.com">免责声明</a> | <a rel="nofollow" href="http://www.atguigu.com">网站地图</a> | <a rel="nofollow" href="http://www.atguigu.com">联系我们</a>
                        </div>
                        <div class="copyRight">
                            Copyright ?2010-2014atguigu.com 版权所有
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
      
    </div> <!-- /container -->
    
    
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
      <div class="modal-dialog "  style="width:480px;height:220px;" role="document">
        <div class="modal-content" data-spy="scroll" data-target="#myScrollspy">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">请输入购买数量</h4>
          </div>
          <div class="modal-body">
<div class="container-fluid">
	<div class="row clearfix">
		<div id="navList" class="col-sm-9 col-md-9 column" style="height:220px;overflow-y:auto;">
            <h2 id="section-1" style="border-bottom:1px dashed #ddd;" ><span style="font-size:20px;font-weight:bold;">￥${goods.price}</span><span style="font-size:12px;margin-left:60px;">剩余库存：${goods.stock}</span></h2>
            <p>配送费用：全国包邮</p>
            <p><input type="text" id="buyCnt" class="form-control" style="width:100px;"></p>
            <button type="button" class="btn  btn-warning btn-lg " onclick="$('#myModal').modal('hide')">加入购物车</button>
            <button type="button" class="btn  btn-warning btn-lg " onclick="goCart()">加入后跳转购物车</button>
        </div>
	</div>
</div>
          </div>
        </div>
      </div>
    </div>
    
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
    <script src="${APP_PATH}/script/back-to-top.js"></script>
	<script>
    $(".prjtip img").css("cursor", "pointer");
    $(".prjtip img").click(function(){
        window.location.href = 'project.html';
    });
    
    function goCart() {
    	$.ajax({
    		type : "POST",
    		url  : "${APP_PATH}/member/addGoodsIntoCart",
    		data : {
    			"goodsid" : "${goods.id}",
    			"cnt"     : $("#buyCnt").val(),
    			"price"   : "${goods.price}"
    		},
    		success : function() {
    			window.location.href = "${APP_PATH}/member/cart";
    		}
    	});
    	
    }
	</script>
  </body>
</html>