<%@page pageEncoding="UTF-8"%>
					<div class="thumbnail" style="    border-radius: 0px;">
						<img src="${APP_PATH}/img/services-box1.jpg" class="img-thumbnail" alt="">
						<div class="caption" style="text-align:center;">
							<h3>${loginMember.nickname}</h3>
							<c:if test="${loginMember.authstatus == '1'}">
							    <span class="label label-success" style="cursor:pointer;">已实名认证</span>
							</c:if>
							<c:if test="${loginMember.authstatus != '1'}">
							    <span class="label label-danger" onclick="alert('开始实名认证');" style="cursor:pointer;">未实名认证</span>
							</c:if>
							
                            <br>
                            <br>
                            <button class="btn btn-danger" onclick="window.location.href='${APP_PATH}/member/logout'">安全退出</button>
						</div>
					</div>