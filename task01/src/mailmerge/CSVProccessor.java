package mailmerge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVProccessor {

    private ArrayList<HashMap<String, String>> csvContent;

    public CSVProccessor() {
        csvContent = new ArrayList<>();
    }

    public void read(String csvPath) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(csvPath);
        BufferedReader br = new BufferedReader(fr);

        String[] variables = br.readLine().split(",");

        while (true) {
            String record = br.readLine();

            if (record == null) {
                break;
            }

            // Split each field's info
            String[] info = record.split(",");

            // Initialise the recordMap
            HashMap<String, String> recordMap = new HashMap<>();
            
            // Loop throuhg all the variables and put the variable as key and info as values

            for (int i = 0; i < variables.length; i++) {
                recordMap.put(variables[i], info[i]);
            }

            csvContent.add(recordMap);
        }

        br.close();
        fr.close();
    }

    public void printRecords() {

        for (HashMap<String, String> recordMap : csvContent) {
            for (String variable : recordMap.keySet()) {
                System.out.printf("%s: %s\n", variable, recordMap.get(variable));
            }
            System.out.println("");
        }
    }

    public ArrayList<HashMap<String, String>> getCsvContent() {
        return this.csvContent;
    }


}
