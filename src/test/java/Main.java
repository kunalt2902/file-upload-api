import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import com.expensemanager.fileupload.constants.Constants;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		
//		try {
//			new SimpleDateFormat(Constants.DATE_FORMAT).parse("12/12/2018");
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		File file = new File("D:\\reactProjects\\Mockup\\expense-manager\\test1.csv");
//		CsvSchema schema = CsvSchema.builder().addColumn("transDate").addColumn("description").addColumn("amount")
//				.build();
//		CsvMapper mapper = new CsvMapper();
//		ObjectReader oReader = mapper.readerFor(CsvData.class).with(schema);
//
//		try (Reader reader = new FileReader(file)) {
//			MappingIterator<CsvData> mi = oReader.readValues(reader);
//			mi.forEachRemaining(record -> System.out.println(record));
////			while (mi.hasNext()) {
////				System.out.println(mi.next());
////			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
