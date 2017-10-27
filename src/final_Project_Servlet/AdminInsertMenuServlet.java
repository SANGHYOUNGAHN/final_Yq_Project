package final_Project_Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import final_Project_Dao.AdminInsertMenuDAO;
import final_Project_Vo.AdminInsertVO;
/**
 * Servlet implementation class AdminInsertMenuServlet
 */
@WebServlet("/InsertMenu.do")
public class AdminInsertMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_Main_Page.jsp");
		//dispatcher.forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mn_id =request.getParameter("mn_id");
		String mn_date= request.getParameter("mn_date");
		String mn_name =request.getParameter("mn_name");
		String mn_price =request.getParameter("mn_price");
		String chain = request.getParameter("chain");
		String mn_type =request.getParameter("mn_type");
		
		AdminInsertVO AiVo = new AdminInsertVO();
		AiVo.setMn_id(mn_id);
		AiVo.setMn_date(mn_date);
		AiVo.setMn_name(mn_name);
		AiVo.setMn_price(Integer.parseInt(mn_price));
		AiVo.setChain(chain);
		AiVo.setMn_type(mn_type);
		
		AdminInsertMenuDAO Adao = AdminInsertMenuDAO.getInstance();
		int result = Adao.insertMenu(AiVo);
	
		
		HttpSession session =request.getSession();
		
		
		
		if(result==1){
			session.setAttribute("mn_id", AiVo.getMn_id());
			session.setAttribute("mn_date", AiVo.getMn_date());
			session.setAttribute("mn_name", AiVo.getMn_name());
			session.setAttribute("mn_price", AiVo.getMn_price());
		    session.setAttribute("mn_type", AiVo.getMn_type());
			session.setAttribute("mn_type", AiVo.getMn_type());
			
		}else{}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_Menu_Insert.jsp");
		dispatcher.forward(request, response);
	}

}
