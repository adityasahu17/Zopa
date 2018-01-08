package com.springboot.zopa.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.springboot.zopa.model.Lender;

public class CSVParser {

	public static List<Lender> parseCSV(String csvFile) {
		CSVReader reader = null;
		List<Lender> lenders = null;
		try {
			lenders = new ArrayList<Lender>();
			reader = new CSVReader(new FileReader(csvFile));
			String[] line;
			int insideWhile = 0;
			while ((line = reader.readNext()) != null) {
				if (insideWhile == 0) {
					insideWhile++;
					continue;
				}
				lenders.add(new Lender(String.valueOf(line[0]), Double.valueOf(line[1]), Integer.valueOf(line[2])));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return lenders;
	}

}