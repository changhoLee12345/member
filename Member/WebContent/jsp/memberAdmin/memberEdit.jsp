<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>memberEdit.jsp</title>
</head>

<body>
	<div align="center">
		<h1>수정하기</h1>
	</div>
	<div align="center">
		<form action="/Member/MemberEdit.do" id="frm" name="frm" method="post">
			<table border="1" style="border-collapse: collapse">
				<tr>
					<th width="100">아이디</th>
					<td width="300">${vo.memberId }</td>
				</tr>
				<tr>
					<th width="100">이름</th>
					<td width="300">${vo.memberName }</td>
				</tr>
				<tr>
					<th width="100">권한</th>
					<td width="300"><input type="text" size="50" id="auth" name="auth">${vo.memberAuth }</td>
				</tr>
				<tr>
					<th width="100">포인트</th>
					<td width="300"><input type="text" size="50" id="point" name="point">${vo.memberPoint }</td>
				</tr>
			</table><br>
			<input type="hidden" id="id" name="id" value="${vo.memberId }">
			<button type="submit">저 장</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/Member/Memberlist.do'">목록</button>
		</form>
	</div>
</body>

</html>