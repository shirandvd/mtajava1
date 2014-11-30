package com.mta.model;

import java.util.Date;

import com.mta.Stock;

public class Portfolio {
	
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private StockStatus[] stocksStatus;
	private int portfolioSize = 0;
	
	public Portfolio()
	{
		stocks = new Stock [MAX_PORTFOLIO_SIZE];
		stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}

	
	public void addStock(Stock s)
	{	
		stocks[portfolioSize] = s;
		portfolioSize++;
	}
	
	public Stock[] getStocks()
	{
		return stocks;
	}
	
	public class StockStatus {
		
		String symbol;
		float currentBid, currentAsk;
		Date date;
		int recommendation;
		int stockQuantity;
		
		private final static int DO_NOTHING = 0;
		private final static int BUY = 1;
		private final static int SELL = 2;
	}
}
