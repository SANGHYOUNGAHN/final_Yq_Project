package final_Project_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.StringUtils;

import final_Project_Dao.ForuseDAO;
import final_Project_Dao.StudentDAO;
import final_Project_Vo.StudentVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.do")

public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID= 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		

	

	}
  
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String url="Student_Login_Page.jsp";
		
		String stu_id = request.getParameter("stu_id");
		String stu_pw = request.getParameter("stu_pw");
		
		StudentVO mStuVo = new StudentVO();
		StudentDAO mDao = StudentDAO.getInstance();
		int result = mDao.userCheck(stu_id, stu_pw);
		
		JSONObject jOb = new JSONObject();
		JSONArray  jArr = new JSONArray();
		String jsonData =null;
		if(result==1){
			HttpSession session = request.getSession();
			StudentVO mVo = mDao.getMember(stu_id);
			
		   
			
			jOb.put("stu_id", stu_id );
			jOb.put("stu_pw",stu_pw);
			jArr.add(jOb);
			jsonData= jOb.toString();
			//jsonData="stu_id, ash";
			System.out.println(jsonData);
			System.out.println(jArr);
			
			
			
			
			
			session.setAttribute("stu_id",mVo.getStu_id());
			session.setAttribute("loginUser", mVo);
			session.setAttribute("loginUser1", stu_id);
			
			
			
			url="Student_Main_Page.jsp";
			
		}else if(result ==0)
		{ request.setAttribute("message", "암호가 맞지 않습니다.");
		}else if(result ==-1)
		{ request.setAttribute("message", "존재하지 않는 학번입니다.");
		}
		
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}
}
		
		
		/*
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out =response.getWriter();
		JSONObject jObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		String jsonData =null;
		
		
		
		try{
			
			DBConnectionTest(jArray,request);
			
			
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		jObject.put("Mdata", jArray);
		
		jsonData = jObject.toString();
		System.out.println(jObject.toString());
		
		out.print(jsonData);
		
	
	}

	 public void DBConnectionTest(JSONArray jArray, HttpServletRequest request) throws ClassNotFoundException, SQLException {
         Connection conn = getConnection();
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         
         String stu_id = request.getParameter("stu_id");
         String stu_pw = request.getParameter("stu_pw");
         
         
         
         
         String sql = "select * from student where stu_id=? and stu_pw=?";
         try{
            System.out.println("mysql 접속됨");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stu_id);
            pstmt.setString(2, stu_pw);
            rs = pstmt.executeQuery();
            
            int i = 0;
            while(rs.next()){
               JSONObject sObject = new JSONObject();
               //System.out.println(rs.getString("stu_id"));
               //System.out.println(rs.getString("stu_pw"));
               sObject.put("stu_id", rs.getString("stu_id"));
               sObject.put("stu_pw", rs.getString("stu_pw"));
               jArray.add(sObject);
            }
         } catch(Exception e){
            e.printStackTrace();
         }finally{
            try{
               pstmt.close();
               conn.close();
               rs.close();
               System.out.println("mysql 끝");
            }catch(SQLException e){
               e.printStackTrace();
            }
         }
      }
      
      private Connection getConnection() throws ClassNotFoundException, SQLException {
         Class.forName("org.gjt.mm.mysql.Driver");
         //데이터베이스 설정
         Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");
         return c;
      }
	
 
		/*
	public String getJSON(String stu_id, String stu_pw){
		 
		if(stu_id==null) stu_id="";
		if(stu_pw==null) stu_pw="";
		
		StringBuffer resultJson = new StringBuffer("");
		resultJson.append("{\resultJson\":[");
		StudentDAO sDao = new StudentDAO();
		ArrayList<StudentVO> stuList = sDao.idPw(stu_id, stu_pw);
		
		for(int i = 0; i<stuList.size(); i++){
			 resultJson.append( "[{\"value\": \"" +stuList.get(i).getStu_id() +stuList.get(i).getStu_pw() + 
					 "\"}," );
			 //resultJson.append( "{\"value\": \"" +stuList.get(i).getStu_id() +stuList.get(i).getStu_pw() + 
			//		 "\"}," );
			 resultJson.append( "{\"value\": \"" +stuList.get(i).getStu_id() +stuList.get(i).getStu_pw() + 
					 "\"}," );
			// resultJson.append( " {\"value\": \"" +stuList.get(i).getStu_id() +stuList.get(i).getStu_pw() + 
			//		 "\"}]," );
			 
		}
		resultJson.append("]}");
		return resultJson.toString();
	}
	*/

//}
