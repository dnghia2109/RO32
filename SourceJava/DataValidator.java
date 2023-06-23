package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ^: Bắt đầu chuỗi String hoặc một dòng
 * [A-Za-z0-9]+: Email begin “[A-Za-z0-9]+” và có ít nhất một ký tự
 * [A-Za-z0-9]*@: tùy chọn theo “[A-Za-z0-9]”, và end =  “@”
 * [A-Za-z0-9]: Domain phải sau @ và ký tự phải nằm trong [A-Za-z0-9]
 * \\.[A-Za-z0-9]:sau dấu chấm
 *	$: Kết thúc chuỗi String hoặc kết thúc dòng
 *	\d: 0-9
 *	1 ký tự tường; 1 hoa, 1 ký tự đặc biệt
 *	https://codelearn.io/sharing/regular-expression-trong-java
 */
public final class DataValidator {
	private static Pattern patternEmail;
	private static Pattern patternPass;
	private static Pattern patternUserName;
	private Matcher matcher;
	private static final String EMAIL_REGEX = 
			"^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+"
			+ "(\\.[A-Za-z0-9]+)$";
	
	 private static final String USER_NAME_REGEX="^[A-Za-z]{6,12}$";
//	private static final String PASS_REGEX =
//			"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";
	private static final String PASS_REGEX =
			"((?=.*[A-Z]).{6,12})";
	public DataValidator() {
		
		patternEmail = Pattern.compile(EMAIL_REGEX);	
		patternPass = Pattern.compile(PASS_REGEX);
		patternUserName = Pattern.compile(USER_NAME_REGEX);
	}
	public final boolean validateEmail(String regex) {
		matcher = patternEmail.matcher(regex);
		return matcher.matches();
	}	
	public final boolean validatePass(String regex) {
		matcher = patternPass.matcher(regex);
		return matcher.matches();
	}
	public final boolean validateUserName(String regex) {
		matcher = patternUserName.matcher(regex);
		return matcher.matches();
	}
}
