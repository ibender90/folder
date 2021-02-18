package com.practice.reader_writer;

import com.practice.collections_and_task12.tree_map_average_grades.StudentsAverageGrade;
import com.practice.collections_and_task12.tree_map_average_grades.GradesToMap;
import com.practice.collections_and_task12.tree_map_average_grades.SubjectGrade;

import java.io.*;
import java.util.*;

public class MyBufferedReadeWriterAndFormatter {
    private static final String FILE_NAME = "journal.txt";
    private static final String BINARY_FILE_NAME = "Students.bin";

    public static void main(String[] args) throws IOException {
        Writer writer = new Writer();
        Reader reader = new Reader();

        SortedMap<StudentsAverageGrade, Set<SubjectGrade>> gradesMap = GradesToMap.createGrades(); // импортировал метод и создал мап
        writer.writeFile(gradesMap, FILE_NAME);
        //reader.readFile(FILE_NAME);
        //writer.writeWithFormatter();
        //createStudentList(gradesMap,writer,BINARY_FILE_NAME);
        showObjects(reader,BINARY_FILE_NAME);

    }
    private static void createStudentList(SortedMap<StudentsAverageGrade, Set<SubjectGrade>> grades, Writer writer, String fileName){
        List<Student> students = new ArrayList<>();
        for(StudentsAverageGrade everyKey: grades.keySet()){
            students.add(new Student(everyKey.getName(), everyKey.getAverageGrade(), grades.get(everyKey)));
            // создаю объект студент
            // через конструктор заполняю поля класса
            // добавляю студента в список
        }
        writer.writeObject(students,fileName);
    }

    private static void showObjects(Reader reader, String fileName){
        List<Student> students = reader.readObjects(fileName);
        for(Student everyStudent: students){
            System.out.printf("%s, %.2f, %n", everyStudent.getName(), everyStudent.getAverageGrade());
            System.out.println(everyStudent.getGrades());
        }
    }
}

