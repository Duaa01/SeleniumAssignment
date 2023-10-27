package csv;
import org.apache.commons.csv.*;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ReadCSV {


    public static List<String> read(String path) {
        SoftAssert softAssert = new SoftAssert();
        List<String> csvFields = null;
        try (Reader reader = new FileReader(path);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('|'));) {

            for (CSVRecord csvRecord : csvParser) {
                csvFields = csvRecord.toList();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvFields;


    }
}


