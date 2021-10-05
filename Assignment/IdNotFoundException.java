package com.mini.project;

public class IdNotFoundException extends Exception {
	
	@Override
	public String getMessage()
	{
		return "the user for the given roll no";
	}

	
}
