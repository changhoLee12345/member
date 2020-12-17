<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>noticeRead.jsp</title>
    <script type="text/javascript">
        function formSubmit(str) {
            var f = document.frm;
            if (str == 'edit') {
                f.action = "/Member/NoticeEditBefore.do";
            } else {
                f.action = "/Member/NoticeDelete.do"
            }
            f.submit();
        }
    </script>
</head>

<body>
    <div align="center">
        <div>
            <br>
            <h2>공지사항 상세</h2><br>
        </div>
        <div align="center">
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
                    <th width="100" height="150" align="center">내용</th>
                    <td colspan="3" width="300">&nbsp;${vo.noticecontent }</td>
                </tr>
                <tr>
                    <th width="100" height="30" align="center">첨부파일</th>
                    <td colspan="3" width="300">&nbsp;파일명 :<a href="NoticeFileDown.do?fileName=${vo.noticeattach }">${vo.noticeattach }</a></td>
                </tr>
            </table><br>
            <div>
                <form id="frm" name="frm" action="/Member/.do" method="post">
                    <input type="hidden" id="id" name="id" value="${vo.noticeid }">
                    <c:if test="${auth eq 'admin' }">
                        <button type="button" onclick="formSubmit('delete')">삭 제</button>
                        &nbsp;&nbsp;&nbsp;
                        <button type="button" onclick="formSubmit('edit')">수 정</button>
                    </c:if>
                    &nbsp;&nbsp;&nbsp;
                    <button type="button" onclick="location.href='/Member/NoticeList.do'">목 록</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>