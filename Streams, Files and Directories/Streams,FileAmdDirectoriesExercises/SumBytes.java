package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        int oneByte=inputStream.read();
        int sum=0;

        while (oneByte>=0){
            if(oneByte!=10 && oneByte!=13){
                sum+=oneByte;
            }
            oneByte=inputStream.read();
        }
        System.out.println(sum);
        inputStream.close();

    }
}

