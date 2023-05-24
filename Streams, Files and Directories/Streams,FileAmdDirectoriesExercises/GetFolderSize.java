package StreamsFilesAndDirectorieseExercises.Exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\gerga\\IdeaProjects\\geri\\Advanced\\tasks\\StreamsFilesAndDirectoriesLab\\Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();
        int folderSize = 0;
        for (File file : allFiles) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
