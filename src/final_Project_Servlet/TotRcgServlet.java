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
import final_Project_Dao.RechargeDAO;
import final_Project_Vo.ForuseVO;

/**
 * Servlet implementation class TotRcgServlet
 */
@WebServlet("/TotRcg.do")
public class TotRcgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotRcgServlet() {
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
		// TODO Auto-generated method stub

		String url ="Student_TotRcg_View.jsp";
		String condition = request.getParameter("condition");
		
		RechargeDAO rDao = RechargeDAO.getInstance();
		List<ForuseVO> rcgList = rDao.getTotalRcg(condition,request);
		HttpSession session = request.getSession();
		//session 에서 똑같은 내용을 보여주지 않기 위해서 정보를 보여줄 페이지에서는 따음표 사이이고 다른것에서는 리스트 명칭(뒤)
		session.setAttribute("totRcgList",rcgList);

		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}
