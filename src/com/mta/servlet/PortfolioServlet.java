package com.mta.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.model.Portfolio;
import com.mta.model.StockStatus;
import com.mta.service.PortfolioService;
import com.mta.exception.BalanceException;
import com.mta.exception.NotEnoughStocksToSellException;
import com.mta.exception.PortfolioFullException;
import com.mta.exception.StockAlreadyExistsException;
import com.mta.exception.StockNotExistException;

/**
 * PortfolioServlet print to screen portfolio data
 * @author Shiran Davidi
 * date December 2014
 */
public class PortfolioServlet  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/html");

		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio;

		try
		{
			portfolio = portfolioService.getPortfolio();
			String portfolioStr= portfolio.getHtmlString();
			resp.getWriter().println(portfolioStr);

		}
		catch (Exception e)
		{
			resp.getWriter().println(e.getMessage());
		}				
	}
}