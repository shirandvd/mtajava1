package com.mta.service;

import com.mta.model.Portfolio;
import com.mta.Stock;
import java.util.Date;

public class PortfolioService {
	
	public Portfolio getPortfolio()
	{
		Portfolio myPortfolio = new Portfolio();
		
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
		
		myPortfolio.setTitle("myPortfolio");
		myPortfolio.addStock(s1);
		myPortfolio.addStock(s2);
		myPortfolio.addStock(s3);
		
		return myPortfolio;
	}
}
