package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String toReadPath = "input.txt";
        FileInputStream inputStream = new FileInputStream(toReadPath);
        String writePath = ".CopyBytesOutput.txt";
        FileOutputStream outputStream = new FileOutputStream(writePath);

        int oneByte = inputStream.read();
        while (oneByte >= 0 ) {
            if(oneByte==10 ||oneByte==32){
                outputStream.write(oneByte);
            }else {
                String digits=String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }
            oneByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
