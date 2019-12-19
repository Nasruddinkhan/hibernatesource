package com.mypractice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypractice.dto.EmployeeDTO;
import com.mypractice.service.EmployeeService;
import com.mypractice.service.EmployeeServiceImpl;

public class MainServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4929661958091083353L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageNo=0;
		EmployeeService service=null;
		List<EmployeeDTO> listDTO=null;
		int pageCount=0;
		RequestDispatcher rd=null;
		// read pageNo
		pageNo=Integer.parseInt(req.getParameter("pageNo"));
		//Use Service class
		service=new EmployeeServiceImpl();
		listDTO=service.showReportData(pageNo);
		//get pagesCoumypractice
		pageCount=service.getPageCount();
		//keep data in request attributes
		req.setAttribute("pageCtn",pageCount);
		req.setAttribute("reportData",listDTO);
		//forward the request
		rd=req.getRequestDispatcher("/report.jsp");
		rd.forward(req,res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}
}
