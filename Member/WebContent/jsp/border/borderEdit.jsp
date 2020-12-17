<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>borderEdit.jsp</title>
</head>

<body>
	<div align="center">
		<h1>글쓰기</h1>
	</div>
	<div align="center">
		<form action="/Member/BorderEdit.do" id="frm" name="frm" method="post">
			<table border="1" style="border-collapse: collapse">
				<tr>
					<th width="100">작성자</th>
					<td width="300">${vo.borderWrite}</td>
				</tr>
				<tr>
					<th width="100">작성일</th>
					<td width="300">${vo.borderDate}</td>
				</tr>
				<tr>
					<th width="100">제목</th>
					<td width="300">${vo.borderTitle}</td>
				</tr>
				<tr>
					<th width="100">내용</th>
					<td width="300"><textarea cols="100" rows="5" id="content" name="content"
							style="border: none">${vo.borderContent}</textarea></td>
				</tr>
			</table>
			<br />
			<input type="hidden" id="id" name="id" value="${vo.borderId }">
			<button type="submit">저 장</button>&nbsp;&nbsp;&nbsp;
			<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/Member/BorderList.do'">목 록</button>&nbsp;&nbsp;&nbsp;
		</form>
	</div>
</body>

</html>