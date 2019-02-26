<%@page pageEncoding="UTF-8"%>

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