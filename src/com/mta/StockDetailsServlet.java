package com.mta;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StockDetailsServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Stock s1 = new Stock();
		Stock s2 = new Stock();
		Stock s3 = new Stock();
		
		java.util.Date date1 = new java.util.Date();
		date1.setYear(114);
		date1.setMonth(10);
		date1.setDate(15);
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		
		s1.setSymbol("PIH");
		s1.setAsk(12.4f);
		s1.setBid(13.1f);
		s1.setdate(date1);
		
		s2.setSymbol("AAL");
		s2.setAsk(5.5f);
		s2.setBid(5.78f);
		s2.setdate(date1);
		
		s3.setSymbol("CAAS");
		s3.setAsk(31.5f);
		s3.setBid(31.2f);
		s3.setdate(date1);
		
		String s1Str=s1.getHtmlDescription();
		String s2Str=s2.getHtmlDescription();
		String s3Str=s3.getHtmlDescription();
		
		resp.setContentType("text/html");
		resp.getWriter().println(s1Str+"<br>"+s2Str+"<br>"+s3Str);
	}

}
