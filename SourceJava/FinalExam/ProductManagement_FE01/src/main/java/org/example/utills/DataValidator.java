package org.example.utills;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DataValidator {
	private static Pattern patternEmail;
	private static Pattern patternPass;

	private static final String PASS_REGEX="^[A-Za-z]{6,12}$";
	private Matcher matcher;
	private static final String EMAIL_REGEX = 
			 "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+[.-]"+ "(\\.[A-Za-z0-9]+)$";

	//private static final String regex = "^[^!#$%&'*+/=?^_`{|}~.][A-Za-z0-9]+[A-Za-z0-9]*+@[^!#$%&'*+/=?^_`{|}~][A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*$";
	public DataValidator() {
		patternEmail = Pattern.compile(EMAIL_REGEX);
		patternPass = Pattern.compile(PASS_REGEX);
	}
	
	
	public final boolean validateEmail(String regex) {
	    matcher = patternEmail.matcher(regex);
	    return matcher.matches();
	}
	public final boolean validatePass(String regex) {
		matcher = patternPass.matcher(regex);
		return matcher.matches();
	}

}
