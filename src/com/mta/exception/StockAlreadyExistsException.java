package com.mta.exception;

/**
 * Stock already exists Exception
 * @author Shiran Davidi
 * January 2015
 */

public class StockAlreadyExistsException extends Exception{
	
	public StockAlreadyExistsException(String symbol)
	{
		super("Stock " +symbol+ " already exists");
	}

}