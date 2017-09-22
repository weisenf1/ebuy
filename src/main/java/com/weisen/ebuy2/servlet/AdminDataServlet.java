package com.weisen.ebuy2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weisen.ebuy2.dao.AdminDao;
import com.weisen.ebuy2.entity.Admin;

/**
 * Servlet implementation class AdminDataServlet
 */
public class AdminDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDataServlet() {
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
		String type=request.getParameter("hide");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String permission=request.getParameter("permission");
		Admin admin=new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setPermission(permission);
		switch(type) {
			case "insert":insert(admin);break;
			case "delete":delete(admin);break;
			case "update":update(admin);break;
		}
		request.getRequestDispatcher("AdminData.jsp").forward(request, response);
		//System.out.println(type+""+username);
	}
	protected void insert(Admin admin) {
		new AdminDao().adminInsert(admin);
	}
	protected void delete(Admin admin) {
		new AdminDao().adminDelete(admin);
	}
	protected void update(Admin admin) {
		new AdminDao().adminUpdate(admin);
	}


}
