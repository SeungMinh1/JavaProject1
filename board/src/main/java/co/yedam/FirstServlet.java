package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
// inin() -> service() ..............-> destroy()
public class FirstServlet extends HttpServlet{
	
	public FirstServlet() {
		System.out.println("FirstServlet 생성자 호출");;
	}
	
	//init()
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init() 호출");
	}
	
	//사용자의 요청정보 처리함 : HttpServletRequest req
	//사용자에게 전달할 응답정보 : HttpServletResponse resp
	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() 호출");
		System.out.println(req.getRemoteHost());
		resp.getWriter().print("응답");;
	}
	*/
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시글목록 출력
		resp.setContentType("text/html;charset=utf-8"); //text/plain =>
		SqlSession session = DataSource.getInstance().openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		List<BoardVO> list = mapper.selectList();
		
		PrintWriter out= resp.getWriter();
		String html = "<table border='1'>";
		html += "<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th></tr></thead>";
		html += "<tbody>";
		
		//반복생성
		for(BoardVO board : list) {
			html += "<tr><td>"+board.getBoardNo()+"</td><td>"+board.getTitle()+"</td><td>"+board.getWriter()
					+"</td><td>"+board.getCreateDate()+ "</td></tr>";
		}
		
		html+= "</tbody>";
		html += "</table>";
		
		out.print(html);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() 호출");
	}

}
