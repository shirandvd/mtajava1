package com.mta;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Javaproj1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>Hello, MY world</h1>");
		//--------------------------exercise 2------------------------
		/*
		int num1=4;
		int num2=3;
		int num3=7;
		int result=(num1+num2)*num3;
		String resultStr = new String("<h1>Result of"+"("+num1+"+"+num2+")"+"*"+num3+"="+result+"</h1>");
		resp.getWriter().println(resultStr);
		*/
		//--------------------------exercise 3------------------------
		double Radios=50;
		double AreaOfCircle = Math.PI *Math.pow(Radios, 2);
		String line1 = new String ("Calculation 1: Area of circle with radius: " +Radios+ " is: "+AreaOfCircle+" square-cm");
		
		double B=30;
		double hypotenuse_length=50;
		double opposite_length = Math.sin(Math.toRadians(B))*hypotenuse_length;
		String line2 = new String ("Calculation 2: Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: "+opposite_length+" cm");

		double ResultOfPow = Math.pow(20, 13);
		String line3 = new String ("Calculation 3: Power of 20 with exp of 13 is: "+ResultOfPow);
		
		String resultStr = line1 +"<br>" +line2 +"<br>"+line3;
		resp.getWriter().println(resultStr);

	}
}
