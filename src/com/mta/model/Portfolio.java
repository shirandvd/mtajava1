package com.mta.model;

import java.util.Date;

import com.mta.Stock;

/**
 * class represent Portfolio
 * member int portfolioSize includes stocks array size
 * @author Shiran Davidi
 * @date December 2014
 */

public class Portfolio {
	
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private StockStatus[] stockStatus;
	private int portfolioSize = 0;
	String title;
	
	//constructors
	
	/**
	 *  portfolio constructor
	 */
	
	public Portfolio()
	{
		portfolioSize = 0;
		stocks = new Stock [MAX_PORTFOLIO_SIZE];
		stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}

	  /**
     * copy constructor
     * receives instance and copies it
     * @param portfolio
     */
	
	 public Portfolio(Portfolio portfolio)
     {

             this();
             setTitle(portfolio.getTitle());
             setPortfolioSize(portfolio.getPotfilioSize());         
             for (int i = 0; i < portfolioSize; i++) {
                     stocks[i] = new Stock(portfolio.getStocks()[i]);
             }

             for(int i = 0; i < portfolioSize; i++)
             {
                     stockStatus[i] = new StockStatus(portfolio.getStockStatus()[i]);
             }

     }
	
	//setters
	 public void setStocks(Stock[] stocks1)
     {
             stocks=stocks1;
     }
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

	//getters 
     public int getPotfilioSize()
     {
             return portfolioSize;
     }
     public Stock[] getStocks()
     {
             return stocks;
     }
     public StockStatus[] getStockStatus()
     {
             return stockStatus;
     }
     public String getTitle()
     {
             return title;
     }

     //methods/
     /**
      * addStock method
      * @param stock s
      * insert new stock to stocks array and change portfolioSize
      */
     public void addStock(Stock s)
     {
             if (portfolioSize < MAX_PORTFOLIO_SIZE)
             {
                     stocks[portfolioSize] = s;
                     stockStatus[portfolioSize] = new StockStatus();
                     portfolioSize++;
             }
     }

     /**
      * a method that removes the first stock of the portfolio
      * @param stocks
      */
     public void removeFirstStock(Stock[] stocks)
     {
             this.portfolioSize--;
             for(int i = 0; i < this.portfolioSize; i++)
                     this.stocks[i] = this.stocks[i+1];
     }

     /**
      * method
      * @returns  HTML string description in bold font and break between lines
      * @date December 2014
      */
     public String getHtmlString()
     {

             String stockStr = "<h1>" + getTitle() + "</h1>" + "<br/>";

             for (int i = 0; i < portfolioSize;i++ )
             {
                     stockStr += stocks[i].getHtmlDescription()+"<br>";

             }

             return stockStr;
     }
	
     //inner class stockStatus
     /**
      * inner class in Portfolio an instance represent StockStatus
      * @author dorin
      * @date December 2014
      */
     public class StockStatus {
             private final static int DO_NOTHING = 0;
             private final static int BUY = 1;
             private final static int SELL = 2;     

             private String symbol;
             private float currentBid,currentAsk;
             private Date date;
             private int recommendation;
             private int stockQuantity;

             /**
              * stockStatus constructor
              */
             public StockStatus() {}

             /**
              * copy constructor
              * receives StockStatus and copies it
              * @param stockstatus
              */
             public StockStatus(StockStatus stockstatus)
             {
                     this();
                     setSymbol(stockstatus.getSymbol());
                     setCurrentAsk(stockstatus.getCurrentAsk());
                     setCurrentBid(stockstatus.getCurrentBid());
                     setDate(stockstatus.getDate());
                     setRecommendation(stockstatus.getRecommendation());
                     setStockQuantity(stockstatus.getStockQuantity());
             }

             //getters
             public String getSymbol()
             {
                     return symbol;
             }
             public float getCurrentBid()
             {
                     return currentBid;
             }
             public float getCurrentAsk()
             {
                     return currentAsk;
             }
             public Date getDate()
             {
                     return date;
             }
             public int getRecommendation()
             {
                     return recommendation;
             }
             public int getStockQuantity()
             {
                     return stockQuantity;
             }
             //setters
             public void setSymbol(String symbol)
             {
                     this.symbol=symbol;
             }

             public void setCurrentBid(float currentBid)
             {
                     this.currentBid=currentBid;
             }
             public void setCurrentAsk(float currentAsk)
             {
                     this.currentAsk=currentAsk;
             }
             public void setDate(Date date)
             {
                     this.date=date;
             }
             public void setRecommendation(int recommendation)
             {
                     this.recommendation=recommendation;
             }
             public void setStockQuantity(int stockQuantity)
             {
                     this.stockQuantity=stockQuantity;
             }
     }

}