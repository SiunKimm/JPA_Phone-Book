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

<title>지인 목록</title>

<%-- functions 태그 라이브러리 추가, length 함수는 오브젝트 항목의 갯수를 세어준다. fn:length(list.phones) --%>
<%-- 멤버 엔티티에 폰 엔티티 목록이 포함되어 있으므로 friend.getPhones() 의 카운트를 표시 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<script>
		document.addEventListener("DOMContentLoaded", () => {
		  console.log("hello world");
		});
	</script>
</head>

<body>

	<h1 align="center">지인 목록</h1>

	<div class="container">
		<table class="table table-sm"
			style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">순번</th>
					<th style="background-color: #eeeeee; text-align: center;">지인 이름</th>
					<th style="background-color: #eeeeee; text-align: center;">전화 수</th>
					<th style="background-color: #eeeeee; text-align: center;">등록일시</th>
					<th style="background-color: #eeeeee; text-align: center;">수정일시</th>
					<th style="background-color: #eeeeee; text-align: center;">업무</th>
				</tr>
			</thead>

			<tbody>
				<%-- <c:forEach var="list" items="${list}" varStatus="status"> --%>
				<c:forEach var="list" items="${list}" varStatus="i">

					<tr>

						<%-- <td>${list.frndSeq - list.frndSeq + status.index + 1 }</td> --%>
						<!-- 전체 데이터 + (현재 페이지)*10 + i.index - 전체 데이터 - 9 -->
						<td>${totalRecords + (currentPage)*10 + i.index - totalRecords - 9}</td>
						<td><a href="/jsp/detail?frndSeq=${list.frndSeq}">${list.frndNm}</a></td>
						<td>${fn:length(list.phones)}</td>
						<td>${list.regDtmString}</td>
						<td>${list.modDtmString}</td>
						<td>
							<button type="button" class="btn btn btn-primary btn-sm" id="Modify" onClick="location.href='/jsp/modify?frndSeq=${list.frndSeq}'">수정</button>
							<button type="button" class="btn btn btn-warning btn-sm" id="Delete" onClick="location.href='/delete?frnd_seq=${list.frndSeq}'">삭제</button>
						</td>
					</tr>

				</c:forEach>

				<c:if test="${empty list }">
					<tr>
						<td>지인 목록 결과가 없습니다. 등록이 필요합니다.</td>
					</tr>
				</c:if>
			</tbody>

		</table>

	</div>

	<div class="container" style="text-align: center">
		<button type="button" class="btn btn-primary" id="main" onClick="location.href='/jsp/'">메인</button>
		<button type="button" class="btn btn-primary" id="register" onClick="location.href='/jsp/register'">등록</button>
		<!-- 지인 검색 양식 -->
		<form name="friendSearch" id="friendSearch" action="/jsp/list">
			<br>
			<select name="search_type">
				<option value="0" <c:if test="${search_type eq '0'}">selected</c:if>>지인 이름</option>
				<option value="1" <c:if test="${search_type eq '1'}">selected</c:if>>전화번호 뒷자리</option>
			</select>
			<input type="text" name="search_keyword" class="search" />
			<button type="submit" id="serach" class="btn btn-primary">검색</button>
		</form>
	</div>

	<br>

	<!-- 페이징 영역 시작 -->
	<div class="text-xs-center">
		<ul class="pagination justify-content-center">

			<!-- 이전 -->
			<c:choose>
				<c:when test="${ulist.first}"></c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="/jsp/list?page=1">처음</a></li>
					<li class="page-item"><a class="page-link" href="/jsp/list?page=${ulist.number}">&larr;</a></li>
				</c:otherwise>
			</c:choose>

			<!-- 페이지 그룹 -->
			<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
				<c:choose>
					<c:when test="${ulist.pageable.pageNumber+1 == i}">
						<li class="page-item disabled"><a class="page-link" href="/jsp/list?page=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="/jsp/list?page=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<!-- 다음 -->
			<c:choose>
				<c:when test="${ulist.last}"></c:when>
				<c:otherwise>
					<li class="page-item "><a class="page-link" href="/jsp/list?page=${ulist.number+2}">&rarr;</a></li>
					<li class="page-item "><a class="page-link" href="/jsp/list?page=${ulist.totalPages}">마지막</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<!-- 페이징 영역 끝 -->





	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>