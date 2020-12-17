<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function formSubmit(str) {
			var f = document.frm;
			if (str == "edit") {
				f.action = "/Member/MemberEditBefore.do";
			}
			f.submit();
		}
	</script>
</head>

<body>
	<div align="center">
		<div><br>
			<h3>회원정보 상세</h3><br>
		</div>
		<div align="center">
			<table border="1" style="border-collapse: collapse" align="center">
				<tr>
					<th width="100" height="30" align="center">아이디</th>
					<td width="300">&nbsp;${vo.memberId }</td>
				</tr>
				<tr>
					<th width="100" height="30" align="center">이름</th>
					<td width="300">&nbsp;${vo.memberName }</td>
				</tr>
				<tr>
					<th width="100" height="30" align="center">권한</th>
					<td width="300">&nbsp;${vo.memberAuth }</td>
				</tr>
				<tr>
					<th width="100" height="30" align="center">포인트</th>
					<td width="300">&nbsp;${vo.memberPoint }</td>
				</tr>
			</table><br>
			<div>
				<form id="frm" name="frm" action="/Member/MemberEditBefore.do" method="post">
					<input type="hidden" id="id" name="id" value="${vo.memberId }">
					<button type="button" onclick="formSubmit('edit')">수 정</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='/Member/MemberList.do'">목 록</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>