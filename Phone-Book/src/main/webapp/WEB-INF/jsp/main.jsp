<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>PhoneBook</title>
</head>
<body>

	<center>
		<h1>Welcome! This is the PhoneBook by Sean.</h1>
		<a href="/jsp/list">Go to friend list</a>
	
		<c:foreach items="${list}" var="list" varStatus="status">
		<div>
		${list[0].frndNm}
		${list[0].frndSeq}
		</div>
		</c:foreach>
		
	</center>

</body>
</html>