package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.FileInputStream;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path="input.txt";
        FileInputStream inputStream=new FileInputStream(path);
        int oneByte=inputStream.read();
        long sum=0;

        while (oneByte>=0){
            if(oneByte==10) {
                System.out.println(sum);
                sum=0;
            }else{
                if(oneByte!=13)
                sum += oneByte;
            }
            oneByte= inputStream.read();
        }
        System.out.println(sum);
        inputStream.close();
    }
}
