package com.etc.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ZHOUB
 * @create 2020-07-20-20:32
 */
@WebFilter("/*")
public class Filter01 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req1 = (HttpServletRequest) req;
        HttpServletResponse resp1 = (HttpServletResponse) resp;
        String requestURI = req1.getRequestURI();

        if (requestURI.endsWith("LoginServlet") || requestURI.endsWith("login.jsp")) {
            chain.doFilter(req, resp);

        } else {
            HttpSession session = req1.getSession();
            if (session.getAttribute("account") != null) {
                System.out.println(session.getAttribute("account"));
                chain.doFilter(req1, resp1);
            } else {
                resp1.sendRedirect("login.jsp");
            }
//        else {
//            HttpSession session = req1.getSession();
//            System.out.println(session);
//            if (session.getAttribute("account") != "admin") {
//                resp1.sendRedirect("login.jsp");
//            }
//        }
        }
    }

    public void init(FilterConfig config) throws ServletException {
            config.getFilterName();
//            config.getInitParameter();
            config.getServletContext();
            config.getInitParameterNames();
    }

}
