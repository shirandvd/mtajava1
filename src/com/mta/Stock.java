package com.mta;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Stock extends HttpServlet {
	private String symbol;
	private float Ask;
	private float Bid;
	private Date date;
	
	public String getSymbol()
	{
		return symbol;
	}
	public float getAsk()
	{
		return Ask;
	}
	public float getBid()
	{
		return Bid;
	}
	public Date getDate()
	{
		return date;
	}
	public void setSymbol(String symbol1)
	{
		symbol=symbol1;
	}
	public void setAsk(float ask1)
	{
		Ask=ask1;
	}
	public void setBid(float bid1)
	{
		Bid=bid1;
	}
	public void setdate(Date date1)
	{
		date=date1;
	}
	public String getHtmlDescription()
	{
		String stockHtmlDetailsString = "<b>Stock symbol: </b>"+getSymbol()+"<b> Ask: </b>"+getAsk()+"<b> Bid: </b>"+getBid()+"<b> Date: </b>" +getDate();
		return stockHtmlDetailsString;
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		Stock s1 = new Stock();
		Stock s2 = new Stock();
		Stock s3 = new Stock();
		
		java.util.Date date = new java.util.Date();
		date.setYear(114);
		date.setMonth(10);
		date.setDate(15);
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		
		s1.setSymbol("PIH");
		s1.setAsk(12.4f);
		s1.setBid(13.1f);
		s1.setdate(date);
		
		s2.setSymbol("AAL");
		s2.setAsk(5.5f);
		s2.setBid(5.78f);
		s2.setdate(date);
		
		s3.setSymbol("CAAS");
		s3.setAsk(31.5f);
		s3.setBid(31.2f);
		s3.setdate(date);
		
		String s1Str=s1.getHtmlDescription();
		String s2Str=s2.getHtmlDescription();
		String s3Str=s3.getHtmlDescription();
		
		resp.setContentType("text/html");
		resp.getWriter().println(s1Str+"<br>"+s2Str+"<br>"+s3Str);
	}
}