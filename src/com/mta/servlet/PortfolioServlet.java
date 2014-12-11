package com.mta.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.model.Portfolio;
import com.mta.model.Stock;
import com.mta.service.PortfolioService;

/**
 * PortfolioServlet print to screen portfolio data
 * @author Shiran Davidi
 * date December 2014
 */
public class PortfolioServlet  extends HttpServlet {
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
               
                PortfolioService portfolioService = new PortfolioService();
                Portfolio portfolio = portfolioService.getPortfolio();
                Stock[] stocks = portfolio.getStocks();
                portfolio.setTitle("portfolio #1");
               
                //create portfolio # 2 that is a copy of portfolio #1
                Portfolio portfolio2=new Portfolio(portfolio);
                portfolio2.setTitle("portfolio #2");
               
               
                //print portfolios
                resp.setContentType("text/html");
                String portfolioStr=portfolio.getHtmlString();
                resp.getWriter().println(portfolioStr);
                String portfolio2Str=portfolio2.getHtmlString();
                resp.getWriter().println(portfolio2Str);
               
               
                //remove first stock from portfolio1
                portfolio.removeFirstStock(portfolio.getStocks());
               
                //print portfolios after remove
                portfolioStr=portfolio.getHtmlString();
                resp.getWriter().println(portfolioStr);
                resp.getWriter().println(portfolio2Str);
               
               
                //change last stock's bid value of portfolio2 to 55.55
                portfolio2.getStocks()[2].setBid(55.55f);
               
                //print portfolios after change bid
                resp.setContentType("text/html");
                resp.getWriter().println(portfolioStr);
                portfolio2Str=portfolio2.getHtmlString();
                resp.getWriter().println(portfolio2Str);              
        }
 
}