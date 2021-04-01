package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.StuScoreDao;

@WebServlet("/stuMgmt/stuScoreDetail.bit")
public class StuScoreDetailController extends HttpServlet {

	private HttpSession session;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int deptno=0;
		session=req.getSession();
		deptno=(int)session.getAttribute("deptno");
		if(deptno==2) {
			System.out.println("권한이 없습니다.");
			RequestDispatcher rd;
			rd=req.getRequestDispatcher("/error/reject.jsp");
			rd.forward(req,resp);
		}else if(deptno==3){
			int stuNo=Integer.parseInt(req.getParameter("stuNo"));
			
			
			StuScoreDao dao=new StuScoreDao();
			req.setAttribute("detailScore", dao.selectOne(stuNo));
			
			
			RequestDispatcher rd;
			rd=req.getRequestDispatcher("/stuMgmt/stuScoreDetail.jsp");
			rd.forward(req,resp);
		}
		
	}
}
