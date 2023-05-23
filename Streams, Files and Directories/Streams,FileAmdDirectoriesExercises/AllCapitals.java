package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("path-input.txt");
        Path outputPath = Paths.get("path-output.txt");
        List<String>lines= Files.readAllLines(inputPath);


        for (int i = 0; i < lines.size(); i++) {
            String currentLine= lines.get(i);
            String newLine=currentLine.toUpperCase();
            lines.set(i,newLine);
        }
        for (String line : lines) {
            Files.write(outputPath, lines);
        }
    }
}
