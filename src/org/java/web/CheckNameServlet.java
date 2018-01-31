package org.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.service.UserService;
import org.java.service.impl.UserServiceImpl;

@SuppressWarnings("serial")

@WebServlet("/checkName")

public class CheckNameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
					PrintWriter  out =resp.getWriter();
					//1.获取传递过来的用户名
					String username =req.getParameter("username");
					//判断
					UserService userService =new UserServiceImpl();		//创建业务逻辑层对象
					boolean flag =userService.getName(username);
					
					out.write(flag+ "");
					
					out.close();
	}
	

}
