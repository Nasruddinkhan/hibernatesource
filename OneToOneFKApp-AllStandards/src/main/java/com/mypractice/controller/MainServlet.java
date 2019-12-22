package com.mypractice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypractice.dto.LicenseDTO;
import com.mypractice.dto.PersonDTO;
import com.mypractice.service.OToOService;
import com.mypractice.service.OToOServiceFactory;

public class MainServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String paramVal=null;
		List<LicenseDTO> listLicDTO=null;
		List<PersonDTO> listPersonDTO=null;
		OToOService service=null;
		RequestDispatcher rd=null;
		int pid=0;
		String type=null;
		String licenseGeneratedMSg=null;
		HttpSession ses=null;
		//get session
		ses=req.getSession();
		//create Service class obj
		service=OToOServiceFactory.getInstance();
		//read param req param value
		paramVal=req.getParameter("param");
		if(paramVal.equalsIgnoreCase("link1")){
		  listLicDTO=service.getPersonsWithLicense();
		  listPersonDTO=service.getPersonsWithOutLicense();
          //keep resuls in request Scope
		  req.setAttribute("listLicDTO",listLicDTO);
		  req.setAttribute("listPersonDTO",listPersonDTO);
		  //forward request to view_report.jsp
		  rd=req.getRequestDispatcher("/view_report.jsp");
		  rd.forward(req,res);
		}//if
		else if(paramVal.equalsIgnoreCase("link2")){
			//read person from hyperlink
			pid=Integer.parseInt(req.getParameter("pid"));
			//add request pid request scope
			req.setAttribute("pid",pid);
			//forward to add_license.jsp
			rd=req.getRequestDispatcher("/add_license.jsp");
			rd.forward(req,res);
		}//else
		else if(paramVal.equalsIgnoreCase("addLicense")){
			
			// read from data
			pid=Integer.parseInt(req.getParameter("pid"));
			type=req.getParameter("type");
			//use servuce
			licenseGeneratedMSg=service.addLicenseToPerson(pid, type);
			//keep msg in requestScope
			req.setAttribute("licenseMsg",licenseGeneratedMSg);
			 listLicDTO=service.getPersonsWithLicense();
			  listPersonDTO=service.getPersonsWithOutLicense();
	          //keep resuls in request Scope
			  req.setAttribute("listLicDTO",listLicDTO);
			  req.setAttribute("listPersonDTO",listPersonDTO);
			//forward request to view_report.jsp
			rd=req.getRequestDispatcher("/view_report.jsp");
			rd.forward(req,res);
			
		}
		
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
