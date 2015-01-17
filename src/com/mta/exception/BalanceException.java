package com.mta.exception;

/**
 * Negative balance Exception
 * @author Shiran Davidi
 * January 2015
 */

public class BalanceException extends Exception{
	
	public BalanceException()
	{
		super("You don`t have enough money");
	}
}