package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tmp_bir = request.getParameter("birthday");
		java.util.Date birthday = null;
		String gender = request.getParameter("gender");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zip");
		
		String errorMessage = "";
		if(null == firstName){
			errorMessage += "firstName empty!<br/>";
		}
		if(lastName == null){
			errorMessage += "lastName empty!<br/>";
		}
		if(userName != null){
			String sql = "select CID from customer_registeration where CLoginID = ?";
			Connection conn = DBUtil.getConn();
			ResultSet rs = DBUtil.executeQuery(conn, sql, userName);
			try{
				if(rs.next()){
					errorMessage += "userName is used!";
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}finally{
				DBUtil.close(conn, null, rs);
			}

		}else if(userName == null || userName.length() < 6){
			errorMessage += "userName empty or length < 6!<br/>";
		}
		if(password == null || password.length() < 6){
			errorMessage += "password empty or length< 6!<br/>";
		}
		if(tmp_bir == null){
			errorMessage += "birthday empty<br/>";
		}else{
			try{
				birthday = sdf.parse(tmp_bir);  //format birthday 
				
			}catch(java.text.ParseException pe){
//				pe.printStackTrace();
				request.getRequestDispatcher("../register.jsp").forward(request, response);
				return;
			}
		}
		if(gender == null){
			errorMessage += "gender empty!<br/>";
		}
		if(street == null){
			errorMessage += "street empty!<br/>";
		}
		if(city == null){
			errorMessage += "city empty!<br/>";
		}
		if(state == null){
			errorMessage += "state empty!<br/>";
		}
		if(zipcode == null){
			errorMessage += "zip empty!<br/>";
		}
		if(email != null && !email.contains("@"))
		{
			errorMessage += "email format error!<br/>";
		}
		
		if("".equals(errorMessage)){  //if the input has no error
			Connection conn = DBUtil.getConn(); 
			try{
				conn.setAutoCommit(false);//this is a transaction 
				conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
				
				String sql1 = "insert into customer_registeration(CLoginID, CPassword) values(?,?)";
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, userName);
				pstmt1.setString(2, password);
				pstmt1.executeUpdate();
				pstmt1.close();
				
				String sql3 = "select CID from customer_registeration where CLoginID = ?";
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);
				pstmt3.setString(1, userName);
				ResultSet trs = pstmt3.executeQuery();
				trs.next();
				int tmpCID = trs.getInt(1);
				pstmt3.close();
	
				//customer_registeration update first, for CID in imformatioon refer to customer_registeration(CID)
				String sql2 = "insert into customer_information(FName,LName,Gender,Tel,Email,Birthday,CID) values(?,?,?,?,?,?,?)";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, firstName);
				pstmt2.setString(2, lastName);
				pstmt2.setString(3, gender);
				pstmt2.setString(4, phone);
				pstmt2.setString(5, email);
				pstmt2.setDate(6, new java.sql.Date(birthday.getTime()));
				pstmt2.setInt(7, tmpCID);
				pstmt2.executeUpdate();
				pstmt2.close();
				conn.commit();
			
			}catch(Exception e){
				e.printStackTrace();
				try {
					conn.rollback();
					errorMessage = "transation error!";
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}finally{
				DBUtil.close(conn, null, null);
			}
			
		
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>error page</TITLE>");
			if(!errorMessage.equals("")){
				out.println("  <meta http-equiv=\"refresh\"content=\"3; url=../register.jsp\">");//redirect after 3s
			}else{
				out.println("  <meta http-equiv=\"refresh\"content=\"3; url=../login.jsp\">");
			}
			
		
			out.println("</HEAD>");
			out.println("  <BODY>");

			if(!errorMessage.equals("")){
				out.println("<font size = \"5\" color = \"red\">"+errorMessage+"</font>");
			}else{
				out.println("<font size = \"4\" color = \"green\"> Register success!</font>");
			}
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			return;
		}
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		//redirect after 3s
		out.println("  <HEAD><TITLE>A Servlet</TITLE><meta http-equiv=\"refresh\"content=\"3; url=../register.jsp\"></HEAD>");
		out.println("  <BODY>");
		out.println("<font size = \"5\" color = \"red\">"+errorMessage+"hahaha</font>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
