import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Wordmatch {
    public void analizingFile() throws IOException {
        String[] words = readBuffer("words.txt").split(" ");
        HashMap<String, Integer> wordAndCount = new HashMap<>();
        for(String word: words) {
            if(wordAndCount.containsKey(word)) {
                wordAndCount.put(word, wordAndCount.get(word) + 1);
            } else {
                wordAndCount.put(word, 1);
            }
        }
        TreeMap<ObjectMap, String> sortingCount = new TreeMap<>(comparator);
        for (HashMap.Entry<String, Integer> entry : wordAndCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            ObjectMap objectMap = new ObjectMap(value, key);
            sortingCount.put(objectMap, key);
        }
        Iterator<Map.Entry<ObjectMap, String>> itr = sortingCount.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<ObjectMap, String> entry =  itr.next();
            ObjectMap obj = entry.getKey();
            String value = entry.getValue();
            System.out.println(value + " " + obj.toString());
        }
    }

    private static String readBuffer(String fileName) throws IOException {
        String userDirectory = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader( new FileReader (userDirectory +"/src/main/resources/" + fileName));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = reader.readLine()) != null ) {
            stringBuilder.append(line);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    Comparator<ObjectMap> comparator = new Comparator<ObjectMap>() {

        @Override
        public int compare(ObjectMap obj1, ObjectMap obj2) {
            return obj2.getCommonValue().compareTo(obj1.getCommonValue());
        }
    };

    private static class ObjectMap {
        Integer value;
        String key;

        @Override
        public String toString() {
            return value.toString();
        }

        public ObjectMap(Integer value, String key) {
            this.value = value;
            this.key = key;
        }

        public String getCommonValue() {
            return value + key;
        }
    }

}

