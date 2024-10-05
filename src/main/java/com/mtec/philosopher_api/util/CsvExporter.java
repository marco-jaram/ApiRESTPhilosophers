package com.mtec.philosopher_api.util;

import com.mtec.philosopher_api.model.Philosopher;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Component
public class CsvExporter {

    public void exportPhilosophers(Writer writer, List<Philosopher> philosophers) throws IOException {
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("ID", "Name", "Country", "Philosophical Current"))) {
            for (Philosopher philosopher : philosophers) {
                csvPrinter.printRecord(philosopher.getId(), philosopher.getName(),
                        philosopher.getCountry(), philosopher.getPhilosophicalCurrent());
            }
        }
    }
}
