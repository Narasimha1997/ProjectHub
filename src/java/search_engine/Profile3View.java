/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search_engine;

import dataObjects.UserObject;
import java.io.IOException;
import java.io.PrintWriter;
import dataObjects.ProfilesResult;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import core.ServletIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author narasimha
 */
@WebServlet(name = "Profile3View", urlPatterns = {"/Profile3View"})
public class Profile3View extends HttpServlet {

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
         request.setAttribute("UID", UserObject.user_id);
                    request.setAttribute("u_name", ProfilesResult.username);
                    request.setAttribute("email", ProfilesResult.email);
                    request.setAttribute("phone",ProfilesResult.phone);
                    request.setAttribute("projects", ProfilesResult.proj_num);
                    request.setAttribute("descr", ProfilesResult.desc);
                    ServletIO io = new ServletIO();
                     ServletContext wContext=request.getSession().getServletContext();
                    String absloute_path=wContext.getRealPath("/");
                    io.synchronous_streamWriter(ProfilesResult.image_data, "search_pro.jpg", absloute_path);
                    request.setAttribute("image", getContextPath(request)+"/search_pro.jpg" );
                    request.getRequestDispatcher("search/profile2.jsp").forward(request, response);
    }
    public String getContextPath(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
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
