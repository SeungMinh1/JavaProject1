package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class RemoveBoardForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
		String bno = req.getParameter("bno");
		
		req.setAttribute("bno", bno);
		
		req.getRequestDispatcher("board/removeForm.tiles").forward(req, resp);
	}

}
