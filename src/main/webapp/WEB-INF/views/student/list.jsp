<%@page import="java.io.PrintWriter"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>


<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">




<script>
	$(function() {
		$("table tbody tr").on("click", function() {
			$("#id").val($(this).data("id"));
			$("#frm").submit();
			console.log("table tbody tr clicked" + $(this).data("id")); //this 클릭시의 tr태그 값

		});
	});
</script>

</head>

<body>
	<%@ include file="/WEB-INF/views/common/top.jsp"%>

	<form id="frm" action="/student/detail" method="get">
		<input type="hidden" name="id" id="id">
	</form>



	<%@include file="/WEB-INF/views/common/left.jsp"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


		<div class="row">
			<div class="col-sm-8 blog-main">
				<h2 class="sub-header">학생</h2>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>학생 아이디</th>
								<th>학생 이름</th>
								<th>지명 횟수</th>
								<th>등록일자</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach var="studentVo" items="${studentList}">
								<%--tr태그 클릭시 상세 페이지로 이동 --%>
								<tr data-id="${studentVo.id}">
									<!-- var.컬럼명 -->
									<th>${studentVo.id}</th>
									<th>${studentVo.name}</th>
									<th>${studentVo.call_cnt}</th>
									<th><fmt:formatDate value="${studentVo.reg_dt}"
											pattern="yyyy/MM/dd" />
								</tr>
							</c:forEach>
						</tbody>
					</table>


				</div>

				<a class="btn btn-default pull-right">사용자 등록</a>

				<div class="text-center">
					<ul class="pagination">

						<%=request.getAttribute("pageNavi")%>


					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

