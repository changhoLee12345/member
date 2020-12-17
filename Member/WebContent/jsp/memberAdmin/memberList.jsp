<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>memberList.jsp</title>
	<style>
		tr.row:hover {
			background: pink;
		}
	</style>
</head>

<body>
	<br>
	<div align="center">
		<h3>회원 목록</h3>
	</div><br>
	<div align="center">
		<table border="1" style="border-collapse: collapse">
			<tr>
				<th width="150" height="50">아이디</th>
				<th width="150">이름</th>
				<th width="150">권한</th>
				<th width="150">포인트</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr class="row" onclick="location.href='/Member/MemberRead.do?id=${vo.memberId}'">
					<td width="100" height="30" align="center">${vo.memberId }</td>
					<td width="100" align="center">${vo.memberName }</td>
					<td width="100" align="center">${vo.memberAuth }</td>
					<td width="100" align="center">${vo.memberPoint }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>