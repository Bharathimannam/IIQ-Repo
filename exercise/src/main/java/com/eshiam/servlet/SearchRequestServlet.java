package com.eshiam.servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import com.eshiam.domain.SearchRequest;
import com.eshiam.domain.ServiceDTO;
import com.eshiam.service.SearchRequestService;
import com.eshiam.service.SearchRequestServiceImpl;
import com.eshiam.utils.ObjectMapperUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchReqSevlet
 */
@WebServlet("/exercise/SearchRequestServlet")
public class SearchRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchRequestService searchRequestService = new SearchRequestServiceImpl();

	/**
	 * Default constructor.
	 */
	public SearchRequestServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestData = request.getReader().lines().collect(Collectors.joining());
		System.out.println(requestData);
		SearchRequest searchRequest= null;
		try {
			searchRequest = ObjectMapperUtils.readValue(requestData,SearchRequest.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServiceDTO<SearchRequest> dto = searchRequestService.retrieve(searchRequest);
		try {
			response.getWriter().write(ObjectMapperUtils.writeValueAsString(dto));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
