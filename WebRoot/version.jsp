<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>版本太低了</title>
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
				对不起，你的IE浏览器版本太低了，还处于远古时期哦。。。 请使用IE9.0（包含IE9.0）以上，或谷歌，firefox等版本
			</dt>
			<dd>
				<ul>
					<li>
						IE9.0以下的浏览器版本对样式和脚步的兼容性很差哦，业界都没有使用了哦。
					</li>
					<li>
						不好意思啦，老板。
					</li>
					<li>
						返回上一步操作,看看其它功能,你行的！
					</li>
				</ul>
			</dd>
		</dl>
	</body>
</html>
