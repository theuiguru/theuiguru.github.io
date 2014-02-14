package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class AddCreditCardServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCreditCardServlet() {
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

		Connection conn = DBUtil.getConn();
		String cardId = request.getParameter("cardId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cartType = request.getParameter("cartType");
		String secutityNum = request.getParameter("secutityNum");
		String expiryDate = request.getParameter("expiryDate");
		
		int cardIdLen = 18;                        //cardID lengths
		if(cardId == null || "".equals(cardId) 
				|| firstName == null || "".equals(firstName) 
				|| lastName == null || "".equals(lastName) 
				|| cartType == null || "".equals(cartType)
				|| secutityNum == null || "".equals(secutityNum) 
				|| expiryDate == null || "".equals(expiryDate) 
				|| cardId.length() != cardIdLen)            
		{     
			String errorMessage = "ERROR: ";
			if(cardId == null || "".equals(cardId) || firstName == null || "".equals(firstName) 
				|| lastName == null || "".equals(lastName) || cartType == null || "".equals(cartType)
				|| secutityNum == null || "".equals(secutityNum) || expiryDate == null || "".equals(expiryDate))
				{
					errorMessage = "Information can not be empty!<br>";
				}
			else if(cardId.length() != cardIdLen)                 
				errorMessage += "cardId must contains "+cardIdLen+" digits";
			System.out.println("lalalal3");
			response.setContentType("text/html");
			String content = "2;URL=../addCreditCard.jsp";
			response.addHeader("REFRESH", content);
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>ERROR</title>");
			out.println("<link rel=\"stylesheet\" href=\"../acors.css\">");
			out.println("</head><body>");
			out.println("<h1>&rarr; ACORS Clothing &larr;</h1>");
			out.println("<font color = \"red\" size = \"4\">"+errorMessage+"</font>");
			out.println("<p class=\"footer\">&copy; 2012 ACORS Clothing. | <a href=\"../index.jsp\">Home</a></p>");
			out.println("</body></html>");
			out.flush();
			out.close();
			return;
		}
		
		System.out.println("lalalal4");
		String sql = "select CardID from creditcard where CardID=? and CID = ?";
		ResultSet rs = DBUtil.executeQuery(conn, sql, cardId, request.getSession(true).getAttribute("cid"));
		
		String message = "Unknown error";
		String url = "../index.jsp";
		System.out.println("lalalal5");
		System.out.println("dsafdsa");
		try {

			if(!rs.next()){
				conn.setAutoCommit(false);
				sql = "insert into creditcard(CardId,FName,LName,CardType,SecurityNum,ExpiryDate,CID)" +
						"values (?,?,?,?,?,?,?)";
				int cid = Integer.valueOf((String)request.getSession().getAttribute("cid"));
				int successOrNot = DBUtil.executeUpdate(conn, sql, cardId,firstName,lastName,cartType,
						secutityNum,expiryDate,cid);  //insert this creditcard info if it don't exist
				conn.commit();
				if(successOrNot > 0){
					message = "Add Credit Card Success!!";
					url = "../cart.jsp";  //url of a page
				}
			}else{  
				message = "ERROR: CreditCard already exist!";
				url = "ListServlet";
				System.out.println("lalalal7");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, null, rs);
		}
		response.setContentType("text/html");
		String content = "2;URL="+url;
		response.addHeader("REFRESH", content);
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Message</title>");
		out.println("<link rel=\"stylesheet\" href=\"../acors.css\">");
		out.println("</head><body>");
		out.println("<h1>&rarr; ACORS Clothing &larr;</h1>");
		out.println("<font color = \"red\" size = \"4\">"+message+"</font>");
		out.println("<p class=\"footer\">&copy; 2012 ACORS Clothing. | <a href=\"../index.jsp\">Home</a></p>");
		out.println("</body></html>");
		out.flush();
		out.close();
		return;
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
