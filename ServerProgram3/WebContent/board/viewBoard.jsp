<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		function fn_delete(f) {
			if (confirm('게시글을 삭제할까요?')) {
				f.action = 'deleteBoard.do';
				f.submit();
			}
		}
	</script>
</head>
<body>
	<form>
	<h3>${boardDTO.no}번 게시글</h3>
		<p>작성자: ${boardDTO.author}</p><p>작성일: ${boardDTO.postdate}</p><p>작성IP: ${boardDTO.ip}</p><p>조회수: ${boardDTO.hit}</p>
		<p>제목</p><p><input type="text" name="title" value="${boardDTO.title}"></p>
		<p>내용</p><p><textarea name="content" rows="5" cols="23">${boardDTO.content}</textarea></p>
		<input type="hidden" name="no" value="${boardDTO.no}">
		<input type="button" value="삭제하기" onclick="fn_delete(this.form)">
		<input type="button" value="목록보기" onclick="location.href='selectBoardList.do'">
	</form><hr>
	<form action="insertReply.do">
		<textarea rows="" cols="30" name="content" placeholder="댓글을 입력하세요"></textarea><br>
		<input type="text" name="author" placeholder="작성자">
		<input type="hidden" name="boardNo" value="${boardDTO.no}">
		<button>작성</button>
	</form>
	<table border="1">
		<tbody>
			<c:if test="${empty replyList}">
				<tr><td colspan="4">작성된 댓글이 없습니다.</td></tr>
			</c:if>
			<c:if test="${not empty replyList}">
				<c:forEach var="dto" items="${replyList}">
					<tr>
						<td>${dto.content}</td><td>${dto.author}</td><td>${dto.ip}</td><td>${dto.postdate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>