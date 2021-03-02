package com.practice.reader_writer;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class FileAttributor {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("Goods.txt");
        System.out.println("Size is " + Files.size(path));

        FileStore fs = Files.getFileStore(path);
        DosFileAttributes ats = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(ats.creationTime());
        System.out.println("is hidden? "+ ats.isHidden());

    }
}
