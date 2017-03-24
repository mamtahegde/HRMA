package dummies;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CommonsCSV {

	public static void main(String[] args) throws Exception {
		Reader r = new FileReader("./csv/empData.csv");
		CSVFormat csvf = CSVFormat.EXCEL.withNullString("").withFirstRecordAsHeader();
		CSVParser csvp = new CSVParser(r, csvf);
		ArrayList<String> str=new ArrayList<String>();
//		List<CSVRecord> a = csvp.getRecords();
//		System.out.println(a.get(0).get(0));
		for (CSVRecord csv : csvp.getRecords()) {
			String values[] = {csv.get(0),csv.get(2)};
			for (String value : values) {
				if (value != null) {
					str.addAll(Arrays.asList(values));
					break;
				}
			}
		}
		csvp.close();
		for (String s : str) {
			System.out.println(s);
		}
	}
}