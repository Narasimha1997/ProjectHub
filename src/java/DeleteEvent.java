/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import core.Database;
import core.DatabaseProjects;
import dataObjects.UserObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author narasimha
 */
@WebServlet(urlPatterns = {"/DeleteEvent"})
public class DeleteEvent extends HttpServlet {

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
          if(request.getParameter("mode").equals("User")&&request.getParameter("password").equals(UserObject.user_password)){
              deleteUser();
              request.getRequestDispatcher("Main").forward(request, response);
          }else if(request.getParameter("mode").equals("Project")){
              String Name = request.getParameter("Name");
              String Category = request.getParameter("Category");
              int UID = UserObject.user_id;
              deleteProject(UID, Name, Category);
              request.getRequestDispatcher("Main").forward(request, response);
          }
          else{
              request.getRequestDispatcher("Manage.jsp").forward(request, response);
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
        
    }
    private void deleteUser(){
       try{
           Database db = new Database();
           db.deleteUser(UserObject.user_id);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    private void deleteProject(int UID, String Name, String Category){
        try{
            DatabaseProjects db = new DatabaseProjects();
            db.deleteProject(UID, Name, Category);
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
