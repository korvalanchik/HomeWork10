import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ValidationPhoneNumber {
    public void readAndValidateTel(String fileName) throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader( new FileReader(userDirectory +"/src/main/resources/" + fileName));
        String line;
        String[] mask1;
        String[] mask2;
        while((line = reader.readLine()) != null ) {
            mask1 = line.split("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d");
            mask2 = line.split("\\(\\d\\d\\d\\) \\d\\d\\d-\\d\\d\\d\\d");
            if(mask1.length == 0 || mask2.length == 0) {
                System.out.println(line);
            }
        }
    }
}
