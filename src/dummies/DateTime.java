package dummies;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sDate=new SimpleDateFormat("MMM YYYY");
		String d = sDate.format(new Date());
		System.out.println(d);
	}

}
