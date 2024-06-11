package com.eshiam.servlet;

import java.io.IOException;
import java.util.List;

import com.eshiam.dao.RoleDAO;
import com.eshiam.dao.RoleDAOImpl;
import com.eshiam.service.RoleService;
import com.eshiam.service.RoleServiceImpl;
import com.eshiam.utils.ObjectMapperUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadRoleServlet
 */
public class LoadRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService=new RoleServiceImpl();
	private RoleDAO roleDAO=new RoleDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request,response);
		List<String> accessList=roleDAO.populateAccessListData();
		System.out.println(accessList);
		try {
			String responseJSON=ObjectMapperUtils.writeValueAsString(accessList);
			System.out.println("Response:"+responseJSON);
			response.getWriter().write(responseJSON);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
