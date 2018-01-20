/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import core.ServletIO;
import dataObjects.UserObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import core.DatabaseProjects;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import dataObjects.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author narasimha
 */
@WebServlet(urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {



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
        response.setContentType("text/html;charset=UTF-8");
         ServletContext wContext=request.getSession().getServletContext();

                String absloute_path=wContext.getRealPath("/");
                ServletIO io=new ServletIO();
                if(io.synchronous_streamWriter(UserObject.user_profile, UserObject.f_name, absloute_path)){
                   request.setAttribute("url1", getContextPath(request)+"/SignUp");
                   request.setAttribute("url2", getContextPath(request)+"/Login");
                   request.setAttribute("url3", getContextPath(request)+"/SearchPage");
                    request.setAttribute("UID", UserObject.user_id);
                    request.setAttribute("u_name", UserObject.user_name);
                    request.setAttribute("email", UserObject.user_email);
                    request.setAttribute("phone",UserObject.phone);
                    request.setAttribute("projects", UserObject.proj);
                    request.setAttribute("descr", UserObject.descr);
                    request.setAttribute("image", getContextPath(request)+"/"+UserObject.f_name);
                    request.getRequestDispatcher("profile.jsp").forward(request, response);
                }
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

     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
