package com.mta.service;

import com.mta.model.Portfolio;
import com.mta.model.Stock;
import com.mta.exception.BalanceException;
import com.mta.exception.NotEnoughStocksToSellException;
import com.mta.exception.PortfolioFullException;
import com.mta.exception.StockAlreadyExistsException;
import com.mta.exception.StockNotExistException;

import java.util.Date;
import java.util.Calendar;

/**
 * @author Shiran Davidi
 * includes data of  stocks using portfolio class
 * date December 2014
 */
public class PortfolioService {
	

	/**
	 * Create new portfolio and add new stocks
	 * @return
	 * @throws PortfolioFullException 
	 * @throws StockAlreadyExistsException 
	 * @throws BalanceException 
	 * @throws StockNotExistException 
	 * @throws NotEnoughStocksToSellException 
	 */

	public Portfolio getPortfolio() throws Exception
	{
		Portfolio myPortfolio= new Portfolio();
		myPortfolio.setTitle("<b>Exercise 09 - Portfolio</b>");
		myPortfolio.updateBalance(10000);
		
	
		Calendar c = Calendar.getInstance();
		c.set(2014, 12, 15, 0, 0, 0);
		Date newDate = c.getTime();

		Stock s1 = new Stock("PIH", 10f, 8.5f, newDate);
		Stock s2 = new Stock("AAL", 30f, 25.5f, newDate);
		Stock s3 = new Stock("CAAS", 20f, 15.5f, newDate);

		myPortfolio.addStock(s1);
		myPortfolio.addStock(s2);
		myPortfolio.addStock(s3);
		myPortfolio.addStock(s3);
		
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 40);
		
		myPortfolio.sellStock("AAL", -1);	
		myPortfolio.removeStock("CAAS");
		
		return myPortfolio;

	}
}