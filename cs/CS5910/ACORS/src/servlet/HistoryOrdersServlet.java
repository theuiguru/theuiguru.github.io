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

import BEAN.Order;

import util.DBUtil;

public class HistoryOrdersServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HistoryOrdersServlet() {
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
		if(request.getSession(true).getAttribute("cid") != null)
		{
			Connection conn = null;
			ResultSet RS = null;
			try{
				String sql = "select * from `order` where CID = ?";
				String qty, price, oid, pid;
				String sql2 = "UPDATE orderitems SET Quantity = " + qty + "Price = " + price + "OID = " + oid + "PID = " + pid + "WHERE Quantity >= 0";

				conn = DBUtil.getConn();
				RS = DBUtil.executeQuery(conn, sql, sql2, request.getSession(true).getAttribute("cid"));
				List<Order> historyOrders = null;
				try {
					while(RS.next()){
						if(null == historyOrders)
						{
							historyOrders = new ArrayList<Order>();
						}
						Order tmpOrder = new Order();
						tmpOrder.setCardId(RS.getString("CardID"));
						tmpOrder.setCid(RS.getInt("CID"));
						tmpOrder.setCost(RS.getFloat("Cost"));
						tmpOrder.setOid(RS.getInt("OID"));
						historyOrders.add(tmpOrder);
					}
					if(null != historyOrders)
					{
						request.getSession(true).setAttribute("historyOrders", historyOrders);
						request.getRequestDispatcher("../historyOrders.jsp").forward(request, response);
						return;
					}else{
						response.setContentType("text/html");
						String content = "2;URL=ListServlet";
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
				}
			}finally{
				DBUtil.close(conn, null, RS);
			}
		}else
		{
			response.setContentType("text/html");
			String content = "2;URL=../login.jsp";
			response.addHeader("REFRESH", content);

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>ERROR</title>");
			out.println("<link rel=\"stylesheet\" href=\"../acors.css\">");
			out.println("</head><body>");
			out.println("<h1>&rarr; ACORS Clothing &larr;</h1>");
			out.println("<font color = \"red\" size = \"4\">Login first</font>");
			out.println("<p class=\"footer\">&copy; 2012 ACORS Clothing. | <a href=\"../index.jsp\">Home</a></p>");
			out.println("</body></html>");
			out.flush();
			out.close();
			return;
		}
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
		this.doGet(request, response);
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
