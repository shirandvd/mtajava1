package com.mta.model;

import java.util.Date;

import com.mta.model.Portfolio.ALGO_RECOMMENDATION;


/**
 * Class represent StockStatus inherit from stock
 * @author Shiran Davidi
 * January 2015
 */

public class StockStatus extends Stock{
	
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	
	public StockStatus()
	{
		super();
		setRecommendation(null);
		setStockQuantity(0);
	}
	
	public StockStatus(StockStatus s1)
	{
		super(s1);
		setRecommendation(s1.getRecommendation());
		setStockQuantity(s1.getStockQuantity());
	}
	
	public StockStatus(Stock s)
	{
		super(s);
		setRecommendation(null);
		setStockQuantity(0);
	}
	//getters
	public ALGO_RECOMMENDATION getRecommendation() 
	{
		return recommendation;
	}
	public int getStockQuantity()
	{
		return stockQuantity;
	}
	
	//setters
	public void setRecommendation(ALGO_RECOMMENDATION recommendation)
	{
		this.recommendation=recommendation;
	}
	public void setStockQuantity(int stockQuantity)
	{
		this.stockQuantity=stockQuantity;
	}
}