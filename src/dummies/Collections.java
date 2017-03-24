package dummies;

import java.util.ArrayList;
import java.util.HashSet;

public class Collections {
	
	public static void main(String[] args) {
		ArrayList<String> allText=new ArrayList<String>();
		allText.add("b");
		allText.add("a");
		allText.add("c");

		ArrayList<String> clone=new ArrayList<String>(allText);
		java.util.Collections.sort(clone);
		System.out.println(allText.equals(clone));
		//returns true if both the list has same contents in same order
		//returns false if one of the list has different content or order
		
		//to check whether the listbox has duplicate or not
		//method1
		HashSet<String> clone2=new HashSet<String>(allText);
		System.out.println(allText.size());
		System.out.println(clone2.size());
		
		//method2
		HashSet<String> clone3=new HashSet<String>();
		for(String s:allText){
			boolean v=clone3.add(s);
			System.out.println(v);
		}
		
	}

}
