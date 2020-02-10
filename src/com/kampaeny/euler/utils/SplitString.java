package com.kampaeny.euler.utils;

import java.util.Arrays;

public class SplitString 
{
	public static void split(String oneString)
	{		
		System.out.println(separateString(oneString));
	}
	
	static String separateString(String oneString)
	{
        String[] inStr = oneString.split(" ");

        if (null == inStr || inStr.length == 1) {

                inStr = oneString.split(" ");
                
                if (null == inStr || inStr.length == 1){
                	inStr[0] = oneString;
                }
        }
        
        String tmp = "";
        
        if (null != inStr && inStr.length > 1) {
                for (int j = 0; j < inStr.length; j++) {
                		if(j==0)
                			tmp += "'" + inStr[j].trim() + "'";
                		else
                		{	
                			tmp = tmp.concat(",").concat("'").concat(inStr[j].trim()).concat("'");
                		}
                		//System.out.println(inStr[j]);
                }

        } else if (null != inStr && inStr.length == 1) {

        	System.out.println("Single text :: " + Arrays.asList(inStr));
        }
        
        return tmp;
	}
}
