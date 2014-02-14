package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Product;

import util.DBUtil;

public class ListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ListServlet() {
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
		String sql = "select * from product;";
		Connection conn = DBUtil.getConn();
		ResultSet rs = DBUtil.executeQuery(conn, sql);
		List<Product> allProduct = new Vector<Product>();
		try{
			while(rs.next()){
				Product tmp = new Product();
				tmp.setBrand(rs.getString("Brand"));
				tmp.setCategory(rs.getString("Category"));
				tmp.setGender(rs.getString("Gender"));
				tmp.setPicurl(rs.getString("PicURL"));
				tmp.setPrice(rs.getFloat("Price"));
				tmp.setProductname(rs.getString("ProductName"));
				tmp.setRemainder(rs.getInt("Remainder"));
				tmp.setSize(rs.getString("Size"));
				tmp.setPid(rs.getInt("PID"));
				allProduct.add(tmp);
			}
			request.setAttribute("allProduct", allProduct);
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}finally{
			DBUtil.close(conn, null, rs);
		}
		request.getRequestDispatcher("../order.jsp").forward(request, response);
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
