package com.eshiam.servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import com.eshiam.dao.RoleDAO;
import com.eshiam.dao.RoleDAOImpl;
import com.eshiam.domain.Role;
import com.eshiam.domain.ServiceDTO;
import com.eshiam.service.RoleService;
import com.eshiam.service.RoleServiceImpl;
import com.eshiam.utils.ObjectMapperUtils1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoleServlet
 */
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService=new RoleServiceImpl();
	private RoleDAO roleDAO=new RoleDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestData = request.getReader().lines().collect(Collectors.joining());
		System.out.println("Request:"+requestData);
		Role role=null;
		try {
			role=ObjectMapperUtils1.readValue(requestData, Role.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServiceDTO<Role> dto=roleService.save(role);
		try {
			String responseJSON=ObjectMapperUtils1.writeValueAsString(dto);
			System.out.println("Response:"+responseJSON);
			response.getWriter().write(responseJSON);
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

}
