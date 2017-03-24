package dummies;

import java.util.ArrayList;
import java.util.Random;

import org.testng.annotations.Test;

public class ArrayListSize {
	
	@Test
	public void testArrayList(){
		ArrayList<String> al=new ArrayList<String>();
		Random r=new Random();
		int e = r.nextInt(al.size());
		System.out.println(e);
	}

}
