import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("Validation phone number");
        ValidationPhoneNumber tel = new ValidationPhoneNumber();
        tel.readAndValidateTel("tel.txt");

        System.out.println("\nJSONinization) object");
        ConvertJSON convertJSON = new ConvertJSON();
        convertJSON.readAndConvertJSON("object.txt");

        System.out.println("\nCounting and sorting words");
        Wordmatch inp = new Wordmatch();
        inp.analizingFile();
    }
}
