package com.mta.exception;

/**
 * Portfolio full Exception
 * @author Shiran Davidi
 * January 2015
 */

public class PortfolioFullException extends Exception{
	
	public PortfolioFullException()
	{
		super("Portfolio is full");
	}

}