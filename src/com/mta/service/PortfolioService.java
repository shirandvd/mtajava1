package com.mta.service;

import com.mta.model.Portfolio;
import com.mta.model.Stock;

import java.util.Date;

/**
 * @author Shiran Davidi
 * includes data of  stocks using portfolio class
 * date December 2014
 */
public class PortfolioService {
 
       
/**
 * this method create a new portfolio
 * @return
 */
        public Portfolio getPortfolio()
        {
                Portfolio myPortfolio= new Portfolio();
                java.util.Date date1=new java.util.Date();
                date1.setDate(15);
                date1.setMonth(10);
                date1.setYear(114);
                date1.setHours(0);
                date1.setMinutes(0);
                date1.setSeconds(0);
               
                Stock s1=new Stock("PIH",12.4f,13.1f,date1);
                Stock s2=new Stock("AAL",5.5f,5.78f,date1);
                Stock s3=new Stock("CAAS",31.5f,31.2f,date1);
               
                myPortfolio.setTitle("myPortfolio");
                myPortfolio.addStock(s1);
                myPortfolio.addStock(s2);
                myPortfolio.addStock(s3);
               
                return myPortfolio;
        }
}
