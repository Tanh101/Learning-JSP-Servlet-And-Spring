package com.laptrinhjavaweb.constant;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

@WebServlet(urlPatterns = {"/admin-new-list"})
public class NewController extends HttpServlet {
	
	@Inject
	private INewService newService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewModel model = new NewModel();
//		model.setListResult(newService.findAll());
//		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin//new/list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse  response) {
		
	}
}
