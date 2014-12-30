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
public class SetCookies extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
   
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SetCookies</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SetCookies</h1>");
            out.println("<p>As you first visit this page, you have the following cookies:</p>");
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie c = cookies[i];
                    out.println("Cookie #" + i + " has a name of \"" + c.getName() +
                              "\" and a value of \"" + c.getValue() + "\"<br>");
                }
            } else {
                out.println("Sorry no cookes found at all...");
            }
            out.println("<br><br>");
            out.println("Click <a href=\"SetCookies\">here</a> to reload the page and view the current cookies");
            out.println("</body>");
            out.println("</html>");
            // add sessin cookie, no maxAge set
            response.addCookie(new Cookie("en505681-updater-servlet-session", "Viewed"));
            Cookie longLivedCookie = new Cookie("en505681-updater-servlet-page", "Viewed at " + (new Date()));
            longLivedCookie.setMaxAge(60*60);  // only an hour, we like 'em fresh
            response.addCookie(longLivedCookie);
        } finally { 
            out.close();
        }
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
