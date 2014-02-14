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
import BEAN.Cart;
import BEAN.Product;

public class OrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderServlet() {
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

		if(request.getSession().getAttribute("username") == null){
			request.getRequestDispatcher("../login.jsp").forward(request, response);
		}

		int productId = Integer.valueOf(request.getParameter("pid"));

		Product tmp = new Product();
		String sql = "select * from product where PID =?";

		//The below 2 statements are created by Chris Thomas.
		String qty, price, oid, pid;
		String sql2 = "UPDATE orderitems SET Quantity = " + qty + "Price = " + price + "OID = " + oid + "PID = " + pid + "WHERE Quantity >= 0";

		Connection conn = DBUtil.getConn();
		ResultSet rs = DBUtil.executeQuery(conn, sql, sql2, productId);
		try {
			if(rs.next()){
				tmp.setBrand(rs.getString("Brand"));
				tmp.setCategory(rs.getString("Category"));
				tmp.setGender(rs.getString("Gender"));
				tmp.setPicurl(rs.getString("PicURL"));
				tmp.setPrice(rs.getFloat("Price"));
				tmp.setProductname(rs.getString("ProductName"));
				tmp.setRemainder(rs.getInt("Remainder"));
				tmp.setSize(rs.getString("Size"));
				tmp.setPid(rs.getInt("PID"));
				Cart cart = (Cart) request.getSession().getAttribute("SESSION_CART");
				if(null == cart){
					cart = new Cart();
					request.getSession().setAttribute("SESSION_CART", cart);
			}
			boolean addSuccess = cart.addItem(tmp, 1);
		        response.setContentType("text/html");
		        String content="1;URL="+"ListServlet";
		        response.setHeader("REFRESH",content);
		        PrintWriter out = response.getWriter();
				out.println("<html><head><title>ERROR</title>");
				out.println("<link rel=\"stylesheet\" href=\"../acors.css\">");
				out.println("</head><body>");
				out.println("<h1>&rarr; ACORS Clothing &larr;</h1>");

		        if(addSuccess){
		        	out.print("<font color = \"blue\" size = \"3\">Add Success</font>");
		        }else{
		        	out.print("<font color = \"red\" size = \"3\">Aready exist</fong>");
		        }
		        out.println("<p class=\"footer\">&copy; 2012 ACORS Clothing. | <a href=\"../index.jsp\">Home</a></p>");
		        out.println("</body></html>");
		        out.flush();
		        out.close();
			}else{
				response.setContentType("text/html");

				String content = "3;URL="+"ListServlet";
				response.setHeader("REFRESH", content);
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>ERROR</title>");
				out.println("<link rel=\"stylesheet\" href=\"../acors.css\">");
				out.println("</head><body>");
				out.println("<h1>&rarr; ACORS Clothing &larr;</h1>");
				out.print("<font color = \"red\" size = \"3\">Add fail, check your DB operation</font>");
				out.println("<p class=\"footer\">&copy; 2012 ACORS Clothing. | <a href=\"../index.jsp\">Home</a></p>");
				out.println("</body></html>");
				out.flush();
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, null, rs);
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
