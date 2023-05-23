package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String inputPath = "words.txt";
        String[] wordsToCheck = Files.readString(Path.of(inputPath)).split("\\s+");
        String inputPath2 = "text.txt";
        String[] wordsOfText = Files.readString(Path.of(inputPath2)).split("\\s+");
        Map<String, Integer> wordsCount = new HashMap<>();
        String outputPath= "result.txt";
        PrintWriter writer =new PrintWriter(outputPath);
        for (int i = 0; i < wordsToCheck.length; i++) {
            String currentWord = wordsToCheck[i];
            int countWord = 0;
            for (String word : wordsOfText) {
                if (currentWord.equals(word)) {
                    countWord++;
                }
            }
            wordsCount.put(currentWord, countWord);
            countWord = 0;
        }
        wordsCount.entrySet().stream().sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
