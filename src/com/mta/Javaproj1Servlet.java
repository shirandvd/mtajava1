package com.mta;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Javaproj1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>Hello, MY world !!!</h1>");
	}
}
