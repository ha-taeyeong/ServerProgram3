package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;
import dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no = Long.parseLong(request.getParameter("no"));
		int result = 0;
		PrintWriter out = response.getWriter();
		if (BoardDAO.getInstance().checkReply(no)) {
			out.println("<script>");
			out.println("alert('댓글이 달린 게시글은 삭제할 수 없습니다.");
			out.println("history.back()");
			out.println("</script>");
		} else {
			result = BoardDAO.getInstance().deleteBoard(no);
		}
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 삭제되었습니다.");
			out.println("location.href='selectBoardList.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글이 삭제되지 않았습니다.");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}

}
