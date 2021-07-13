package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;
import dao.BoardDAO;
import dto.ReplyDTO;

public class InsertReplyCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		Long boardNo = Long.parseLong(request.getParameter("boardNo"));
		ReplyDTO dto = new ReplyDTO();
		dto.setAuthor(author);
		dto.setContent(content);
		dto.setIp(ip);
		dto.setBoardNo(boardNo);
		int result = BoardDAO.getInstance().insertReply(dto);
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('댓글이 등록되었습니다.");
			out.println("location.href='selectBoardByNo.do?no=" + boardNo + "'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('댓글이 등록되지 않았습니다.");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}

}
