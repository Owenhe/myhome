<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@include file="../common/import.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@include file="../common/head.jsp"%>
</head>

<body>
	<%@include file="../common/topnav.jsp"%>
	<div class="container mt40">
		<div class="row col-md-12">
			<div class="panel panel-default">
			  <div class="panel-heading">用户注册</div>
			  <p class="bg-danger text-center text-danger">${error}</p>
			  <div class="panel-body">
			  	<form id="user-add-form" class="form-horizontal" action="../user/add" method="post">
			  		<div class="form-group">
						<label for="email" class="control-label col-md-2">邮箱</label>
						<div class="col-lg-3">
						    <input type="email" name="email" class="form-control" id="email" placeholder="邮箱" value="${user.email}">
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="control-label col-md-2">密码</label> 
						<div class="col-lg-3">
							<input type="password" name="password" class="form-control" id="password"
								placeholder="密码">
						</div>
					</div>

					<div class="form-group">
						<label for="comfr-password" class="control-label col-md-2">确认密码</label> 
						<div class="col-lg-3">
							<input type="password" name="comfrPassword" class="form-control" id="comfrPassword"
								placeholder="确认密码">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-offset-3 col-md-8">
							<button id="signup-btn" type="submit" class="btn btn-primary">注册</button>
				      	</div>
				   	</div>
				</form>
			  </div>
			</div>
		</div>
	</div>
	<%@include file="../common/script.jsp"%>
	<script type="text/javascript" src="../js/jquery-validation-1.15.0/jquery.validate.js"></script>
	<script type="text/javascript" src="../js/jquery-validation-1.15.0/messages_zh.js"></script>
		<script type="text/javascript">
		seajs.config({
		  base: "../js",
		  alias: {
		    "jquery": "jquery-1.9.1.js",
// 		    "valiadate": "jquery-validation-1.15.0/jquery.validate.js",
		    "userFormValidation": "user/userFormValidation.js",
// 		    "mesgZh": "jquery-validation-1.15.0/messages_zh.min.js"
		  }
		});

		// 加载入口模块
		seajs.use(["../js/user/userAdd"]);
	</script>
<!-- 	<script type="text/javascript" src="../js/user/userAdd.js"></script> -->
</body>
</html>