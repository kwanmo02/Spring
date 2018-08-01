<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
</head>

<body>


	<!-- top.jsp -->
	<%@include file="/WEB-INF/views/common/top.jsp"%>.

	<div class="container-fluid">
		<div class="row">


			<!-- left.jsp -->
			<%@include file="/WEB-INF/views/common/left.jsp"%>


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="blog-header">
					<h1 class="blog-title">앙 기모리~^ 3^</h1>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="blog-post-title"></h2>
							<p class="blog-post-meta">2018.7.24, room 207 ${from}</p>
							

							<p>jsp를 통한 웹 프로그래밍 학습</p>
							<hr>

							<h3>▼▼▼▼▼▼▼▼▼▼▼▼</h3><br>
							<p>소개글</p>
							<ul>
								<li>안녕하세요 자바를 아십니까</li>
								<li>네 저도 잘 모릅니다.</li>
								<li>자알못이라고도 합니다.</li>
								<li>힘내세요 해뜰날이 올거에요</li>
								<li>화이팅 ~~~~</li>
								
							</ul>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>