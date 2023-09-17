import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ConvertJSON {
    public void readAndConvertJSON(String fileName) throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader( new FileReader(userDirectory +"/src/main/resources/" + fileName));
        String line;

        if((line = reader.readLine()) != null) {
            String[] fields;
            LinkedList<CustomObject> objList = new LinkedList<>();
            while((line = reader.readLine()) != null) {
                fields = line.split(" ");
                CustomObject obj = new CustomObject(fields[0], fields[1]);
                objList.offer(obj);
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(objList);

            System.out.println(json);

        } else System.out.println("Missing header");
    }
    private static class CustomObject {
        @SerializedName("name")
        String field1;
        @SerializedName("age")
        String field2;

        public CustomObject(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }
    }

}
