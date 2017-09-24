package com.weisen.ebuy2.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weisen.ebuy2.dao.AdminDao;
import com.weisen.ebuy2.entity.Admin;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		List<Admin> adminList=new AdminDao().adminQuery();
		for(int i=0;i<adminList.size();i++) {
			Admin admin=adminList.get(i);
			if(admin.getUsername().equals(username)&&admin.getPassword().equals(password)) {
				if(admin.getPermission().equals("y")) {
					request.getSession().setAttribute("admin", admin);
					request.getRequestDispatcher("AdminData.jsp").forward(request, response);
					return;
				}
			}
		}
		
		response.sendRedirect("AdminManagement.jsp");
	}

}
