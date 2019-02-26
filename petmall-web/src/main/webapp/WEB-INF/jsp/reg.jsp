<%@ page pageEncoding="UTF-8" %>
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
          <div><a class="navbar-brand" href="index.html" style="font-size:32px;">PetLove-宠物电商平台</a></div>
        </div>
      </div>
    </nav>

    <div class="container">

      <form class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="userpswd" name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
        <div class="checkbox">
          <label>
            忘记密码
          </label>
          <label style="float:right">
            <a href="login.html">我有账号</a>
          </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="doreg()" > 注册</a>
      </form>
    </div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>
    <script>
    function doreg() {
    	// 页面元素的非空校验
    	var loginacct = $("#loginacct").val();
    	// 表单元素即使没有输入内容，取值也不会是null,是空字符串
    	if ( loginacct == "" ) {
    		//alert("登陆账号不能为空，请输入");
    		layer.msg("登录账号不能为空，请输入！", {time:2000, icon:5, shift:6}, function(){
    			// 消息关闭后执行的逻辑
    		});
    		return;
    	}
    	
    	var userpswd = $("#userpswd").val();
    	if ( userpswd == "" ) {
    		//alert("登陆密码不能为空，请输入");
    		layer.msg("登录密码不能为空，请输入！", {time:2000, icon:5, shift:6}, function(){
    			// 消息关闭后执行的逻辑
    		});
    		return;
    	}
    	var index = 0;
    	$.ajax({
    		type : "POST",
    		url  : "user/doAJAXReg",
    		data : {
    			"loginacct" : loginacct,
    			"userpswd"  : userpswd
    		},
    		beforeSend :function(){
    			index = layer.load(2,{time: 10*1000});
    		},
    		success : function(result){
    			layer.close(index);
    			window.location.href = "${APP_PATH}/login";
    			if(result.success){
    				layer.msg("注册成功",{time:2000, icon:6, shift:6},function(){
    				
    			});
    				window.location.href = "${APP_PATH}/login";
    				}
    			
    			
    		}
    	});
    }
    </script>
  </body>
</html>