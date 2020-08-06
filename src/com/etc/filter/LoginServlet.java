package com.etc.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ZHOUB
 * @create 2020-07-20-20:37
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if (account.endsWith("admin")&&password.equals("123456")){
            session.setAttribute("account",account);
            response.sendRedirect("admin/a.html");
//            request.getRequestDispatcher("admin/a.html").forward(request,response);
        }
//        else {
////            response.sendRedirect("login.jsp");
////        }


    }
}
