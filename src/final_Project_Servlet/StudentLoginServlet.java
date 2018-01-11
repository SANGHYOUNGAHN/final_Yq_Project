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
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "Student_Login_Page.jsp";

		String stu_id = request.getParameter("stu_id");
		String stu_pw = request.getParameter("stu_pw");

		StudentVO mStuVo = new StudentVO();
		StudentDAO mDao = StudentDAO.getInstance();
		int result = mDao.userCheck(stu_id, stu_pw);

		if (result == 1) {
			HttpSession session = request.getSession();
			StudentVO mVo = mDao.getMember(stu_id);

			session.setAttribute("stu_id", mVo.getStu_id());
			session.setAttribute("loginUser", mVo);
			session.setAttribute("loginUser1", stu_id);

			url = "Student_Main_Page.jsp";

		} else if (result == 0) {
			request.setAttribute("message", "암호가 맞지 않습니다.");
		} else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 학번입니다.");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
