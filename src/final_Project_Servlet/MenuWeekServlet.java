package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import final_Project_Dao.MenuWeekDAO;
import final_Project_Vo.MenuWeekVO;

/**
 * Servlet implementation class MenuWeekServlet
 */
@WebServlet("/MenuWeek.do")
public class MenuWeekServlet extends HttpServlet{
private static final long serialVersionUID=1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */ 
	
	public MenuWeekServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServlet request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("MenuWeek.do");
		dispatcher.forward( request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "Student_Menuweek.jsp";
		

		MenuWeekDAO mDao = MenuWeekDAO.getInstance();
		List<MenuWeekVO> menuWeekList = mDao.selectWeekMenu();
		request.setAttribute("menuWeekList", menuWeekList);
	
		
		/*
		JSONObject jWeekObject = new JSONObject();
		JSONArray jWeekArray = new JSONArray();
		
		for(int i=0; i<menuWeekList.size(); i++){
		
			jWeekObject.put("mn_date", menuWeekList.get(i).getMn_date());
			jWeekObject.put("chain", menuWeekList.get(i).getChain());
			jWeekObject.put("mn_type", menuWeekList.get(i).getMn_type());
			jWeekObject.put("mn_name", menuWeekList.get(i).getMn_name());
			jWeekObject.put("mn_price", menuWeekList.get(i).getMn_price());
			jWeekArray.add(jWeekObject);
			
			
			
			
		}
		
		System.out.println(jWeekArray);
		*/
		
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	}	
}
