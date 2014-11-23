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
}