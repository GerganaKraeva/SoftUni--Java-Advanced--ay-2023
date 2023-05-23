package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineNumber {
    public static void main(String[] args) throws IOException {
        Path path= Paths.get("umbers.txt");
        List<String> lines= Files.readAllLines(path);
        BufferedWriter writer=new BufferedWriter(new FileWriter(""))
            writer.write(i+1 +". " + lines.get(i));
            writer.newLine();
        }
        writer.close();
    }
}
