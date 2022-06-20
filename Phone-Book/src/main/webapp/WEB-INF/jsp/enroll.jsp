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

<title>번호 등록 페이지</title>
</head>

<body>

	<h1 align="center">번호 등록</h1>

	<div class="container">

		<form action="/jsp/addNumber" method="post">
			<input type="hidden" name="frndSeq" value="${friend.frndSeq}" />

			<div class="form-group">
				<label for="tel_type">전화 구분</label><br>
				<select id="tel_type" name="tel_type">
					<option value="집">집</option>
					<option value="휴대폰">휴대폰</option>
					<option value="회사">회사</option>
					<option value="학교">학교</option>
					<option value="팩스">FAX</option>
				</select></br> <label for="tel_no">전화 번호</label><br>
				<input type="text" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name='tel_no_1' />- 
				<input type="text" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name='tel_no_2' />- 
				<input type="text" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" name='tel_no_3' />

			</div>

			<button type="submit" class="btn btn-primary">저장</button>
			<button type="button" class="btn btn-primary" id="Back" onClick="location.href='/jsp/list'">취소</button>

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
