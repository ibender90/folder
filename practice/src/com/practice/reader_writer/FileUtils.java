package com.practice.reader_writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
}
