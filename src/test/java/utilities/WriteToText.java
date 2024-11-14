package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;

public class WriteToText {


    public static void writeToMethod(String T, String filepath) {
        try {

            FileWriter fileWriter = new FileWriter(filepath, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(T);
            writer.newLine();

            writer.close();

        } catch (Exception e) {
            System.out.println("failed to print");
        }
    }


    public static void writeToCollection(Set<String> T, String filepath) {
        try {
            FileWriter fileWriter = new FileWriter(filepath, true);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (String element : T) {
                writer.append(element).append(System.lineSeparator());

            }


            writer.close();

        } catch (Exception e) {
            System.out.println("failed to print");

        }

    }
}
