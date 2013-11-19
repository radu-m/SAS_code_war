/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssase13.servlets;

import com.ssase13.model.JsfLogin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miul
 */
@WebServlet(name = "ViewFriendProfile", urlPatterns = {"/inou"})
public class ViewFriendProfile extends HttpServlet {
    HttpSession session;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public ViewFriendProfile(){
        try{
            this.session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
        }
        catch(Exception e){
            System.out.print("\n ################ \n");
            System.out.print("------ NOT LOGGED IN ----------");
            System.out.print("\n ############### \n");
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            JsfLogin identId = new JsfLogin();
            
            System.out.print("\n --------------");
            System.out.print(this.session.getId());
            System.out.print("------------- \n");


            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewFriendProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewFriendProfile at " + request.getSession().getId()+ "</h1>");
            out.println("<h1>Servlet ViewFriendProfile at " + this.session.getId() + "</h1>");
            out.println("<h1>Servlet ViewFriendProfile at " + request.getParameter("friendId") + "</h1>");            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
