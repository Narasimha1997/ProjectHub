/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import  core.Database;
import dataObjects.UserObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author narasimha
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/UploadProj"})
public class UploadProj extends HttpServlet {

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
        request.setAttribute("msg", "Fill all the fileds");
        request.getRequestDispatcher("./Projects/upload.jsp").forward(request, response);
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
        String name = request.getParameter("projectName").trim();
        String desc = request.getParameter("projectDesc").trim();
        String domain = request.getParameter("domain").trim();
        String gitLink = request.getParameter("gitLink").trim();
        String teamName = request.getParameter("teamName").trim();
        String msg = request.getParameter("msg").trim();
         Part file=request.getPart("icon");
         String filename=Paths.get(file.getSubmittedFileName()).getFileName().toString();
        InputStream fis=file.getInputStream();
        //TODO add to database
       try{
           Database db = new Database();
           db.uploadProject(UserObject.user_id, name, desc, domain, gitLink, teamName, msg, fis);
       }catch(Exception e){
           System.out.println(e);
       }
        //then
        request.getRequestDispatcher("Projects/upload.jsp").forward(request, response);
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
