<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="main-header"
	style="background-image: url(http://static.ghostchina.com/image/6/d1/fcb3879e14429d75833a461572e64.jpg)""="">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">

				<!-- start logo -->
				<a class="branding" href="http://www.ghostchina.com"
					title="Ghost 开源博客平台"><img
					src="http://static.ghostchina.com/image/b/46/4f5566c1f7bc28b3f7ac1fada8abe.png"
					alt="Ghost 开源博客平台"></a>
				<!-- end logo -->
				<h2 class="text-hide">Ghost
					是一个简洁、强大的写作平台。你只须专注于用文字表达你的想法就好，其余的事情就让 Ghost 来帮你处理吧。</h2>

				<img
					src="http://static.ghostchina.com/image/6/d1/fcb3879e14429d75833a461572e64.jpg"
					alt="Ghost 博客系统" class="hide">
			</div>
		</div>
	</div>
</header>
<nav class="navbar main-navigation">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
		<!-- 		<div class="navbar-header">
					<span data-target="#main-menu" data-toggle="collapse"
						class="nav-toggle-button collapsed"> <span class="sr-only">Toggle
							navigation</span> <i class="fa fa-bars"></i>
					</span>
				</div> -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#main-menu"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div id="main-menu" class="collapse navbar-collapse">
					<ul class="menu navbar-nav">
						<li role="presentation" class="nav-current"><a href="/">首页</a></li>
						<li role="presentation"><a href="http://wenda.ghostchina.com">论坛</a></li>
						<li role="presentation"><a href="/ghost-cheat-sheet/">快捷手册</a></li>
						<li role="presentation"><a
							href="http://docs.ghostchina.com/zh/">中文文档</a></li>
						<li role="presentation"><a href="/download/">下载</a></li>
						<li role="presentation"><a href="/about/">关于</a></li>
					</ul>
					<ul class="menu nav navbar-nav navbar-right">
						<li role="presentation"><a href="#">Link</a></li>
						<li role="presentation" class="dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false">Dropdown <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="user/signup">注册</a></li>
				<li><a href="user/login">登录</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

<ul class="nav nav-pills nav-stacked">
  <li role="presentation" class="active"><a href="#">Home</a></li>
  <li role="presentation"><a href="#">Profile</a></li>
  <li role="presentation"><a href="#">Messages</a></li>
</ul>