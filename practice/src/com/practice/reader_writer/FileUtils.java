package com.practice.reader_writer;

import java.io.IOException;
import java.nio.file.*;

public class FileUtils {
    public static void printNioDetails(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Path absolutePath = path.toAbsolutePath();

        Path parentPath = absolutePath.getParent();
        Path filesPath = parentPath.resolve("newFiles"); //resolve == path/newFiles
        if(Files.notExists(filesPath)){
            Files.createDirectory(filesPath);
        }
        Files.copy(absolutePath, filesPath.resolve(path), StandardCopyOption.REPLACE_EXISTING); // скопируем файл пришедший в аргументе метода в новую папку
        //         from                 to                       how
    }

    public void processDir() throws IOException {
        Path path = Paths.get("temp"); // create a file in project root directory

        if(Files.notExists(path)){
            Files.createDirectory(path);
        }

        Files.createDirectory(Paths.get("temp/a/b/c")); //a fast way to create subfolders
        Files.createTempDirectory(path, "tmp"); // to create a temporary folder

        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories(); //a way to get hard drive names
        for(Path roots: rootDirectories){
            System.out.println(roots);
        }

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() { //filter out directories
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };

        try(DirectoryStream<Path> paths = Files.newDirectoryStream(path, filter)){ //filter as a parameter
            for(Path everyPath: paths){
                System.out.println(everyPath);
            }
        }
    }
}
