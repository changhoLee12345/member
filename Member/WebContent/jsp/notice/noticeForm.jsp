<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>noticeForm.jsp</title>
</head>

<body>
	<div align="center">
		<div>
			<br>
			<h2>공지사항 등록</h2>
		</div>
		<div>
			<form action="/Member/NoticeInsert.do" id="frm" name="frm"
				method="POST" enctype="multipart/form-data">
				<!-- enctype:전송되는 데이터 형식을 설정, multipart/form-data:파일이나 이미지를 서버로 전송할 경우 이 방식을 사용 -->
				<table border="1" style="border-collapse: collapse">
					<tr>
						<th width="200" height="40">제목</th>
						<td width="700">&nbsp; <input type="text" id="title"
							name="title" size="90" style="border: none" required="required">
						</td>
					</tr>
					<tr>
						<th width="100">내용</th>&nbsp;
						<td><textarea name="content" id="content" cols="100"
								rows="10" style="border: none" required="required"></textarea></td>
					</tr>
					<tr>
						<th width="100" height="40">첨부파일</th>&nbsp;
						<td>&nbsp; <input type="file" id="attatchfile" name="attatchfile" size="30" style="border: none">
						</td>
					</tr>
				</table>
				<br>
				<div>
					<br> <input type="submit" value="저장">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
					<button type="button"
						onclick="location.href='/Member/NoticeList.do'">목록</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>