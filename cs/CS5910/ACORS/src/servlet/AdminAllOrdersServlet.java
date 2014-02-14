package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
import BEAN.Order;

public class AdminAllOrdersServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminAllOrdersServlet() {
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

		String sql = "select * from `order` ";
		Connection conn = DBUtil.getConn();
		ResultSet RS = DBUtil.executeQuery(conn, sql);
		List<Order> allOrders = null;
		try {
			while(RS.next()){
				if(null == allOrders)
				{
					allOrders = new ArrayList<Order>();
				}
				Order tmpOrder = new Order();
				tmpOrder.setCardId(RS.getString("CardID"));
				tmpOrder.setCid(RS.getInt("CID"));
				tmpOrder.setCost(RS.getFloat("Cost"));
				tmpOrder.setOid(RS.getInt("OID"));
				allOrders.add(tmpOrder);
			}
			if(null != allOrders)
			{
				request.getSession(true).setAttribute("allOrders", allOrders);
				request.getRequestDispatcher("../adminAllOrders.jsp").forward(request, response);
				return;
			}else{
				response.setContentType("text/html");
				String content = "2;URL=../adminControlPane.jsp";
				response.addHeader("REFRESH", content);
			
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>ERROR</title>");
				out.println("<link rel=\"stylesheet\" href=\"../acors.css\">");
				out.println("</head><body>");
				out.println("<h1>&rarr; ACORS Clothing &larr;</h1>");
				out.println("<font color = \"red\" size = \"5\">No order!</font>");
				out.println("<p class=\"footer\">&copy; 2012 ACORS Clothing. | <a href=\"../index.jsp\">Home</a></p>");
				out.println("</body></html>");
				out.flush();
				out.close();
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, null, RS);
		}

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
