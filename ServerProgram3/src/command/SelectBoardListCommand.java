package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ModelAndView;
import dao.BoardDAO;

public class SelectBoardListCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		request.setAttribute("list", BoardDAO.getInstance().selectBoardList());
		request.setAttribute("totalRecord", BoardDAO.getInstance().getTotalRecord());
		return new ModelAndView("/board/listBoard.jsp", false);
	}

}
