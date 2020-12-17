<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>loginResult.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- ajax호출 -->
	<script type="text/javascript">
		$(function () {
			$.ajax({
				url: '/Member/AjaxNoticeList.do',
				dataType: 'json',
				success: function (event) {	// data배열을 parsing -> event의 date값만 받아오도록.
					var arr = event.data;
					if (arr.length > 0) {
						var tb = $("<table border='1' style='border-collapse: collapse' />");
						var row = $("<tr />").append(
							$("<th width='70' height='30'/>").text("순번"),
							$("<th width='200' />").text("제목"),
							$("<th width='100' />").text("작성자"),
							$("<th width='150'/>").text("작성일자"),
							$("<th width='70'/>").text("조회수"),
							$("<th width='150'/>").text("첨부파일")
						);
						tb.append(row);
						for (var i in arr) {
							row = $("<tr />").append(
								$("<td align='center' />").text(arr[i].noticeid),
								$("<td align='center' /> />").text(arr[i].noticetitle),
								$("<td align='center' /> />").text(arr[i].noticewriter),
								$("<td align='center' /> />").text(arr[i].noticedate),
								$("<td align='center' /> />").text(arr[i].noticehit),
								$("<td align='center' /> />").text(arr[i].noticeattach)
							);
							tb.append(row);
						}
					}
					$(".notice").append(tb);
				},
				error: function () {
					alert("데이터를 가져오지 못하였습니다.")
				}
			});
		});
	</script>
</head>

<body>
	<div align="center">
		<br>
		<c:if test="${auth ne null }">
			<h3>${vo.memberName} 님 환영합니다.</h3>
			<!-- 공지사항 목록 -->
			<div id="notice" class="notice" align="center"></div>
		</c:if>
		<c:if test="${auth eq null }">
			<h3>${vo.memberId} 님의 아이디가 존재하지 않거나 패스워드가 일치하지 않습니다.</h3>
		</c:if>
	</div>
</body>

</html>