package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import final_Project_Dao.MenuDAO;
import final_Project_Dao.MenuWeekDAO;
import final_Project_Vo.MenuVO;
import final_Project_Vo.MenuWeekVO;


/**
 * 
 * @author AHN
 * Servlet implementation class MenuServlet
 */
@WebServlet("/Menu.do")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public MenuServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServlet request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.do");
		dispatcher.forward( request,response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//String url = "menu3.jsp";
		String url= "Student_Menu.jsp";
		MenuWeekDAO wDao= MenuWeekDAO.getInstance();
		MenuDAO mDao = MenuDAO.getInstance();
		List<MenuVO> menuInSungList = mDao.selectInSungMenu();
		List<MenuVO> menuHwanList= mDao.selectHwanMenu();
		List<MenuVO> menuDormList= mDao.selectDormMenu();
		List<MenuWeekVO> menuWeekList = wDao.selectWeekMenu();
		
		
		
		
		JSONArray jArr = new JSONArray();
	    
		
		HttpSession session = request.getSession();
		
		session.setAttribute("menuInSungList", menuInSungList);
		session.setAttribute("menuHwanList", menuHwanList);
		session.setAttribute("menuDormList", menuDormList);
		session.setAttribute("menuWeekList", menuWeekList);
		
		request.setAttribute("menuInSungList", menuInSungList);
		request.setAttribute("menuHwanList", menuHwanList);
		request.setAttribute("menuDormList", menuDormList);
		request.setAttribute("menuWeekList", menuWeekList);
		
	
 

		for(int i=0; i< menuInSungList.size(); i++ ){
			
			JSONObject jOInsung = new JSONObject();
			jOInsung.put("mn_date", menuInSungList.get(i).getMn_date());
			System.out.println(jOInsung);
			jOInsung.put("chain",  menuInSungList.get(i).getChain());
			jOInsung.put("mn_type",  menuInSungList.get(i).getMn_type());
			jOInsung.put("mn_name",  menuInSungList.get(i).getMn_name());
			jOInsung.put("mn_price",  menuInSungList.get(i).getMn_price());
			jOInsung.put("mn_sold",  menuInSungList.get(i).getMn_sold());
			jArr.add(jOInsung);
			
		}
		
		
		
		for(int i=0; i< menuHwanList.size(); i++ ){
			
			JSONObject jOhwan= new JSONObject();
			jOhwan.put("mn_date", menuHwanList.get(i).getMn_date());
			jOhwan.put("chain", menuHwanList.get(i).getChain());
			jOhwan.put("mn_type", menuHwanList.get(i).getMn_type());
			jOhwan.put("mn_name", menuHwanList.get(i).getMn_name());
			jOhwan.put("mn_price", menuHwanList.get(i).getMn_price());
			jOhwan.put("mn_sold", menuHwanList.get(i).getMn_sold());
			jArr.add(jOhwan);
		

		}
		
		

  
		
		
		

		for(int i=0; i< menuDormList.size(); i++){
			
			JSONObject jODorm = new JSONObject();
			jODorm.put("mn_date", menuDormList.get(i).getMn_date());
			jODorm.put("chain", menuDormList.get(i).getChain());
			jODorm.put("mn_type", menuDormList.get(i).getMn_type());
			jODorm.put("mn_name", menuDormList.get(i).getMn_name());
			jODorm.put("mn_price", menuDormList.get(i).getMn_price());
			jODorm.put("mn_sold", menuDormList.get(i).getMn_sold());
			
			
		
			jArr.add(jODorm);
		}
		
		
		/*
		for(int i=0; i<menuWeekList.size(); i++){
			
			
			JSONObject jWeekObject = new JSONObject();
			jWeekObject.put("mn_date", menuWeekList.get(i).getMn_date());
			jWeekObject.put("chain", menuWeekList.get(i).getChain());
			jWeekObject.put("mn_type", menuWeekList.get(i).getMn_type());
			jWeekObject.put("mn_name", menuWeekList.get(i).getMn_name());
			jWeekObject.put("mn_price", menuWeekList.get(i).getMn_price());
			jArr.add(jWeekObject);
			
			
			
			
		}
		*/
		
	
		
	System.out.println(jArr);
		
		
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);

		}
}
