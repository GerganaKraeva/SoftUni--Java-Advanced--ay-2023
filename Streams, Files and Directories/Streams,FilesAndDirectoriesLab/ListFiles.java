package StreamsFilesAndDirectoriesLab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder=new File("Files-and-Streams");
        if(folder.exists()){
            if(folder.isDirectory()){
                File [] allFiles=folder.listFiles();
                for (File fileList : allFiles) {
                    if(!fileList.isDirectory()){
                        System.out.printf("%s: [%d]%n",fileList.getName(),fileList.length());
                    }
                }

            }
        }
    }
}
