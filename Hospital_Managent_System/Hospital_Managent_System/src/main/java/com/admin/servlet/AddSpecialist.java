package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecialistDao;
import com.db.DBConnect;


@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddSpecialist() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	
		
		String spec = request.getParameter("specName");
		
		SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
		boolean f = dao.addSpecialist(spec);
		
		HttpSession session =request.getSession();
		
		
		if(f)
		{
			session.setAttribute("succMsg", "Specialist Added");
		    response.sendRedirect("admin/index.jsp");
		}
		
		else
		{
			session.setAttribute("errorMsg", "something wrong on server");
		    response.sendRedirect("admin/index.jsp");
		    
		}
	
	}

}
