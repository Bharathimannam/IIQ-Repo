package com.eshiam.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.eshaim.service.WorkQueueService;
import com.eshaim.service.WorkQueueServiceImpl;
import com.eshiam.domain.Item;
import com.eshiam.domain.LoginUser;
import com.eshiam.domain.ServiceDTO;
import com.eshiam.domain.User;
import com.eshiam.domain.WorkQueue;
import com.eshiam.utils.ObjectMapperUtils2;

/**
 * Servlet implementation class WorkQueueServlet
 */
public class WorkQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WorkQueueService workQueueService = new WorkQueueServiceImpl();  
	   
    public WorkQueueServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet Method");
		String selectedOption = request.getParameter("selectedOption");
		List<Item> accessData = workQueueService.getAccessData(selectedOption);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(ObjectMapperUtils2.writeValueAsString(accessData));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost Method");
		//passing the JSON Object
		String requestData = request.getReader().lines().collect(Collectors.joining());
		System.out.println("requestData: "+requestData);
		
		WorkQueue workQueue = null;
		try {
			workQueue = ObjectMapperUtils2.readValue(requestData, WorkQueue.class);
			System.out.println("workQueue:" + workQueue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*ServiceDTO<WorkQueue> dto = workQueueService.save(workQueue);
		try {
			String responseJSON = ObjectMapperUtils.writeValueAsString(dto);
			System.out.println("ResponseJSON: "+responseJSON);
			if (responseJSON != null) {
		        response.getWriter().write(responseJSON);
		    } else {
		        System.out.println("responseJSON is null"); 
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// Get the login user from the session
	    HttpSession session = request.getSession();
	    if (session != null) {
	        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
	        System.out.println("loginUser" + loginUser);
	    	//LoginUser loginUser = new LoginUser();
	    	//loginUser.setLoginId("ABCD12345");
	        workQueue.setLoginUser(loginUser);
	    	
	        if (loginUser != null) {
	            // Passing the loginUser to the service layer
	            ServiceDTO<WorkQueue> dto = workQueueService.save(workQueue);
	            try {
	                String responseJSON = ObjectMapperUtils2.writeValueAsString(dto);
	                System.out.println("ResponseJSON: " + responseJSON);
	                if (responseJSON != null) {
	                    response.getWriter().write(responseJSON);
	                } else {
	                    System.out.println("responseJSON is null"); // Add this line for debugging
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else {
	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User is not logged in");
	        }
	    } else {
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User session has expired or is invalid");
	    }
		
	}
}
