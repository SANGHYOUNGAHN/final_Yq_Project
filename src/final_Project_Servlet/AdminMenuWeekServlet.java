package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final_Project_Dao.MenuWeekDAO;
import final_Project_Vo.MenuWeekVO;

/**
 * Servlet implementation class AdminMenuWeekServlet
 */
@WebServlet("/AdminMenuWeek.do")
public class AdminMenuWeekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMenuWeekServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = "Admin_Menu_View.jsp";
		

		MenuWeekDAO mDao = MenuWeekDAO.getInstance();
		List<MenuWeekVO> menuWeekList = mDao.selectWeekMenu();
		request.setAttribute("menuWeekList", menuWeekList);
		
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	
	}

}