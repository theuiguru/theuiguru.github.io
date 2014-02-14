package JavaBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.net.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author cthoma29
 */
@WebServlet(name = "PizzaServlet", urlPatterns = {"/PizzaServlet"})
public class PizzaServlet extends HttpServlet {
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //TODO output your page here
            String regular = request.getParameter("regular");
            String supreme = request.getParameter("supreme");
            String vege = request.getParameter("vege");
            String cart = request.getParameter("cart");
            
            out.println(regular);
            out.println(supreme);
            out.println(vege);
            out.print(cart);
            
            int reg = 0;
            int sup = 0;
            int veg = 0;
            double total = 0;
            try {
                reg = Integer.parseInt(regular);
                sup = Integer.parseInt(supreme);
                veg = Integer.parseInt(vege);
                total = reg*8 + sup*10 + veg*10;
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            if(cart.equals("Put in Shopping Cart")) {
                HttpSession session = request.getSession();
                if(session.getAttribute("bean") != null) {
                    PizzaOrderBean pe = (PizzaOrderBean) session.getAttribute("bean");
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);                    
                }
                else {
                    PizzaOrderBean pe = new PizzaOrderBean();
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);
                    session.setAttribute("bean", pe);
                }
                RequestDispatcher sc = request.getRequestDispatcher("ShoppingCart.jsp");
                sc.forward(request, response);
            }
            
            else if(cart.equals("Check Out")) {
                HttpSession session = request.getSession();
                if(session.getAttribute("bean") != null) {
                    PizzaOrderBean pe = (PizzaOrderBean) session.getAttribute("bean");
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);                    
                }
                else {
                    PizzaOrderBean pe = new PizzaOrderBean();
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);
                    session.setAttribute("bean", pe);
                }
                RequestDispatcher view = request.getRequestDispatcher("Checkout.jsp");
                view.forward(request, response);
            }
            
            if(cart.equals("Remove Order")) {
                PizzaOrderBean pe = new PizzaOrderBean();
                HttpSession session = request.getSession();
                session.setAttribute("bean", pe);
                if(session.getAttribute("bean") != null) {
                    //PizzaOrderBean pe = (PizzaOrderBean) session.getAttribute("bean");
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);                    
                }
                else {
                    //PizzaOrderBean pe = new PizzaOrderBean();
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);
                    session.setAttribute("bean", pe);
                }
                RequestDispatcher ro = request.getRequestDispatcher("index.jsp");
                ro.forward(request, response);
            }
            
            else if(cart.equals("More Pizza")) {
                HttpSession session = request.getSession();
                if(session.getAttribute("bean") != null) {
                    PizzaOrderBean pe = (PizzaOrderBean) session.getAttribute("bean");
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);                    
                }
                else {
                    PizzaOrderBean pe = new PizzaOrderBean();
                    pe.setRegular(reg);
                    pe.setSupreme(sup);
                    pe.setVege(veg);
                    pe.setTotal(total);
                    session.setAttribute("bean", pe);
                }
                RequestDispatcher mp = request.getRequestDispatcher("index.jsp");
                mp.forward(request, response);
            }
            
        } catch(Exception e) {
            e.printStackTrace(out);
        }
        finally {
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}