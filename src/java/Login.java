/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import core.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author narasimha
 */
@WebServlet(urlPatterns = {"/Login","/auth"})
public class Login extends HttpServlet {

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
        request.setAttribute("url1", getContextPath(request)+"/SignUp");
        request.setAttribute("url2", getContextPath(request)+"/Login");
        request.setAttribute("url3", getContextPath(request)+"/SearchPage");
        request.setAttribute("message", "Always fill correct details.");
        request.setAttribute("url_post", getContextPath(request)+"/auth");
        RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
        rs.forward(request, response);
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
        request.setAttribute("url_post", getContextPath(request)+"/auth");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        if((email==null  || password==null) || (email.equals("") || password.equals(""))){
            request.setAttribute("message", "Fill all the fields");
        }
        else{
            try{
 
            Database ds=new Database();
            if(ds.auth(email, password)){
                //Add new page here
               Profile p=new Profile();
               p.doGet(request,response);
            }else{
                request.setAttribute("url1", getContextPath(request)+"/SignUp");
               request.setAttribute("url2", getContextPath(request)+"/Login");
               request.setAttribute("url3", getContextPath(request)+"/SearchPage");
                request.setAttribute("message","auth failure");
             request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getContextPath(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
