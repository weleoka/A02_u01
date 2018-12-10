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
 * todo: update a CSV line.
 * todo: implement Beans for object storage and retrieval.
 * todo: make DRY the IOException handling by testing CSV in constructor.
 */
public class CSVDB
{
    private Path CSV_FILE_PATH =  Paths.get("csvFile.csv"); // default setting

    // Constructor default with no path.
    CSVDB() {}

    // Constructor with path.
    CSVDB(String pathString)
    {
        this.CSV_FILE_PATH = Paths.get(pathString);
    }

    /**
     * Writing a single line to a CSV file.
     *
     * @param array                     a String[] of data values to write to a CSV file
     */
    public void writeCSVLine(String[] array)
    {

        try {
            FileWriter mFileWriter = new FileWriter(CSV_FILE_PATH.toString(), true);
            CSVWriter writer = new CSVWriter(mFileWriter);
            writer.writeNext(array);
            writer.close();

        }

        catch (IOException e)
        {
            System.out.println("This is an error. The path does not contain a valid CSV file.");
            System.out.println(e);
        }
    }

    /**
     * Writing multiple lines to a CSV file.
     *
     * @param stringArray               an List of arrays to write to CSV file
     */
    public void writeCSVMultiLine(List<String[]> stringArray)
    {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH.toString()));

            for (String[] array : stringArray)
            {
                writer.writeNext(array);
            }
            writer.close();

        }

        catch (IOException e)
        {
            System.out.println("This is an error. The path does not contain a valid CSV file.");
            System.out.println(e);
        }
    }

    /**
     * Reading a full CSV file.
     *
     * Preferred method for reading a full CSV file of entries.
     * todo: possibly count number of lines in CSV file for prebuilding array.
     * todo: java.nio.file.NoSuchFileException: ./userDB.csv catch it.
     *
     * @returns fullRecord              an ArrayList of all the lines in the CSV file
     */
    public List<String[]> readCSVFull()
    {
        List<String[]> fullRecord = new ArrayList<>();
        String[] nextRecord;

        try
        {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH.toString()));

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();

            while ((nextRecord = csvReader.readNext()) != null)
            {
                //debugCheck(nextRecord);
                fullRecord.add(nextRecord);
            }
            reader.close(); // Close reader to prevent memory leaks.

        }
        catch (IOException e)
        {
            //System.out.println("This is an error. The path does not contain a valid CSV file.");
            //System.out.println(e);

            return fullRecord;
        }

        return fullRecord;
    }


    /**
     * Helper method to print array for checking items.
     *
     * @param nextRecord
     */
    private void debugCheck(String[] nextRecord)
    {

        for ( String part : nextRecord)
        {

            try
            {
                System.out.println(part);

            }

            catch (ArrayIndexOutOfBoundsException e)
            {

                return;
            }
        }
        System.out.println("==========================");

        /*System.out.println("Namn : " + nextRecord[0]);
        System.out.println("userID : " + nextRecord[1]);
        System.out.println("Status : " + nextRecord[2]);
        System.out.println("==========================");*/
    }
}

