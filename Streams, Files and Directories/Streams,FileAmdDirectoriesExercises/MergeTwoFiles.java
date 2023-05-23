package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path pathFirst = Paths.get("inputOne.txt");
        Path pathSecond = Paths.get("inputTwo.txt");
        PrintWriter writer=new PrintWriter("output7task.txt");
        List<String>firstInput= Files.readAllLines(pathFirst);
        List<String>secondInput=Files.readAllLines(pathSecond);
        firstInput.forEach(line-> writer.println(line));
        secondInput.forEach(line->writer.println(line));
        writer.close();
    }
}
