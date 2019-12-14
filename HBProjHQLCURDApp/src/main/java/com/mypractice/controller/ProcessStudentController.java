package com.mypractice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mypractice.dto.StudentDTO;
import com.mypractice.service.StudentService;
import com.mypractice.service.StudentServiceImpl;

public class ProcessStudentController extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param = null;
		StudentService service = null;
		List<StudentDTO> listDTO = null;
		RequestDispatcher rd = null;
		StudentDTO dto = null;
		int no = 0;
		String name = null, addrs = null;
		String edit_result = null;
		// create Service class obj
		service = new StudentServiceImpl();
		// read addtional request param value
		param = req.getParameter("param");
		if (param.equals("link1")) {
			// use Service class
			listDTO = service.retrieveAllStudents();

			req.setAttribute("listStuds", listDTO);
			// foward request to show_result.jsp
			rd = req.getRequestDispatcher("/show_result.jsp");
			rd.forward(req, res);
		} // if
		else if (param.equals("link2")) { // for edit link
			// use Service
			dto = service.getStudentDetails(Integer.parseInt(req.getParameter("no")));
			req.setAttribute("studDetails", dto);
			rd = req.getRequestDispatcher("/edit_student.jsp");
			rd.forward(req, res);
		} else if (param.equals("edit")) { // edit submit button
			// read form data
			no = Integer.parseInt(req.getParameter("sno"));
			name = req.getParameter("sname");
			addrs = req.getParameter("address");
			// create DTO
			dto = new StudentDTO();
			dto.setSno(no);
			dto.setSname(name);
			dto.setAddress(addrs);
			// use service class
			edit_result = service.updateStudntDetails(dto);
			req.setAttribute("edit_msg", edit_result);
			rd = req.getRequestDispatcher("/edit_student.jsp");
			rd.forward(req, res);
		}

	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class
