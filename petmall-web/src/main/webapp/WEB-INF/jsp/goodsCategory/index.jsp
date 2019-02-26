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
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;" href="#">电商平台 - 商品分类</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				      <%@include file="/WEB-INF/jsp/common/userinfo.jsp" %>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
                             <%@include file="/WEB-INF/jsp/common/mainLeft.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input class="form-control has-success" id="queryText" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button type="button" class="btn btn-warning" id="queryBtn"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" class="btn btn-danger" onclick="deleteDatas()" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/goodsCategory/add'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <form id="dataForm">
          <div class="table-responsive">
            
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox" id="allSelBox"></th>
                  <th width="300">分类名称</th>
                  <th>简介</th>
                  <th>排序号</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody id="dataBody">     
              </tbody>
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul class="pagination">
						
					    </ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
            
          </div>
          </form>
			  </div>
			</div>
        </div>
      </div>
    </div>

    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
        <script type="text/javascript">
            var likeflg = false;
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
			    $("#allSelBox").click(function(){
			    	//alert(this.checked);
			    	var that = this;
			    	var boxes = $("#dataBody :checkbox");
			    	/*
			    	for ( var i = 0; i < boxes.length; i++ ) {
			    		var box = boxes[i];
			    		// 循环体
			    	}
			    	*/
			    	//alert(boxes.length);
			    	$.each(boxes, function(i, box){
			    		// 循环体
			    		box.checked = that.checked;
			    	});
			    });
			    
			    <c:if test="${not empty param.pageno}">
			    pageQuery(${param.pageno});
			    </c:if>
			    <c:if test="${empty param.pageno}">
			    pageQuery(1);
			    </c:if>
			    
			    $("#queryBtn").click(function(){
			    	var queryText = $("#queryText").val();
			    	if ( queryText != "" ) {
			    		likeflg = true;
			    	}
			    	pageQuery(1);
			    });
            });
            
            function pageQuery( pageno ) {
            	
            	var jsonData = {"pageno":pageno, "pagesize":10};
            	
            	if ( likeflg == true ) {
            		jsonData.queryText = $("#queryText").val();
            	}
            	
            	var index = 0;
            	$.ajax({
            		type : "POST",
            		url  : "${APP_PATH}/goodsCategory/pageQuery",
            		data : jsonData,
            		beforeSend : function() {
            			index = layer.load(2, {time: 10*1000});
            		},
            		success : function(result) {
            			layer.close(index);
            			if ( result.success ) {
            				var pageObj = result.data;
            				var datas = pageObj.datas;
            				
            				var content = "";
            				// JS中相同类型的引号不能嵌套使用
            				// " "" " (X)
            				// ' '' ' (X)
            				// " '' " (OK)
            				// ' "" ' (OK)
            				for ( var i = 0; i < datas.length; i++ ) {
            					var data = datas[i];
            	                content += '<tr>';                                                                                                          
	          	                content += '  <td>'+(i+1)+'</td>         ';                                                                                 
	          					content += '  <td><input type="checkbox" value="'+data.id+'"></td> ';                                                                           
	          	                content += '  <td>'+data.name+'</td>              ';                                                                        
	          	                content += '  <td>'+data.remark+'</td>            ';
	          	                content += '  <td>'+data.orderid+'</td>            '; 
	          	                content += '  <td>                             ';                                                                           
	          					content += '      <button type="button" onclick="window.location.href=\'${APP_PATH}/goodsCategory/edit?pageno='+pageno+'&id='+data.id+'\'" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>'
	          					content += '	  <button type="button" onclick="deleteGoodsCategory('+data.id+', \''+data.name+'\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
	          					content += '  </td>';
	          	                content += '</tr>';
            				}
            				$("#dataBody").html(content);
            				
            				var totalno = pageObj.totalno;
            				var pageContent = "";
            				if ( pageno > 1 ) {
            					pageContent += '<li><a href="#" onclick="pageQuery('+(pageno-1)+')">上一页</a></li>';
            				}
            				for ( var i = 1; i <= totalno; i++ ) {
            					if ( pageno == i ) {
            						pageContent += '<li class="active"><a href="#">'+i+'</a></li>'
            					} else {
            						pageContent += '<li><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>'
            					}
            				}
            				if ( pageno < totalno ) {
            					pageContent += '<li><a href="#" onclick="pageQuery('+(pageno+1)+')">下一页</a></li>';
            				}
            				
            				$(".pagination").html(pageContent);
            			} else {
            	    		layer.msg("商品分类信息分页查询失败", {time:2000, icon:5, shift:6}, function(){
            	    		});
            			}
            		}
            	});
            }
            
            function deleteGoodsCategory(id, name) {
    			layer.confirm("删除商品分类信息【"+name+"】，是否继续？",  {icon: 3, title:'提示'}, function(cindex){
    			    // 确定
    			    var index = 0;
    			    $.ajax({
    			    	type : "POST",
    			    	url  : "${APP_PATH}/goodsCategory/delete",
    			    	data : {
    			    		"id" : id
    			    	},
    			    	beforeSend : function() {
    			    		index = layer.load(2, {time: 10*1000});
    			    	},
    			    	success : function(result) {
    			    		layer.close(index);
    			    		if ( result.success ) {
                	    		layer.msg("商品分类信息删除成功", {time:2000, icon:6}, function(){
                	    		    pageQuery(1);
                	    		});
    			    		} else {
                	    		layer.msg("商品分类信息删除失败", {time:2000, icon:5, shift:6}, function(){
                	    		});
    			    		}
    			    	}
    			    });
    				layer.close(cindex);
    			}, function(cindex){
    				// 取消
    			    layer.close(cindex);
    			});
            }
            
            function deleteDatas() {
            	var boxes = $("#dataBody :checked");
            	if (boxes.length == 0) {
    	    		layer.msg("请选择需要删除商品分类信息", {time:2000, icon:5, shift:6}, function(){
    	    		});
            	} else {
        			layer.confirm("删除选择的商品分类信息，是否继续？",  {icon: 3, title:'提示'}, function(cindex){
        			    // 确定
        			    
        			    var jsonData = {};
        			    
        			    $.each(boxes, function(i, box){
        			    	//jsonData.ids[i] = box.value;
        			    	//jsonData["ids["+i+"]"] = box.value;
        			    	//if ( i != 1 ) {
        			    		jsonData["gcs["+i+"].id"] = box.value;
        			    	//}
        			    });
        			    
        			    var index = 0;
        			    $.ajax({
        			    	type : "POST",
        			    	url  : "${APP_PATH}/goodsCategory/deletes",
        			    	data : jsonData,
        			    	beforeSend : function() {
        			    		index = layer.load(2, {time: 10*1000});
        			    	},
        			    	success : function(result) {
        			    		layer.close(index);
        			    		if ( result.success ) {
                    	    		layer.msg("商品分类信息删除成功", {time:2000, icon:6}, function(){
                    	    		    pageQuery(1);
                    	    		});
        			    		} else {
                    	    		layer.msg("商品分类信息删除失败", {time:2000, icon:5, shift:6}, function(){
                    	    		});
        			    		}
        			    	}
        			    });
        				layer.close(cindex);
        			}, function(cindex){
        				// 取消
        			    layer.close(cindex);
        			});
            	}
            }
            /*
            function changePageno( pageno ) {
            	window.location.href = "${APP_PATH}/goodsCategory/index?pageno=" + pageno;
            }
            */
        </script>
  </body>
</html>
