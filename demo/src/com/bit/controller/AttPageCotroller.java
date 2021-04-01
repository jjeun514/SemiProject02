package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.StuInfoDao;

@WebServlet("/stuMgmt/stuAtt.bit")
public class AttPageCotroller extends HttpServlet {

	private HttpSession session;
	
	public AttPageCotroller() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * 출결입력 : 행정, 강사
		 */		
		
		System.out.println("----------stuAttController-----------");

		int deptNo = 0;
		session=req.getSession();
		try {
			deptNo=(int) session.getAttribute("deptno");
			System.out.println("[NewLecController] deptNo: "+deptNo);
		} catch(NullPointerException e) {
			System.out.println("[NewLecController] 로그인없이 GET방식 접근");
		}
		
		if( deptNo==0 ) {
			System.out.println("[NewLecController] 로그인 안됨(deptNo: 0)");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
			out.flush();
		} else {
			
			if( deptNo==1 ) {
				System.out.println("[NewLecController] 영업 계정임");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('권한이 없습니다.\\n행정에 문의하세요.'); location.href='javascript:history.back()';</script>");
				out.flush();
				
			} else if( deptNo==2 || deptNo==3 ) {
				// 수강생목록 화면에서 강의 선택을 위한 강의 정보 추출
				StuInfoDao dao = new StuInfoDao();
				req.setAttribute("lecInfoList", dao.lecInfoList());
				
				RequestDispatcher rd = req.getRequestDispatcher("./stuAtt.jsp");
				rd.forward(req, resp);
				
			} else {
				System.out.println("[NewLecController] 로그인 안됨(deptNo: 0)");
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('로그인을 해주세요.'); location.href='/demo/';</script>");
				out.flush();
			}
		}
	}
	
}
