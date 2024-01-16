<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	 <!-- ページのメタ情報設定 -->
	<meta http-equiv="Content- Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content- Style-Type" content="text/css" />
	<meta http-equiv="Content- Script-Type" content="text/javascript" />
	 <meta http-equiv="imagetoolbar" content="no" />
	 <meta name="description" content="" />
	 <meta name="keywords" content="" />
	 <title>UserCreateConfirm画面</title>

	  <!-- スタイルの設定 -->
	<style type="text/css">
		body {
		margin:0;
		padding:0;
		line-height:1.6; letter-spacing:1px;
		font-family:Verdana, Helvetica, sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
		}
		table {
		text-align:center;
		margin:0 auto ;
		}
		/ * = = = = = = = = I D L A Y O U T = = = = = = = = * /
		#top {
		width : 780px;
		margin : 30px auto;
		border:1px solid #333;
		}
		#header {
		width : 100%;
		height: 80px;
		background-color: black;
		}
		# m a i n {
		width: 100%;
		height : 500px;
		text-align: center;
		}
		#footer {
		width: 100%;
		height: 80px;
		background-color: black; clear:both;
		}
	</style>
</head>
<body>
	<div id= "header">
		<div id = "pr">
		</div>
	</div>
	<div id = "main">
		<div id = "top">
			<p> UserCreateConfirm </p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<s:form action = "UserCreateCompleteAction">
				<table>
					<tr id ="box">
						<td>
							<label>ログイン ID:</label>
						</td>
						<td>
							<s:property value="loginUserId" escape="false" />
						</td>
					</tr>
					<tr id ="box">
						<td>
							<label>ログイン PASS:</label>
						<td>
							<s:property value="loginPassword" escape="false" />
						</td>
					</tr>
					<tr id ="box">
						<td>
							<label>ユーザー名 :</label>
						</td>
						<td>
							<s:property value="userName" escape="false" />
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="完了" />
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>