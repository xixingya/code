<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/login.css">
	<style>

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚意购-创意产品购物平台</a></div>
        </div>
      </div>
    </nav>

    <div class="container">
      <h1>${param.errorMsg}</h1>
      <form id="loginForm" method="post" action="user/dologin" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-cloud"></i> 用户登录</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="userpswd" name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<select class="form-control" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
		  </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
          <br>
          <label>
            忘记密码
          </label>
          <label style="float:right">
            <a href="reg.html">我要注册</a>
          </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
      </form>
    </div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>
    <script>
    function dologin() {
    	// 页面元素的非空校验
    	var loginacct = $("#loginacct").val();
    	// 表单元素即使没有输入内容，取值也不会是null,是空字符串
    	if ( loginacct == "" ) {
    		//alert("登陆账号不能为空，请输入");
    		layer.msg("登陆账号不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
    			// 消息关闭后执行的逻辑
    		});
    		return;
    	}
    	
    	var userpswd = $("#userpswd").val();
    	if ( userpswd == "" ) {
    		//alert("登陆密码不能为空，请输入");
    		layer.msg("登陆密码不能为空，请输入", {time:2000, icon:5, shift:6}, function(){
    			// 消息关闭后执行的逻辑
    		});
    		return;
    	}
    	
    	// 提交表单数据，执行登陆
    	//alert("提交表单");
    	$("#loginForm").submit();
    	
    	/*
        var type = $(":selected").val();
        if ( type == "user" ) {
            window.location.href = "main.html";
        } else {
            window.location.href = "member.html";
        }
        */
    }
    </script>
  </body>
</html>