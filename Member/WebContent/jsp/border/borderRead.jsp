<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>borderRead.jsp</title>
	<script type="text/javascript">
		function formSubmit(str) {
			var f = document.frm;
			if (str == "edit") {
				f.action = "/Member/BorderSearch.do";
			} else {
				f.action = "/Member/BorderDelete.do"
			}
			f.submit();
		}
	</script>
</head>

<body>
	<div align="center">
		<div><br>
			<h2>글 상세 보기</h2><br>
		</div>
		<div>
			<table border="1" style="border-collapse: collapse">
				<tr>
					<th width="150" height="30" align="center">작성자</th>
					<td width="150">${vo.borderWrite}</td>
					<th width="100" align="center">작성일자</th>
					<td width="200">${vo.borderDate}</td>
					<th width="100" align="center">조회수</th>
					<td width="100">${vo.borderHit}</td>
				</tr>
				<tr>
					<th width="100" height="30" align="center">제목</th>
					<td colspan="5">${vo.borderTitle}</td>
				</tr>
				<tr>
					<th width="100" align="center">내용</th>
					<td colspan="5"><textarea cols="70" rows="7" style="border: none">${vo.borderContent}</textarea>
					</td>
				</tr>
			</table>
			<br>
			<div>
				<form id="frm" name="frm" action="/Member/BorderSearch.do" method="post">
					<input type="hidden" id="id" name="id" value="${vo.borderId }">
					<button type="button" onclick="formSubmit('edit')">수 정</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="formSubmit('delete')">삭 제</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='/Member/BorderList.do'">목 록</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>