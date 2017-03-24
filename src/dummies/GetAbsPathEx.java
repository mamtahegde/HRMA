package dummies;

import java.io.File;

public class GetAbsPathEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String csvPath="\\csv\\empData.csv";
		File f=new File(".",csvPath);
		System.out.println(f.getAbsolutePath());
	}
}
