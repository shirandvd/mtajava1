package com.mta.exception;

public class NotEnoughStocksToSellException extends Exception{
	
	public NotEnoughStocksToSellException()
	{
		super("Not enough stocks to sell");
	}

}