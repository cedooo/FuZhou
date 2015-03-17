<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>未完成</title>
<style type="text/css">
	h1 {
		position: relative;
		z-index: 2;
		width: 540px;
		height: 0;
		margin: 110px auto 15px;
		padding: 230px 0 0;
		overflow: hidden;
		xxxxborder: 1px solid;
		background-image: url(zdy/image/error.jpg);
		background-repeat: no-repeat;
	}
	
	a:link,a:visited {
		color: #007ab7;
		text-decoration: none;
	}
	.link a {
		margin-right: 1em;
	}
	.link,.texts {
		width: 540px;
		margin: 0 auto 15px;
		color: #505050;
	}
	.texts {
		line-height: 2;
	}
	
	.texts dd {
		margin: 0;
		padding: 0 0 0 15px;
	}
	
	.texts ul {
		margin: 0;
		padding: 0;
	}

</style>

	</head>
	<body>
		<h1></h1>
		<p class="link">
			<a href="javascript:parent.location.replace(/fuzhou/+'${backPage}');">返回</a>
		</p>
		<dl class="texts">
			<dt>
				对不起，此功能团队成员还在努力的开发中。。。下个月就好啦！
			</dt>
			<dd>
				<ul>
					<li>
						不必在意哦，我们会加班加点做的。
					</li>
					<li>
						不要催了嘛，好不好嘛。
					</li>
					<li>
						返回上一步操作,看看其它功能,你行的！
					</li>
				</ul>
			</dd>
		</dl>
	</body>
</html>
