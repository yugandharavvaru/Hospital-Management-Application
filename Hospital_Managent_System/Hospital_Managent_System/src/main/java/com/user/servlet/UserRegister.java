package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/user_resister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserRegister() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try
	{
		
		String fullName =request.getParameter("fullname");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
        User u = new User(fullName,email,password);	
		
        UserDao dao = new UserDao(DBConnect.getConn());
        boolean f=dao.register(u);
        
        HttpSession session=request.getSession();
        if(f)
        {
        	session.setAttribute("sucMsg", "Register Successfully");
        	response.sendRedirect("signup.jsp");
        }
        else
        {
        	session.setAttribute("errorMsg", "Something wrong on server side");
        	response.sendRedirect("signup.jsp");     	
        }
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
