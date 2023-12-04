<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
//リクエストスコープに保存されたOutputCodeListインスタンスを取得
List<String> outputList = (List<String>)request.getAttribute("outputList");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Result | 文字列つつむくん</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/main.js"></script>
</head>
<body>
<div class="main">
	<h1>文字列つつむくん</h1>
	<div class="result_header">
		<div class="h2_wrapper"><h2>実行結果</h2></div>
		<div class="button_wrapper"><button id="copy">結果をコピー</button></div>
	</div>
	<p id="result">
		<% for(String output : outputList){ %>
		<%= output %><br>
		<% } %>
	</p>
	<div id="top-link"><a href="index.html">Topに戻る</a></div>
</div>
</body>
</html>