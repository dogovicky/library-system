package com.capricon.web.controller;

import java.io.IOException;
import java.util.List;

import com.capricon.web.dao.DataDAO;
import com.capricon.web.model.Department;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GetDepartments")
public class DepartmentsController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//fetch departments and forward to departments.jsp
		DataDAO dataDao = new DataDAO();
		List<Department> departments = dataDao.getDepartments();
		
		request.setAttribute("departments", departments);
		RequestDispatcher rd = request.getRequestDispatcher("departments.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
