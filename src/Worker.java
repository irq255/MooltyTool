import javax.naming.SizeLimitExceededException;
import java.io.File;
import java.io.IOException;

public class Worker {

    public static void main(String[] args) {
        B64Converter converter = new B64Converter();
        File inputFile = new File("c:\\jdistr\\eek\\Silverlight_x64.exe");
        File encodedFile = new File("c:\\Users\\KLivenskiy\\Desktop\\encodedB64.txt");


        try {
            String encodedString = converter.encodeToBase64(converter.loadFile(inputFile));
            converter.saveToFile(encodedString, encodedFile);

        } catch (SizeLimitExceededException e) {
            System.out.println(e.getExplanation());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
