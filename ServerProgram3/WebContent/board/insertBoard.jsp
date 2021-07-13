<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="insertBoard.do">
		<h3>게시글 작성하기</h3>
		<p>작성자</p>
		<div><input type="text" name="author" autofocus></div>
		<p>제목</p>
		<div><input type="text" name="title" autofocus></div>
		<p>내용</p>
		<div><textarea name="content" rows="5" cols="23"></textarea></div>
		<button>저장하기</button>
		<input type="reset" value="작성초기화">
		<input type="button" value="목록보기" onclick="location.href='selectBoardList.do'">
	</form>
</body>
</html>