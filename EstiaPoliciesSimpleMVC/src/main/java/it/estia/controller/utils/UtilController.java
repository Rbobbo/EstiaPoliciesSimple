package it.estia.controller.utils;

import java.util.ArrayList;

public class UtilController
{
	
	public static final String formatErrorsTag(ArrayList<String> errorList)
	{
		String errorFormatted = "";
		if( !errorList.isEmpty() )
		{
			errorFormatted = "";
			for (String errorTemp : errorList) {
				errorFormatted += "->"+errorTemp+"<br>";
			}
		}
		
		return errorFormatted;
	}
	
	

}
