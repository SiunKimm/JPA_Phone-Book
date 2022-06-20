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

<title>전화 목록</title>

</head>

<body>

	<h1 align="center">
		전화 목록 ( <td>${friend.frndNm}</td> )
	</h1>

	<div class="container">
		<table class="table table-sm"
			style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">순번</th>
					<th style="background-color: #eeeeee; text-align: center;">전화 구분</th>
					<th style="background-color: #eeeeee; text-align: center;">전화 번호</th>
					<th style="background-color: #eeeeee; text-align: center;">등록일시</th>
					<th style="background-color: #eeeeee; text-align: center;">수정일시</th>
					<th style="background-color: #eeeeee; text-align: center;">업무</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="list" items="${list}" varStatus="status">

					<tr>

						<td>${list.telSeq - list.telSeq + status.index + 1 }</td>
						<td>${list.telType}</td>
						<td>${list.telNo1}- ${list.telNo2} - ${list.telNo3}</td>
						<td>${list.regDtmString}</td>
						<td>${list.modDtmString}</td>
						<td>
							<button type="button" class="btn btn btn-primary btn-sm" id="Modify" onClick="location.href='/jsp/numodify?frndSeq=${frndSeq}&telSeq=${list.telSeq}'">수정</button>
							<button type="button" class="btn btn btn-warning btn-sm" id="Delete" onClick="location.href='/ddelete?frndSeq=${frndSeq}&tel_seq=${list.telSeq}'">삭제</button>
						</td>

					</tr>

				</c:forEach>

				<c:if test="${empty list }">
					<tr>
						<td>번호 목록 결과가 없습니다. 등록이 필요합니다.</td>
					</tr>
				</c:if>
			</tbody>

		</table>

	</div>

	<div class="container">

		<button type="button" class="btn btn-primary" id="main" onClick="location.href='/jsp/list'">메인</button>
		<button type="button" class="btn btn-primary" id="register" onClick="location.href='/jsp/enroll?frndSeq=${friend.frndSeq}'">등록</button>

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