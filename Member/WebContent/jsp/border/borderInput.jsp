<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>borderInput.jsp</title>
</head>

<body>
    <div align="center">
        <h1>글쓰기</h1>
    </div>
    <div align="center">
        <form action="/Member/BorderInput.do" id="frm" name="frm" method="post">
            <table border="1" style="border-collapse:collapse">
                <tr>
                    <th width="100">작성자</th>
                    <td width="300">
                        <input type="text" size="50" id="write" name="write"></td>
                </tr>
                <tr>
                    <th width="100">작성일</th>
                    <td width="300">
                        <input type="date" size="50" id="wdate" name="wdate"></td>
                </tr>
                <tr>
                    <th width="100">제목</th>
                    <td width="300">
                        <input type="text" size="50" id="title" name="title"></td>
                </tr>
                <tr>
                    <th width="100">내용</th>
                    <td width="300">
                        <textarea cols="100" rows="5" id="content" name="content" style="border: none"></textarea></td>
                </tr>
            </table> <br />
            <button type="submit">등 록</button>&nbsp;&nbsp;&nbsp;
            <button type="reset">다시쓰기</button>&nbsp;&nbsp;&nbsp;
            <button type="button" onclick="location.href='/Member/BorderList.do'">목 록</button>&nbsp;&nbsp;&nbsp;
        </form>
    </div>
</body>

</html>