package dummies;

import java.time.DayOfWeek;

public class Daysofweek {
	
	public static void main(String[] args) {
		
		 DayOfWeek[] dow = DayOfWeek.values();
		 for(int i=0;i<dow.length;i++){
			 System.out.println(dow[i]);
		 }
	}

}
