package com.mta.exception;

/**
 * Stock not exists Exception
 * @author Shiran Davidi
 * January 2015
 */

public class StockNotExistException extends Exception{
	
	public StockNotExistException(String symbol)
	{
		super("Stock " +symbol+ " not exists");
	}

}