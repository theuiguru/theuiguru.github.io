package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Cart;
import BEAN.CreditCard;
import BEAN.Item;
import BEAN.Order;

import util.DBUtil;

public class CheckOutServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckOutServlet() {
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
		if(method.equals("index")){
			String sql = "select * from creditcard where CID = ?";
			Connection conn = DBUtil.getConn();
			ResultSet RS = DBUtil.executeQuery(conn, sql, request.getSession(true).getAttribute("cid"));
			List<CreditCard> creditCards = null;
			try {
				if(!RS.wasNull()){
					creditCards = new ArrayList<CreditCard>();
					while(RS.next()){
						CreditCard tmpCard = new CreditCard();
						tmpCard.setCardId(RS.getString("CardId"));
						tmpCard.setCardType(RS.getString("CardType"));
						tmpCard.setCid(RS.getInt("CID"));
						tmpCard.setExpiryDate(RS.getDate("ExpiryDate"));
						tmpCard.setfName(RS.getString("FName"));
						tmpCard.setId(RS.getInt("ID"));
						tmpCard.setlName(RS.getString("LName"));
						tmpCard.setSecurityNum(RS.getString("SecurityNum"));
						creditCards.add(tmpCard);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(null != creditCards)  //you have 1+ credit Card
			{
				request.getSession().setAttribute("creditCards", creditCards);
			}
			
			System.out.println(request.getSession(true).getAttribute("cid") + " "+creditCards.size());
			
			request.getRequestDispatcher("../checkout.jsp").forward(request, response);
			return;
		}else if(method.equals("submit")){
			
			if( request.getSession(true).getAttribute("cid") == null)
			{
				request.getRequestDispatcher("../login.jsp").forward(request, response);
				return;
			}else if(((Cart)request.getSession(true).getAttribute("SESSION_CART")).getItems().size() == 0){
				// can not commit if no item
				request.getRequestDispatcher("../checkout.jsp").forward(request, response);
				return;
			}
			Order order = new Order();
			order.setCid(Integer.parseInt((String)request.getSession(true).getAttribute("cid")));
			order.setCardId(request.getParameter("payCardId"));
//			if(null == payCardId ||)
			
			Connection conn = DBUtil.getConn();

			Cart cart = (Cart)request.getSession().getAttribute("SESSION_CART");
			PreparedStatement pstmt = null, stmt2 = null;
			ResultSet OIDRS = null;
			try {
					
					conn.setAutoCommit(false);
					
					order.setCost(cart.getCost());
					String orderSql = "INSERT INTO  `acors`.`order` ( `CID` ,`Cost` ,`CardID`)VALUES ( ? , ? , ? );";//insert into order(`CID`,`Cost`,`CardID`) values(?,?,?);";
					pstmt = conn.prepareStatement(orderSql);
					pstmt.setInt(1, order.getCid());
					pstmt.setFloat(2, order.getCost());
					System.out.println(order.getCardId());
					pstmt.setObject(3, order.getCardId());
					pstmt.executeUpdate(); //insert this order into DB
					
					String OIDSQL = "SELECT MAX( OID ) FROM  `order`";
					stmt2 = conn.prepareStatement(OIDSQL);
					OIDRS = stmt2.executeQuery();
					Integer oid = null;
					if(OIDRS.next()){
						oid = OIDRS.getInt(1);
						System.out.println(oid + "lava");
					}else{
						System.out.println("ERROR:no order id");
					}
					
					Iterator<Entry<Integer, Item>> iter = cart.getItems().entrySet().iterator();
					String orderItemSql = "";
					String productNumSql = "";
					while(iter.hasNext()){
						Map.Entry<Integer, Item> entry = (Map.Entry<Integer, Item>)iter.next();
						int key = entry.getKey();
						Item item = entry.getValue();
						orderItemSql = "insert into orderitems(Quantity, Price, OID, PID) values(?,?,?,?)";
						pstmt = conn.prepareStatement(orderItemSql);
						pstmt.setInt(1, item.getQuantity());
						pstmt.setFloat(2, item.getPrice());
						pstmt.setInt(3, oid);
						pstmt.setInt(4, key);
						pstmt.executeUpdate();
						
						productNumSql = "update product set Remainder=Remainder-? where PID = ?";
						PreparedStatement productNumpstmt = conn.prepareStatement(productNumSql);
						productNumpstmt.setInt(1, item.getQuantity());
						productNumpstmt.setInt(2, key);
						productNumpstmt.executeUpdate();
					}
					conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try{
					conn.rollback();
				}catch(SQLException e2){
					e2.printStackTrace();
				}
			}finally{
				DBUtil.close(conn, pstmt, OIDRS);
				try {
					if(stmt2 != null)
					stmt2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("../success.jsp?orderNumber="+System.currentTimeMillis()).forward(request, response);
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
