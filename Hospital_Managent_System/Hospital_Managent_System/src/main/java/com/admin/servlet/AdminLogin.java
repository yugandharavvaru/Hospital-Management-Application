package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLogin() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
            
			HttpSession session = request.getSession();
			
			if(email.equals("admin@gmail.com") && password.equals("admin"))
			{
				session.setAttribute("adminobj", new User());
			    response.sendRedirect("admin/index.jsp");
			}
			
			else
			{
				session.setAttribute("errorMsg", "Invalid email or password");
			    response.sendRedirect("admin_login.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
