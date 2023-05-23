package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\gerga\\IdeaProjects\\geri\\Advanced\\tasks\\StreamsFilesAndDirectoriesLab\\input.txt";
        FileInputStream fileStream = new FileInputStream(path);

        int oneByte = fileStream.read();
        while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte)+" ");
            oneByte = fileStream.read();
        }
        fileStream.close();
    }
}
