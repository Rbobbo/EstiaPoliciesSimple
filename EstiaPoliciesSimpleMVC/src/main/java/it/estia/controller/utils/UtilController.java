package it.estia.controller.utils;

import java.util.ArrayList;

public class UtilController
{
	
	public static final String formatErrorsTag(ArrayList<String> errorList)
	{
		String errorFormatted = "";
		if( !errorList.isEmpty() )
		{
			errorFormatted = "<ul>";
			for (String errorTemp : errorList)
			{
				errorFormatted += "<li>"+errorTemp+"</li>";
			}
			errorFormatted += "</ul>";
		}
		
		return errorFormatted;
	}
	
	

}
