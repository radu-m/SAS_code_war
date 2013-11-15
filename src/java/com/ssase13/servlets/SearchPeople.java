/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssase13.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import com.ssase13.model.UserFactory;
import com.ssase13.model.friendProfile;

/**
 *
 * @author miul
 */
@WebServlet("/people")
public class SearchPeople extends HttpServlet {

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
    
    protected void searchByName(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    
        UserFactory userFactory = new UserFactory();
        
        request.setAttribute("people", userFactory.listByName(request.getParameter("searchName")));
//        request.setAttribute("people", userFactory.listByName("bla"));

        System.out.print("\n ---------------- ");
        System.out.print(request.getAttribute("people"));
        System.out.print(" ---------------- \n");
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/searchForFriends.jsp");
        rd.forward(request, response);
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
        System.out.print(" ------------GET----------- ");
         
        searchByName(request, response);
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
//        processRequest(request, response);
        System.out.print(" ------POST---------- ");
        
        searchByName(request, response);
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
