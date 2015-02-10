package com.mta.model;
 
import java.util.List;

import com.mta.exception.BalanceException;
import com.mta.exception.IllegalQuantityException;
import com.mta.exception.PortfolioFullException;
import com.mta.exception.StockAlreadyExistsException;
import com.mta.exception.StockNotExistsException;

/**
 * class represent Portfolio
 * @author Shiran Davidi
 * @date December 2014
 */

public class Portfolio {

	public static final int SIZE=5;
	public enum ALGO_RECOMMENDATION {DO_NOTHING,BUY,SELL};
	private int portfolioSize;
	private String title;
	private float balance;
	private StockStatus[] stockStatus;


	//constructors 
	/**
	 *  portfolio constructor
	 */
	public Portfolio()
	{
		balance=0;
		portfolioSize=0;
		this.setTitle("portfolio");
		stockStatus=new StockStatus[SIZE];
		
	}


	/**
	 * copy constructor Portfolio
	 * @param portfolio
	 */
	public Portfolio(Portfolio portfolio)
	{

		this();
		setTitle(portfolio.getTitle());
		setPortfolioSize(portfolio.getPotfilioSize());		


		for(int i = 0; i < portfolioSize; i++)
		{
			stockStatus[i] = new StockStatus(portfolio.getStockStatus()[i]);
		}

	}

	/**
	 * constructor that sets a list to array
	 * @param stockStatuses
	 */
	public Portfolio (List<StockStatus> stockStatuses)
	{
		this();
	
		for (int i=0;i<stockStatus.length;i++)
		{
			this.stockStatus[i]=stockStatuses.get(i);
		}
	}
	//setters

	public void setPortfolioSize(int portfolioSize)
	{
		this.portfolioSize=portfolioSize;
	}
	public void setTitle(String title1)
	{
		title=title1;
	}
	public void setStockStatus(StockStatus[] stockStatus1)
	{
		stockStatus=stockStatus1;
	}
	public void setBalance(float balance)
	{
		this.balance=balance;
	}

	//getters 
	public int getPotfilioSize()
	{
		return portfolioSize;
	}

	public StockStatus[] getStockStatus()
	{
		return stockStatus;
	}
	public String getTitle()
	{
		return title;
	}

	public float getBalance()
	{
		return balance;
	}

	//methods/
	/**
	 * addStock method
	 * @param stock s 
	 * insert new stock to stocks array and change portfolioSize 
	 */
	public void addStock(Stock s) throws StockAlreadyExistsException, PortfolioFullException
	{
		for (int i=0; i<portfolioSize; i++)
		{
			if (this.stockStatus[i].getSymbol().equals(s.getSymbol()))
					{
						throw new StockAlreadyExistsException(s.getSymbol());
					}
		}
		if (portfolioSize < stockStatus.length)
		{
			
			stockStatus[portfolioSize] = new StockStatus(s);
			portfolioSize++;
		}
		else 
			throw new PortfolioFullException();
	}
	

	/**
	 * update the balance after sell/buy
	 * @param amount
	 */

	public void updateBalance(float amount)
	{
		balance+=amount;
	}

	/**
	 * removes stock from portfolio array
	 * @param symbol
	 */
	public void removeStock(String symbol) throws StockNotExistsException,IllegalQuantityException{
		sellStock(symbol,-1);
		for (int i=0;i<stockStatus.length;i++)
		{
			if (symbol.equals(stockStatus[i].getSymbol()))
			{
				stockStatus[i]=stockStatus[portfolioSize-1];
				stockStatus[portfolioSize-1]=null;
				portfolioSize--;
				
			}
			else 
				throw new StockNotExistsException(symbol);

		}
		
	}
	
	
	/**
	 * sell stocks and update the balance
	 * @param symbol
	 * @param quantity
	 */
	public void sellStock(String symbol, int quantity ) throws StockNotExistsException, IllegalQuantityException
	{

		for(int i=0; i<stockStatus.length; i++)
			if(symbol.equals(stockStatus[i].getSymbol()))
			{
				if(quantity == -1) {
					float amount1=stockStatus[i].getStockQuantity()*stockStatus[i].getBid();
					updateBalance(amount1);
					stockStatus[i].setStockQuantity(0);
				}
				else if(stockStatus[i].getStockQuantity()-quantity < 0){
						throw new IllegalQuantityException();
				}
				else if (stockStatus[i].getStockQuantity()-quantity >= 0){
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()-quantity);
					float amount = quantity*stockStatus[i].getBid();
					updateBalance(amount);
				}
				else 
					throw new StockNotExistsException(symbol);
				
			}
		
	}

	/**
	 * buy stocks and update the balance
	 * @param symbol
	 * @param quantity
	 */
	public void buyStock(String symbol, int quantity ) throws StockNotExistsException,BalanceException
	{

		for(int i=0; i<stockStatus.length;i++)
			if(symbol.equals(stockStatus[i].getSymbol()))
			{
				if( quantity == -1)
					{
					
					float spent = ((int)(balance/stockStatus[i].getAsk()) *stockStatus[i].getAsk())/(-1); //how much bought
					if (spent/(-1) > balance )
						throw new BalanceException();
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+ (int)(balance/stockStatus[i].getAsk()));
					updateBalance(spent);
				}
				else
				{
					float spent1=(quantity*stockStatus[i].getAsk())/(-1);
					if (spent1/(-1) > balance )
						throw new BalanceException();
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+quantity);
					updateBalance(spent1);
				}
			}
		throw new StockNotExistsException(symbol);	
	}
	/**
	 * method 
	 * @returns  HTML string description in bold font and break between lines 
	 * @date December 2014
	 */
	public String getHtmlString() 
	{
		String stockStr = "<h1>" + getTitle() + "</h1>" + "<br/>";
		
		stockStr+="<b> Total Protfolio Value: </b>"+ getTotalValue()+"$ <b> Total Stocks Value: </b>"+ getStocksValue()+ "$ <b> Balance </b>"+getBalance()+ "$ </br>";
		for (int i = 0; i < portfolioSize;i++ )
		{
			stockStr += stockStatus[i].getHtmlDescription()+"<br>";
		}
		
		return stockStr;
	}

	/**
	 * calculate value of stocks
	 * @return
	 */
	public float getStocksValue()
	{
		float sum=0;
		for (int i=0;i<portfolioSize;i++)
			sum+=stockStatus[i].getStockQuantity() * stockStatus[i].getBid();	
		
		return sum;
	}

	/**
	 * returns total value (balance +stocks value)
	 * @return
	 */
	public float getTotalValue()
	{
		return getBalance()+getStocksValue();
	}
	
	/**
	 * 
	 * @param symbol
	 * @return 
	 * @throws StockNotExistsException
	 */
	
	public StockStatus findBySymbol(String symbol) throws StockNotExistsException
	{
		for (int i=0;i< stockStatus.length;i++)
		{
			if (symbol.equals(stockStatus[i].getSymbol()))
				return stockStatus[i];
		}
		throw new StockNotExistsException(symbol);
	}
	
}
