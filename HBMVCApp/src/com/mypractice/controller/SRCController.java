package com.mypractice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypractice.dto.StudentDTO;
import com.mypractice.service.SRCService;
import com.mypractice.vo.StudentVO;

public class SRCController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8539791350077517237L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String no=null;
		String name=null;
		String m1=null,m2=null,m3=null;
		StudentVO vo=null;
		StudentDTO dto=null;
		SRCService service=null;
		String result=null;
		RequestDispatcher rd=null;
		//read form data
		no=req.getParameter("sno");
		name=req.getParameter("sname");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		//prepare StudemypracticeVO
		vo=new StudentVO();
		vo.setSno(no);
		vo.setSname(name);
		vo.setM1(m1); vo.setM2(m2); vo.setM3(m3);
		//prepare StudemypracticeDTO
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname().trim());
		dto.setM1(Math.round(Float.parseFloat(vo.getM1())));
		dto.setM2(Math.round(Float.parseFloat(vo.getM2())));
		dto.setM3(Math.round(Float.parseFloat(vo.getM3())));
		//use Service class
		service=new SRCService();
		result=service.generateResult(dto);
		//keep reuslt in the request attribute
		req.setAttribute("resultMsg",result);
		//forward request to result.jsp
		rd=req.getRequestDispatcher("/result.jsp");
		if(rd!=null)
			rd.forward(req,res);
				
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,res);
	}

}
