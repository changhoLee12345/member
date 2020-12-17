<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>noticeEdit.jsp</title>
</head>

<body>
	<div align="center"><br>
		<h2>공지사항 수정</h2><br>
	</div>
	<div align="center">
		<form action="/Member/NoticeEdit.do" id="frm" name="frm" method="post">
			<table border="1" style="border-collapse: collapse">
				<tr>
					<th width="100" height="30" align="center">제목</th>
					<td width="300">&nbsp;${vo.noticetitle }</td>
					<th width="100" height="30" align="center">작성자</th>
					<td width="300">&nbsp;${vo.noticewriter }</td>
				</tr>
				<tr>
					<th width="100" height="30" align="center">작성일자</th>
					<td width="300">&nbsp;${vo.noticedate }</td>
					<th width="100" height="30" align="center">조회수</th>
					<td width="300">&nbsp;${vo.noticehit }</td>
				</tr>
				<tr>
					<th width="100" height="100" align="center">내용</th>
					<td colspan="3" width="300"><textarea name="content" id="content" cols="100" rows="10"
							style="border:none" required="required"></textarea></td>
				</tr>
				<tr>
					<th width="100" height="30" align="center">첨부파일</th>
					<td colspan="3" width="300"><input type="file" id="attatchfile" name="attatchfile" size="30"
							style="border:none" required="required"></td>
				</tr>
			</table><br>
			<input type="hidden" id="id" name="id" value="${vo.noticeid }">
			<button type="submit">저 장</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/Member/NoticeList.do'">목록</button>
		</form>
	</div>
</body>

</html>