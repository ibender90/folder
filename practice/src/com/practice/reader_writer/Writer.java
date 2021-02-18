package com.practice.reader_writer;

import com.practice.collections_and_task12.tree_map_average_grades.StudentsAverageGrade;
import com.practice.collections_and_task12.tree_map_average_grades.SubjectGrade;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Writer {
    public void writeFile(SortedMap<StudentsAverageGrade, Set<SubjectGrade>> gradesMap, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) { //try with resources
            for (StudentsAverageGrade gradeAsKey : gradesMap.keySet()) {
                writer.write("======================================\n");
                writer.write("Student: " + gradeAsKey.getName() + " average grade: " + gradeAsKey.getAverageGrade() + "\n");
                // у каждого ключа получаем значение полей имя и средняя оценка
                for (SubjectGrade grade : gradesMap.get(gradeAsKey)) { //прохожусь по множеству объектов (предмет и оценка)
                    writer.write("Subject: " + grade.getSubjectName() + ", grade: " + grade.getGrade() + "\n");
                }
            }
        }
    }

    public void writeWithFormatter() throws FileNotFoundException {
        Formatter formatter = new Formatter("Bank accounts.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter customer ID, name, balance");
        int counter = 0;
        while (counter < 3) {
            try {
                formatter.format("%d %s %.2f%n", scanner.nextInt(), scanner.next(), scanner.nextFloat());
                counter++;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input");
                scanner.nextLine();
            }
        }
        formatter.close();
    }

    public void writeObject(List<Student> inputStudents, String filename) { //метод для сериализации и записи объектов
        // передаю методу список состоящий из объектов класса студент и строку с названием файла
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename))) ){
            //все классы должны имплементировать Serializable для обработки классом ObjectOutputStream
            for(Student objectStudent: inputStudents){
                out.writeObject(objectStudent);
            }
        } catch (IOException e) {
            System.out.println("File can not be opened");
            e.printStackTrace();
        }
    }
}
