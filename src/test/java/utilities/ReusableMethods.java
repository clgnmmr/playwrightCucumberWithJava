package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {


    public static Path screen(String name){

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        return Paths.get("target/screenshots", name+" "+date + ".png");
    }
    public static void fileExist(String filepath){
        try {
            File file = new File(filepath);
            if (file.exists()) {
                new FileWriter(filepath, false).close();
            }
        } catch (IOException e) {
            System.out.println("Not found file");
        }


    }
}
