package com.mta;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Javaproj1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>Hello, MY world</h1>");
		int num1=4;
		int num2=3;
		int num3=7;
		int result=(num1+num2)*num3;
		String resultStr = new String("<h1>Result of"+"("+num1+"+"+num2+")"+"*"+num3+"="+result+"</h1>");
		resp.getWriter().println(resultStr);
				
	}
}
