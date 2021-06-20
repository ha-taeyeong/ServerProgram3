package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;
import dao.BoardDAO;

public class UpdateBoardHitCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no = Long.parseLong(request.getParameter("no"));
		BoardDAO.getInstance().updateBoardHit(no);
		return null;
	}

}
