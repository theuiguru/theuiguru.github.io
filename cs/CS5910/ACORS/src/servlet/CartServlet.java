package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Cart;

public class CartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CartServlet() {
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
		String method = request.getParameter("method");
		
		if(request.getSession().getAttribute("SESSION_CART") == null){  //if no cart exist
			//your cart have no goods
			response.setContentType("text/html");
			String content = "2;URL=ListServlet";
			response.addHeader("REFRESH", content);
		
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>ERROR</title>");
			out.println("<link rel=\"stylesheet\" href=\"../acors.css\">");
			out.println("</head><body>");
			out.println("<h1>&rarr; ACORS Clothing &larr;</h1>");
			out.println("<font color = \"red\" size = \"4\">No goods in your cart</font>");
			out.println("<p class=\"footer\">&copy; 2012 ACORS Clothing. | <a href=\"../index.jsp\">Home</a></p>");
			out.println("</body></html>");
			out.flush();
			out.close();
		}
		else {
			if(method == null){  //default action, show the cart
				request.getRequestDispatcher("../cart.jsp").forward(request, response);
			}else if(method.equals("clear")){  //clear the cart
				Cart cart = (Cart) request.getSession().getAttribute("SESSION_CART");
				cart.clear();
				request.getRequestDispatcher("../cart.jsp").forward(request, response);
			}else if(method.equals("deleteItems")){
				String []itemCheck = request.getParameterValues("itemCheck");
				if(itemCheck == null || itemCheck.length == 0){
					request.getRequestDispatcher("../cart.jsp").forward(request, response);
					return;
				}
				int []productIds = new int[itemCheck.length];
				for(int i = 0; i < productIds.length; i++){
					productIds[i] = Integer.valueOf(itemCheck[i]);
				}
				
				Cart cart = (Cart)request.getSession().getAttribute("SESSION_CART");
				cart.deleteItemByProductId(productIds);
				request.getRequestDispatcher("../cart.jsp").forward(request, response);
			}else if(method.equals("modify")){
				String []itemCheck = request.getParameterValues("itemCheck");
				if(null == itemCheck || 0 == itemCheck.length){
					request.getRequestDispatcher("../cart.jsp").forward(request, response);
					return;
				}
				
				Cart cart = (Cart)request.getSession().getAttribute("SESSION_CART");
				for(String productId :itemCheck){
					String quantity = request.getParameter("quantity"+productId);
					cart.modifyNumberById((int)Integer.valueOf(productId), Integer.valueOf(quantity));
				}
				
				request.getRequestDispatcher("../cart.jsp").forward(request, response);
			}
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
