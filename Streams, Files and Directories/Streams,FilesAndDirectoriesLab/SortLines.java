package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path readPath = Paths.get("input.txt");
        Path writePath = Paths.get("06.SortLinesOutput.txt");

        List<String>allLines= Files.readAllLines(readPath);
        Collections.sort(allLines);
        Files.write(writePath,allLines);
    }
}
