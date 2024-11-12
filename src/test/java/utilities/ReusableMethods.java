package utilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {


    public static Path screen(String name){

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        return Paths.get("target/screenshots", name+" "+date + ".png");
    }
}
