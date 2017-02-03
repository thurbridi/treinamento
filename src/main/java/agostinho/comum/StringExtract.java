package agostinho.comum;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExtract {

	public static long firstNumberOf(String text) {
		Pattern pattern = Pattern.compile("(\\d+\\.?)+");
		Matcher matcher = pattern.matcher(text);
		matcher.find();
		String justNumber = matcher.group();

		long result = 0;
		NumberFormat nf = NumberFormat.getInstance();
		try {
			Number number = nf.parse(justNumber);
			result = number.longValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return result;
	}

}
