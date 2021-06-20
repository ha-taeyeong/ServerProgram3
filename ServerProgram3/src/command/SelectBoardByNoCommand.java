package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ModelAndView;
import dao.BoardDAO;

public class SelectBoardByNoCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long no = Long.parseLong(request.getParameter("no"));
		HttpSession session = request.getSession();
		if (session.getAttribute("open") == null) {
			BoardDAO.getInstance().updateBoardHit(no);
			session.setAttribute("open", true);
		}
		
		request.setAttribute("boardDTO", BoardDAO.getInstance().selectBoardByNo(no));
		request.setAttribute("replyList", BoardDAO.getInstance().selectReplyList(no));
		
		return new ModelAndView("/board/viewBoard.jsp", false);
	}

}
