package com.mta;

import java.util.Date;

/**
 * class represent Stock
 * @author Shiran Davidi
 * @date December 2014
 */
public class Stock {
        private String symbol;
        private float ask;
        private float Bid;
        private Date date;
 
        /**
         * constructor Stock- sets instance stock
         * @param symbol
         * @param ask
         * @param bid
         * @param date
         */
        public Stock(String symbol,float ask,float bid,Date date)
        {
                this.setSymbol(symbol);
                this.setAsk(ask);
                this.setBid(bid);
                this.setDate(date);
        }
 
        /**
         * copy constructor
         * receives instance of Stock and copies it.
         * @param stock
         */
        public Stock(Stock stock)
        {
                setSymbol(stock.getSymbol());
                setAsk(stock.getAsk());
                setBid(stock.getBid());
                setDate(stock.getDate());
        }
        //getters
        public String getSymbol()
        {
                return symbol;
        }
        public float getAsk()
        {
                return ask;
        }
        public float getBid()
        {
                return Bid;
        }
        public Date getDate()
        {
                return date;
        }
        //setters
        public void setSymbol(String symbol1)
        {
                symbol=symbol1;
        }
        public void setAsk(float ask1)
        {
                ask=ask1;
        }
        public void setBid(float bid1)
        {
                Bid=bid1;
        }
        public void setDate(Date date1)
        {
                date=date1;
        }
       
        /**
         * @return HTML string about the Stock in bold font and break between lines
         * @date December 2014
         */
        public String getHtmlDescription()
        {
                String stockHtmlDetailsString = "<b>Stock symbol: </b>"+getSymbol()+"<b> Ask: </b>"+getAsk()+"<b> Bid: </b>"+getBid()+"<b> Date: </b>" +getDate();
                return stockHtmlDetailsString;
        }
}