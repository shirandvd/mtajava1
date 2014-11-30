package com.mta.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mta.Stock;
import com.mta.model.Portfolio;
import com.mta.service.PortfolioService;

public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio = portfolioService.getPortfolio();
		Stock[] stocks = portfolio.getStocks();
		
		String s1Str=stocks[0].getHtmlDescription();
		String s2Str=stocks[1].getHtmlDescription();
		String s3Str=stocks[2].getHtmlDescription();
		
		resp.getWriter().println(s1Str+"<br>"+s2Str+"<br>"+s3Str);
	}

}
