package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.AddBoard;
import co.yedam.control.AddBoardForm;
import co.yedam.control.BoardControl;
import co.yedam.control.BoardListControl;
import co.yedam.control.LoginControl;
import co.yedam.control.LoginFormControl;
import co.yedam.control.ModifyBoard;
import co.yedam.control.ModifyBoardForm;
import co.yedam.control.RemoveBoard;
import co.yedam.control.RemoveBoardForm;


//init -> service -> destroy
public class FrontControl extends HttpServlet{
	

	//url pattern - 실행서블릿, 관리.
	Map<String, Control> map;
	
	public FrontControl(){
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do",  new MainControl());
		map.put("/second.do",  null);
		map.put("/resume.do", new ResumeControl());
		
		//게시글 목록
		map.put("/boardList.do", new BoardListControl());
		map.put("/getboard.do", new BoardControl());
		map.put("/addForm.do", new AddBoardForm()); //등록화면
		map.put("/addBoard.do", new AddBoard()); //등록기능
		map.put("/modifyForm.do", new ModifyBoardForm());
		map.put("/modifyBoard.do", new ModifyBoard());
		map.put("/removeForm.do", new RemoveBoardForm());
		map.put("/removeBoard.do", new RemoveBoard());
		
		//member 로그인
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
		System.out.println("uri : "+uri+", context : "+context + ", path: "+ path);
		Control control = map.get(path);
		control.exec(req, resp);
		
	}
	
	
	

}