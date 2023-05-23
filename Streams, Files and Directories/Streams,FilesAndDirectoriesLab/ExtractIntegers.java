package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\gerga\\IdeaProjects\\geri\\Advanced\\tasks\\StreamsFilesAndDirectoriesLab\\input.txt";
        FileInputStream inputStream=new FileInputStream(path);
        Scanner reader=new Scanner(inputStream);

        while (reader.hasNext()){
            if(reader.hasNextInt()){
                int current= reader.nextInt();
                System.out.println(current);
            }
           reader.next();
        }
    }
}
