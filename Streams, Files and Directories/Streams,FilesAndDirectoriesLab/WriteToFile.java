package StreamsFilesAndDirectoriesLab;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile  {
    public static void main(String[] args) throws IOException {
        String inputPath="input.txt";
        FileInputStream inputStream=new FileInputStream(inputPath);
        String outputPath="02.WriteToFileOutput.txt";
        FileOutputStream outputStream=new FileOutputStream(outputPath);
        int currentByte=inputStream.read();

        while(currentByte>=0){
            char currentChar=(char) currentByte;
            if(currentChar!=','&&currentChar!='.'&&currentChar!='!'&&currentChar!='?'){
                outputStream.write(currentChar);
            }
         currentByte=inputStream.read();
        }
        inputStream.close();
        outputStream.close();

    }
}
