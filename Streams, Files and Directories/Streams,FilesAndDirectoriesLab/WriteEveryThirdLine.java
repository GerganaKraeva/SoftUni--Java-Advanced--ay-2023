package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String readPath = "C:\\Users\\gerga\\IdeaProjects\\geri\\Advanced\\tasks\\StreamsFilesAndDirectoriesLab\\input.txt";
        FileInputStream inputStream = new FileInputStream(readPath);
        Scanner scanner = new Scanner(inputStream);
        String writePath = "C:\\Users\\gerga\\IdeaProjects\\geri\\Advanced\\tasks\\StreamsFilesAndDirectoriesLab\\05.WriteEveryThirdLineOutput.txt";
        FileOutputStream outputStream = new FileOutputStream(writePath);
        PrintWriter writer = new PrintWriter(outputStream);

        String currentLine = scanner.nextLine();
        int count = 1;
        while (scanner.hasNextLine()) {
            if (count % 3 == 0) {
                writer.println(currentLine);
            }
            count++;
            currentLine = scanner.nextLine();
        }
        writer.close();
        scanner.close();
    }
}
