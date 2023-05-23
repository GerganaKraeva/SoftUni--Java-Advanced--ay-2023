package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolder {
    public static void main(String[] args) {
        File folder = new File("Files-and-Streams");
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(folder);
        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}

