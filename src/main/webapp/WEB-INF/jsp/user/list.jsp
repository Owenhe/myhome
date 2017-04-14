<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
%>
<%@include file="../common/import.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<%@include file="../common/head.jsp" %>
</head>

<body>
	<%@include file="../common/topnav.jsp" %>
	<div class="container mt40">
		<h5>Users info.</h5>
		<div class="row col-md-12">
		<c:choose>
			<c:when test="${not empty users}">
				<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<tr align="left">
							<th>Email</th>
							<th>User Name</th>
							<th>EN Name</th>
							<th>IP</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.email }</td>
								<td>${user.cnName }</td>
								<td>${user.enName }</td>
								<td>${user.ip }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</c:when>
			<c:otherwise>
				No data found.
			</c:otherwise>
		</c:choose>
		</div>
	</div>
	<%@include file="../common/script.jsp" %>
	<%@include file="../common/pagination.jsp" %>
</body>
</html>