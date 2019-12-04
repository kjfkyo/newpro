package com.gy.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	
	public static String dateToString(Date date){
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static Date stringToDate(String date){
		Date d=null;
		try {
			d = new SimpleDateFormat().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static boolean isNumber(String str){
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch<48 || ch>57){
				return false;
			}
		}
		return true;
	}
	
	public static String isEmpty(String str){
		char[] ch=str.toCharArray();
		String s="";
		for(int i=0;i<ch.length;i++){
			if(ch[i]!=' '){
				s+=ch[i];
			}
		}
		return s;
	}
	public static boolean isNotNull(String s){
		if(s!="" && s!=null){
			return true;
		}
		return false;
	}
}
