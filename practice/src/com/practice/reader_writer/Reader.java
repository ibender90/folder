package com.practice.reader_writer;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public void nioReadWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8"); // пример того, как дать понять джаве, если формат записей в файле отличается от стандарта
        try (BufferedReader reader = Files.newBufferedReader(path, charset)){
            String c;
            while ((c = reader.readLine()) != null) {
                System.out.println(c);
            }
        }
    }
    public void nioReadWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try(InputStream in = Files.newInputStream(path)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String c;
            while ((c = reader.readLine()) != null) {
                System.out.println(c);
            }
        }
    }

    public void readEntireFile(String filename) throws IOException { //пример способа прочитать файл целиком
        Path path = Paths.get(filename);
        List<String> lines = Files.readAllLines(path); // сохраняю файл построчно в список
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
    public void readWithChannel(String fileName) throws IOException {
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");  // rw = read/write
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100); // выделяю буферу 100 байт для работы
        int bytesNumber = channel.read(buffer); // = 100
        while(bytesNumber > 0){
            buffer.flip(); // указываем на начало буфера
            while (buffer.hasRemaining()){ // пока данные есть в буфере
                System.out.print((char)buffer.get()); // получаю у буфера данные и привожу к символьному типу
            }
            buffer.clear();
            bytesNumber = channel.read(buffer); //даю буферу новую порцию информации
        }
        channel.close();
    }

}
