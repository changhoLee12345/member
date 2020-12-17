<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>signUp.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		let duplicationCheked = false;
		let passwordChecked = false;

		function passwordCheck() {
			var form = document.frm;
			if (form.password.value != form.passwordcheck.value) {
				alert("패스워드가 일치하지않습니다.")
			} else {
				passwordChecked = true;
			}
		}

		function idDuplicationCheck() {
			var form = document.frm;
			var id = document.getElementById("id").value;
			$.ajax({
				type: 'post',
				url: '/Member/IdDuplication.do',
				data: {
					id: id
				},
				success: function (result) {
					if (!form.id.value) {
						alert("아이디를 입력하세요.")
					} else if (result == 1) {
						alert("사용할 수 있는 아이디입니다.");
					} else {
						alert("사용할 수 없는 아이디입니다.")
					}
				},
				error: function (reject) {
					console.log(reject);
				}
			})
			duplicationCheked = true;
		}

		//회원가입 화면 입력값 검사.
		function valueCheck() {

			let form = document.frm;

			if (!form.id.value) {
				alert("아이디를 입력하세요.")
				return false;
			}

			if (!form.name.value) {
				alert("이름을 입력하세요.")
				return false;
			}

			if (duplicationCheked != true) {
				alert("아이디 중복체크를 해주세요.")
				return false;
			}

			passwordCheck();

			if (passwordChecked != true) {
				alert("패스워드를 확인해주세요.")
				return false;
			}

			if (!form.password.value) {
				alert("비밀번호를 입력하세요.")
				return false;
			}
			form.submit();
		}

		/* 중복확인 창
		function openIdcheck() {
			window.name = "parentForm";
			window.open("member/idCheckForm.jsp", "아이디 중복체크",
				"width=500, height=300, resizable=no, scrollbars=no")
		}
		 */

		/*
		// 아이디 입력->hidden에 idUncheck 세팅->중복체크후 다시 입력하명 다시 체크.
		function inputIdChk() {
			document.form.idDuplication.value = "idUncheck";
		}
		중복확인input에
		onkeydown="inputIdChk()"
		 */
	</script>
</head>

<body>
	<div align="center">
		<br>
		<div>
			<h2>회 원 가 입</h2>
			<br>
		</div>
		<div>
			<form action="/Member/MemberSignUp.do" id="frm" name="frm" method="post" onsubmit="return checkValue()">
				<table border="1" style="border-collapse: collapse">
					<tr>
						<th width="200" height="30">아 이 디</th>
						<td>&nbsp;<input type="text" id="id" name="id" style="border: none" size="30">&nbsp;
							<input type="button" value="중복확인" onclick="idDuplicationCheck()">&nbsp;
						</td>
					</tr>
					<tr>
						<th width="200" height="30">이 름</th>
						<td>&nbsp;<input type="text" id="name" name="name" style="border: none" size="30"></td>
					</tr>
					<tr>
						<th width="200" height="30">패스워드</th>
						<td>&nbsp;<input type="password" id="password" name="password" style="border: none" size="30">
						</td>
					</tr>
					<tr>
						<th width="200" height="30">패스워드 확인</th>
						<td>&nbsp;<input type="password" id="passwordcheck" name="passwordcheck" style="border: none"
								size="30">
						</td>
					</tr>
				</table>
				<br> <br> <input type="button" value="가입하기" onclick="valueCheck()">&nbsp;&nbsp;&nbsp;
				<input type="button" value="취 소" onclick="location.href='/Member/jsp/menu/menu.jsp'">
			</form>
		</div>
	</div>
</body>

</html>