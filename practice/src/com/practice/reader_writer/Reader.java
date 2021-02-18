package com.practice.reader_writer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); // класс обёртка
        String c;
        while ((c = reader.readLine()) != null) {
            System.out.println(c);
        }
    }

    public List<Student> readObjects(String fileName) {
        List<Student> recievedObject = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            while (true) {
                Student student = (Student) in.readObject(); // кастинг нужен!
                recievedObject.add(student);
            }
        } catch (EOFException e) {
            System.out.println("end of file reached");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error, please buy a new computer");
            e.printStackTrace();
        }
        return recievedObject; // вернёт список из объектов класса студент
    }
}
