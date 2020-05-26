/**
 * @author Hector Fierro
 * @version 1.00, 05/25/2020
 *
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DEL = ",";
    private static final String NEW_LINE = "\n";

    //CSV file header
    private static final String FILE_HEADER = "zipcode,rate";

    public static void writeCsvFile(String fileName, ArrayList<ZipCodeValues> zcvArray) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE);

            for (int row=0; row < zcvArray.size(); row++){
                fileWriter.append(zcvArray.get(row).getZipCode());
                fileWriter.append(COMMA_DEL);
                fileWriter.append(zcvArray.get(row).getValue());
                fileWriter.append(NEW_LINE);
            }

            System.out.println("The CSV file was successfully created");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter class");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error when  closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}
