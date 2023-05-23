package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("input.txt");
        List<String> lines = Files.readAllLines(inputPath);
        long vowelLowerCaseCount = 0;
        long otherSymbols = 0;
        long punctuationMarks = 0;

        for (String line : lines) {
            for (char symbol : line.toCharArray()) {
                if (symbol == 'a' || symbol == 'u' || symbol == 'e' || symbol == 'i' || symbol == 'o') {
                    vowelLowerCaseCount++;
                } else if (symbol == '.' || symbol == '!' || symbol == '?' || symbol == ',') {
                    punctuationMarks++;
                } else if (symbol == ' ') {
                    continue;
                } else {
                    otherSymbols++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputTask4"));
        writer.write("Vowels: " + vowelLowerCaseCount);
        writer.newLine();
        writer.write("Other symbols: " + otherSymbols);
        writer.newLine();
        writer.write("Punctuation: " + punctuationMarks);
        writer.close();
    }
}
