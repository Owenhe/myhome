<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${pageCount && pageCount > 0}">
	<ul class="pagination">
	  <li><a href="#">&laquo;</a></li>
	  <c:forEach begin="1" end="${pageCount}" var="idx">
		  <li><a href="#">${idx}</a></li>
	  </c:forEach>
	  <li><a href="#">&raquo;</a></li>
	</ul>
</c:if>