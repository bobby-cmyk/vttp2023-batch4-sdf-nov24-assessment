package mailmerge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TemplateProcessor {

    private ArrayList<String> lines;

    public TemplateProcessor() {
        lines = new ArrayList<>();
    }

    public void read(String templatePath) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(templatePath);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();

            if (line == null) {
                break;
            }

            lines.add(line);
        }

        br.close();
        fr.close();
    }

    public void printFilled(ArrayList<HashMap<String, String>> csvContent) {

        

        for (HashMap<String, String> recordMap : csvContent) {

            ArrayList<String> temp = lines;

             for (String line : temp) {
               
                for (String variable : recordMap.keySet()) {

                    line = line.replace("__" + variable + "__", recordMap.get(variable));
                    line = line.replace("\\n", "\n");
                }

                System.out.printf("%s\n",line);
             }
        }

    }
    
}
