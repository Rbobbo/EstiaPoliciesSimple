package it.estia.controller.utils;

import java.util.ArrayList;

public class UtilController
{
	public static final String CONFIRM_MESSAGE_ATTRIBUTE = "confirmMessageAttribute";
	public static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessageAttribute";
	
	/**
	 * From an error's list, return a string formatted for an html 
	 * pointed list. 
	 * @param errorList
	 * @return
	 */
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
