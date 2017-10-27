package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import final_Project_Dao.ForuseDAO;
import final_Project_Vo.ForuseVO;

/**
 * Servlet implementation class ExampleServlet
 */
@WebServlet("/UseTot.do")
public class TotForuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotForuseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String url ="Student_TotForuse.jsp";
		String condition = request.getParameter("condition");
		
		ForuseDAO fDao = ForuseDAO.getInstance();
		List<ForuseVO> totalChkList = fDao.getTotalForuse(condition,request);
		HttpSession session = request.getSession();
		
		session.setAttribute("totalSumList",totalChkList);

		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}

