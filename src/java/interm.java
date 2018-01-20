/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import core.DatabaseProjects;
import core.DatabaseSearch;
import dataObjects.PrefetchCache;
import dataObjects.ProjectOb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author narasimha
 */
@WebServlet(urlPatterns = {"/interm"})
public class interm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String EMAIL = request.getParameter("EMAIL");
        try{
            DatabaseSearch s = new DatabaseSearch();
            s.searchProfiles("email", EMAIL);
            request.getRequestDispatcher("Profile3View").forward(request, response);
        }catch(Exception e){
            System.out.println(">>>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Category = request.getParameter("Category");
        String Name = request.getParameter("Name");
        try{
            DatabaseProjects dbs = new DatabaseProjects();
            int UID = dbs.getUID(Name, Category);
            System.out.println("UID IS "+UID);
            request.getRequestDispatcher("View.jsp?UID="+UID+"&name="+Name).forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
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
