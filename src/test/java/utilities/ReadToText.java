package utilities;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadToText {

    public static String readText(String dataFile) {
        String id = "";

        try {
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();

            while (line != null) {
                id = line.split(",")[0];
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("unreadable");
        }
        return id;
    }
}