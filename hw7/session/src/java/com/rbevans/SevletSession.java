/*
 * SetCookies.java
 * 
 * Created on Oct 29, 2007, 9:07:38 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.io.*;
import java.net.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author evansrb1
 */
public class SevletSession extends HttpServlet {
   private final static String KEY = "accessCount";
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Integer accessCount = (Integer)session.getAttribute(KEY);
        try {
   
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Session Servlet</title>");  
            out.println("</head>");
            out.println("<body>");
            if (accessCount == null) {
                out.println("<h1>Welcome to the Session Servlet</h1>");
                accessCount = new Integer(1);                
            } else {
                out.println("<h1>Welcome back to the Session Servlet</h1>");
                accessCount = new Integer(accessCount.intValue() + 1);
            }

            out.println("Information on your session is as follows:");            
            out.println("<table border=\"1\">");
            out.println("<tr bgcolor=\"#FFAD00\">");
            out.println("<th>Item</th><th>Value</th>");
            out.println("</tr>");
            out.println("<tr><td>Session ID</td><td>");
            out.println(session.getId());
            out.println("</td>");
            out.println("<tr><td>Creation time</td><td>");
            out.println(new Date(session.getCreationTime()));
            out.println("</td>");
            out.println("<tr><td>Time of last Access</td><td>");
            out.println(new Date(session.getLastAccessedTime()));
            out.println("</td>");
            out.println("<tr><td>Times visited page this session</td><td>");
            if (accessCount.intValue() == 1) {
                out.println("First time visited!");
            } else {
                out.println(accessCount.toString());
            }
            out.println("</td>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            if (out != null) {
                out.close();
            }
        }
        session.setAttribute(KEY, accessCount);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
