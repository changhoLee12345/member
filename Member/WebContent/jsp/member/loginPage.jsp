<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>loginPage.jsp</title>
</head>

<body>
    <div align="center">
        <br>
        <h2>성공적으로 가입이 완료되었습니다.</h2><br>
        <input type="button" value="로그인 하기" onclick="location.href='loginForm.jsp'">
    </div>
</body>

</html>