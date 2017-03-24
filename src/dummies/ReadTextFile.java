package dummies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadTextFile {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("E:/practbitnami/HRMA/csv/empData.csv"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			@SuppressWarnings("unused")
			ArrayList<String> str = new ArrayList<String>();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			// String[] e=everything.split(",");
			// for(int i=0;i<e.length;i++){
			// if(e[i]!=null)
			// str.add(e[i]);
			// System.out.println(str.get(i));
			// }
			StringTokenizer st = new StringTokenizer(everything, ",");
			while (st.hasMoreTokens()) {
				System.out.print(st.nextToken());
			}

			br.close();
		} catch (Exception E) {
		}
	}
}
