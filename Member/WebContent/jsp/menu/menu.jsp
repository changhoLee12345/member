<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>menu.jsp</title>
<link href="/Member/css/menu.css" rel="stylesheet">
</head>

<body>
	<div align="center">
		<div>
			<br>
			<h1>행복한 금요일</h1>
			<br>
			<ul id="nav">
				<li><a href="/Member/index.jsp">HOME</a> <!-- href="../../index.jsp" -->
				<li><a href="/Member/BorderList.do">자유게시판</a></li>
				<c:if test="${id eq null || auth eq null }">
					<!-- id, auth 는 세션에 있는 값 -->
					<li><a href="/Member/jsp/member/loginForm.jsp">로그인</a></li>
				</c:if>
				<c:if test="${id ne null && auth ne null }">
					<li><a href="#">마이페이지</a></li>
				</c:if>
				<c:if test="${id eq null || auth eq null }">
					<li><a href="/Member/jsp/member/signUp.jsp">회원가입</a></li>
				</c:if>
				<c:if test="${auth eq 'admin' }">
					<li><a href="/Member/MemberList.do">관리자권한</a>
						<ul>
							<li><a href="/Member/MemberList.do">멤버관리</a></li>
							<li><a href="/Member/NoticeList.do">공지사항관리</a></li>
						</ul></li>
				</c:if>
				<c:if test="${id ne null || auth ne null}">
					<li><a href="/Member/NoticeList.do">공지사항</a></li>
				</c:if>
				<c:if test="${id ne null && auth ne null}">
					<li><a href="/Member/Logout.do">로그아웃</a></li>
				</c:if>
				<li><a href="/Member/Test.do?p1=v1&p2=v2&p3=v3">Test.do</a>
			</ul>
		</div>
	</div>
</body>

</html>