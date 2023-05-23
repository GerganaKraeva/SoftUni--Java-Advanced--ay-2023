package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String toReadPath = "C:\\Users\\gerga\\IdeaProjects\\geri\\Advanced\\tasks\\StreamsFilesAndDirectoriesLab\\input.txt";
        FileInputStream inputStream = new FileInputStream(toReadPath);
        String writePath = "C:\\Users\\gerga\\IdeaProjects\\geri\\Advanced\\tasks\\StreamsFilesAndDirectoriesLab\\03.CopyBytesOutput.txt";
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
