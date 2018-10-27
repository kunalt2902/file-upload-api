package com.expensemanager.fileupload.helper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.expensemanager.fileupload.constants.Constants;
import com.expensemanager.fileupload.models.ExpenseReport;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ExpenseReportParser {
	
	static Logger log = LoggerFactory.getLogger(ExpenseReportParser.class);
	
	public static List<ExpenseReport> getExpenseReportFromFile(MultipartFile file, String reportID) throws FileUploadException{
		CsvSchema schema = CsvSchema.builder().addColumn(Constants.TRANSACTION_DATE).
				addColumn(Constants.DESCRIPTION).
				addColumn(Constants.AMOUNT)
				.build();
		CsvMapper mapper = new CsvMapper();
		ObjectReader oReader = mapper.readerFor(ExpenseReport.class).with(schema);
		List<ExpenseReport> report = new ArrayList<ExpenseReport>();
		try (Reader reader = new InputStreamReader(file.getInputStream())) {
			MappingIterator<ExpenseReport> mi = oReader.readValues(reader);
			int count = 1;
			log.info("Reading expense report");
			while (mi.hasNext()) {
				ExpenseReport record = mi.next();
				if(count > 1) {					
					Validator.validateRecord(record,count);
					record.setRecordID(ObjectId.get());
					record.setReportID(reportID);
					report.add(record);
				}
				count ++;
			}
		} catch (IOException e) {
			throw new FileUploadException(e);
		}
		return report;
	}
}


