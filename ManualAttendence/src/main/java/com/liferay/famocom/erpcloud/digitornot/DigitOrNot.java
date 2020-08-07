package com.liferay.famocom.erpcloud.digitornot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitOrNot {
	public static Boolean getSpecialCharacterCount(String s) {
		char[] chars = s.toCharArray();
		int count = 0;
		int com = 0;
		Boolean check = false;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(chars[i])) {
				check = true;
				break;
			} else {
				//System.out.println("cddhh");
				// count = 0;
				break;
			}
		}

		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(s);
		// boolean b = m.matches();
		boolean b = m.find();
		if (b == true){
			check = true;
		}
		return check;
	}

}