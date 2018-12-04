package WakeUp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.opencsv.*;


/**
 * Class used to read and write from a CSV file.
 *
 * Based on the opencsv implementation of CSV reader & writers.
 *
 * CSV file path based on class constructor argument.
 *
 *  See the docs at http://opencsv.sourceforge.net/apidocs/index.html
 *  Available material: https://www.baeldung.com/opencsv
 *
 * todo: implement Beans for object storage and retrieval.
 * todo: make DRY the IOException handling by testing CSV in constructor.
 */
public class CSVDB {
    private Path CSV_FILE_PATH =  Paths.get("csvFile.csv"); // default setting

    // Constructor default with no path.
    CSVDB() {}

    // Constructor with path.
    CSVDB(String pathString) {
        this.CSV_FILE_PATH = Paths.get(pathString);
    }

    /**
     * Writing a single line to a CSV file.
     *
     * @param array                     a String[] of data values to write to a CSV file
     */
    public void writeCSVLine(String[] array) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH.toString()));
            writer.writeNext(array);
            writer.close();
        }
        catch (IOException e) {
            System.out.println("This is an error. The path does not contain a valid CSV file.");
            System.out.println(e);
        }
    }

    /**
     * Writing multiple lines to a CSV file.
     *
     * @param stringArray               an List of arrays to write to CSV file
     */
    public void writeCSVMultiLine(List<String[]> stringArray) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH.toString()));
            for (String[] array : stringArray) {
                writer.writeNext(array);
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("This is an error. The path does not contain a valid CSV file.");
            System.out.println(e);
        }
    }

    /**
     * Reading a full CSV file.
     *
     * Preferred method for reading a full CSV file of entries.
     *
     * @returns fullRecord              an ArrayList of all the lines in the CSV file
     */
    public List<String[]> readCSVFull() {
        List<String[]> fullRecord = new ArrayList<>();
        String[] nextRecord;

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH.toString()));

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();

            while ((nextRecord = csvReader.readNext()) != null) {
                debugCheck(nextRecord);
                fullRecord.add(nextRecord);
            }
            reader.close(); // Close reader to prevent memory leaks.

        } catch (IOException e) {
            System.out.println("This is an error. The path does not contain a valid CSV file.");
            System.out.println(e);
            return fullRecord;
        }

        return fullRecord;
    }


    /**
     * Helper method to print array for checking items.
     *
     * @param nextRecord
     */
    private void debugCheck(String[] nextRecord) {
        System.out.println("Name : " + nextRecord[0]);
        System.out.println("Email : " + nextRecord[1]);
        System.out.println("Phone : " + nextRecord[2]);
        System.out.println("Country : " + nextRecord[3]);
        System.out.println("==========================");
    }


    /**
     * Read data from a CSV file Method #2
     *
     * todo: Specify sepperator etc.
     *
     * @param
     * @throws IOException
     */
    public void readData2() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH.toString()));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name : " + nextRecord[0]);
                System.out.println("Email : " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                System.out.println("Country : " + nextRecord[3]);
                System.out.println("==========================");
            }
        }
    }
}

