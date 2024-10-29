package mailmerge;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Proper usage: <CSV_PATH> <TEMPLATE_PATH>");
            System.exit(-1);
        }

        String csvPath = args[0];

        String templatePath = args[1];
        
        CSVProccessor csvProccessor = new CSVProccessor();

        try {
            csvProccessor.read(csvPath);
        }

        catch (FileNotFoundException fe) {
            System.err.printf("CSV file not found: %s\n", fe.getMessage());
        }

        catch (IOException ie) {
            System.err.printf("Error occured reading CSV file: %s\n", ie.getMessage());
        }

        TemplateProcessor templateProcessor = new TemplateProcessor();

        try {
            templateProcessor.read(templatePath);
        }

        catch (FileNotFoundException fe) {
            System.err.printf("Template file not found: %s\n", fe.getMessage());
        }

        catch (IOException ie) {
            System.err.printf("Error occured reading template file: %s\n", ie.getMessage());
        }

        templateProcessor.printFilled(csvProccessor.getCsvContent());
    }
}


// Create a class to read csv files
    // class variables -> variable names ArrayList<String>
    // 