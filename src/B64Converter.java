import javax.naming.SizeLimitExceededException;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

public class B64Converter {

    public byte[] loadFile(File file) throws IOException, SizeLimitExceededException {
        InputStream inputStream = new FileInputStream(file);
        long fileSize = file.length();


        if (fileSize > 52428800) {
            String sizeLimitExceeded = "File size is about " + fileSize / 1048576 + " mb. We only can convert less than 50 mb";
            throw new SizeLimitExceededException(sizeLimitExceeded);
        }

        return Files.readAllBytes(file.toPath());

    }

    public void saveToFile(String encoded, File outputFilePath) throws IOException {
        OutputStream outputStream = new FileOutputStream(outputFilePath);
        outputStream.write(encoded.getBytes());
    }

    public String encodeToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String encodeToBase64(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }

    public byte[] decodeFromBase64(String encodedString) {
        return Base64.getDecoder().decode(encodedString);
    }


}
