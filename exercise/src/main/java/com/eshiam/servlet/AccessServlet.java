package com.eshiam.servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import com.eshiam.domain.Access;
import com.eshiam.domain.ServiceDTO;
import com.eshiam.service.AccessService;
import com.eshiam.service.AccessServiceImpl;
import com.eshiam.utils.ObjectMapperUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AccessServlet
 */
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccessService accessService=new AccessServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestData = request.getReader().lines().collect(Collectors.joining());
		System.out.println("Request:"+requestData);
		Access access=null;
		try {
			access=ObjectMapperUtils.readValue(requestData, Access.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServiceDTO<Access> dto_save = null;
		ServiceDTO<Access> dto_retrieve = null;
		ServiceDTO<Access> dto_delete = null;
		try {
			if(access.getAction().equalsIgnoreCase("Save")) {
				System.out.println("Entering Save Function");
				dto_save = accessService.save(access);
				String responseJSON=ObjectMapperUtils.writeValueAsString(dto_save);
				System.out.println("Response:"+responseJSON);
				response.getWriter().write(responseJSON);
			}else if(access.getAction().equalsIgnoreCase("Retrieve")) {
				System.out.println("Entering Retrieve Function");
				dto_retrieve = accessService.retriew(access);
				String responseJSON=ObjectMapperUtils.writeValueAsString(dto_retrieve);
				System.out.println("Response:"+responseJSON);
				response.getWriter().write(responseJSON);
			}else if(access.getAction().equalsIgnoreCase("Delete")) {
				System.out.println("Entering Delete Function");
				dto_delete = accessService.delete(access);
				String responseJSON=ObjectMapperUtils.writeValueAsString(dto_delete);
				System.out.println("Response:"+responseJSON);
				response.getWriter().write(responseJSON);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
