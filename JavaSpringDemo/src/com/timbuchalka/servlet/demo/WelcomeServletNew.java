package com.timbuchalka.servlet.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timbuchalka.service.demo.WelcomeService;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServletNew")
public class WelcomeServletNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServletNew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Create the data (model) and add to request object.
		// Invoking business layer
		
		WelcomeService welcomeService = new WelcomeService();
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Arnas Smicius");
		request.setAttribute("myWelcomeMessage", welcomeMessage);
		
		// 2. Retrieve request dispatcher
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcomeNew.jsp");
		
		// 3. Forward request to the view
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
