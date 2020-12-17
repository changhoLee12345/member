<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>signUp.jsp</title>
</head>

<body>
    <div align="center"><br>
        <div>
            <h2>회 원 가 입</h2><br>
        </div>
        <div>
            <form action="/Member/MemberSignUp.do" id="frm" name="frm" method="post">
                <table border="1" style="border-collapse: collapse">
                    <tr>
                        <th width="200" height="30">아 이 디</th>
                        <td>&nbsp;
                            <input type="text" id="id" name="id" style="border:none" size="30" onkeydown="inputIdcheck()">&nbsp;
                            <input type="button" value="중복확인" onclick="openIdcheck()">&nbsp;
                            <input type="hidden" id="idDuplication" name="idDuplication" value="idUncheck">
                        </td>
                    </tr>
                    <tr>
                        <th width="200" height="30">이 름</th>
                        <td>&nbsp;<input type="text" id="name" name="name" style="border:none" size="30"></td>
                    </tr>
                    <tr>
                        <th width="200" height="30">패스워드</th>
                        <td>&nbsp;<input type="password" id="password" name="password" style="border:none" size="30"></td>
                    </tr>
                    <tr>
                        <th width="200" height="30">패스워드 확인</th>
                        <td>&nbsp;<input type="password" id="password" name="password" style="border:none" size="30"></td>
                    </tr>
                </table><br><br>
                <input type="submit" value="가입하기" onclick="checkValue()">&nbsp;&nbsp;&nbsp;
                <input type="button" value="취 소" onclick="location.href='/Member/jsp/menu/menu.jsp'">
            </form>
        </div>
    </div>
</body>

</html>