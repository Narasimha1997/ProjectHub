/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.faces.facelets.util.Path;
import com.sun.org.apache.xerces.internal.util.XMLSymbols;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import core.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.annotation.MultipartConfig;
/*
 *
 * @author narasimha
 */
@WebServlet(urlPatterns = {"/SignUp","/create"})
@MultipartConfig
public class SignUp extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public String getContextPath(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("url_post", getContextPath(request)+"/create");
        response.setContentType("text/html");
      request.setAttribute("message", "You will get a mail on confirmation");
      request.getRequestDispatcher("CreateAcc.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("url_post", getContextPath(request)+"/create");
       String username=request.getParameter("name");
       String email=request.getParameter("email");
       String phone=request.getParameter("phone");
       String password=request.getParameter("password");
       String c_password=request.getParameter("c_password");
        String descr=request.getParameter("descr");
       Part file=request.getPart("profile");
       String filename=Paths.get(file.getSubmittedFileName()).getFileName().toString();
        InputStream fis=file.getInputStream();
       response.setContentType("text/plain");
       if(username==null || email==null || password==null || c_password==null || (!password.equals(c_password))|| phone==null|| filename.equals("")){
              request.setAttribute("message", "Error signing up, Make sure you have filled all details properly");
              request.getRequestDispatcher("CreateAcc.jsp").forward(request, response);
              return;
       }
       else{
           try{
           Database db=new Database();
           db.AddUser(username, email, password,phone,filename,fis,descr);
       }catch(Exception e){
           e.printStackTrace();
       }
       request.setAttribute("message", "Sign in Successful, You will get an email now");
       RequestDispatcher dis=request.getRequestDispatcher("CreateAcc.jsp");
       dis.forward(request, response);
       }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
