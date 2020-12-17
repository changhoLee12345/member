<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>loginForm.jsp</title>
    <style>
        input:focus {
            outline: none;
        }
    </style>
</head>

<body>
    <div align="center">
        <div>
            <br>
            <h2>로 그 인</h2>
            <br>
        </div>
        <div>
            <form action="/Member/Login.do" id="frm" name="frm" method="POST">
                <div>
                    <table border="1" style="border-collapse:collapse">
                        <tr>
                            <th width="100" height="30">아 이 디</th>
                            <th width="200">
                                <input type="text" id="mid" name="mid" size="30" style="border:none">
                            </th>
                        </tr>
                        <tr>
                            <th width="100" height="30">비 밀 번 호</th>
                            <th width="200">
                                <input type="password" id="password" name="password" size="30" style="border:none">
                            </th>
                        </tr>
                    </table><br>
                </div>
                <div>
                    <input type="submit" value="로그인">
                </div>
            </form>
        </div>
    </div>
</body>

</html>