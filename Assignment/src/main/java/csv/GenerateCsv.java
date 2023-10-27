package csv;
import au.com.anthonybruno.Gen;
import au.com.anthonybruno.generator.defaults.IntGenerator;
import au.com.anthonybruno.settings.CsvSettings;
import com.github.javafaker.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class GenerateCsv {

    Faker faker = new Faker();
    Logger logger = LogManager.getLogger(GenerateCsv.class);
    SoftAssert softAssert = new SoftAssert();

    public void createFileSchema(){
        try {
            logger.info("Generating CSV....");
            Gen.start()

                    .addField("Name", () -> faker.name().firstName())
                    .addField("ID", new IntGenerator(1111, 9999))
                    .addField("URL", () -> "https://www." + faker.internet().domainName())
                    .addField("API Username", () -> faker.name().firstName())
                    .addField("Password", () -> faker.internet().password())
                    .addField("NewField", () -> "")
                    .generate(1)
                    .asCsv(new CsvSettings(false))
                    .toFile("/home/duaasyed/IdeaProjects/Assignment/src/test/resources/converted.csv");

            softAssert.assertTrue(true, " File Generated");
        }catch (Exception e){
            logger.error(" File Generation Failed", e.getMessage());
            softAssert.assertFalse(true);
        }

    }
    public void changeDelimiter(){

        String myFile = "/home/duaasyed/IdeaProjects/Assignment/src/test/resources/converted.csv";
        String updated = "/home/duaasyed/IdeaProjects/Assignment/src/test/resources/converted_update.csv";
        String orgDelim = ",";
        String updDelim = "|";

        try {
            String csvContent = Files.lines(Paths.get(myFile))
                    .map(line -> line.replace(orgDelim, updDelim))
                    .collect(Collectors.joining(updDelim));

            BufferedWriter writer = new BufferedWriter(new FileWriter(updated));
            writer.write(csvContent);
            writer.close();
            softAssert.assertNotEquals(myFile,updated);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





