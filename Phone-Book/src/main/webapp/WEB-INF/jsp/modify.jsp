<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
<!-- Required meta tags -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<title>지인 수정 페이지</title>
</head>

<body>

	<h1 align="center">지인 수정</h1>

	<div class="container">

		<form action="/jsp/updateFriend" method="post">

			<input type="hidden" name="frndSeq" value="${friend.frndSeq}">

			<div class="form-group">
				<label for="frnd_nm">지인 이름</label>
				<input type="text" class="form-control" id="frnd_nm" name="frnd_nm" value=${friend.frndNm}>
			</div>

			<button type="submit" class="btn btn-primary">저장</button>
			<button type="button" class="btn btn-primary" id="Back" onClick="location.href='/jsp/detail?frndSeq=${friend.frndSeq}'">취소</button>

		</form>

	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>
