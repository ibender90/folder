package com.practice.collections_and_task12.tree_map_average_grades;

import java.util.*;

public class GradesToMap {
    public static void main(String[] args) {
        NavigableMap<StudentsAverageGrade, Set<SubjectGrade>> gradesMap = createGrades();
        printGrades(gradesMap.descendingMap(), false); // дерево отсортировано по средней оценке по возрастанию, но для вывода лучше перевернуть

        StudentsAverageGrade border = gradesMap.ceilingKey(new StudentsAverageGrade(" ", 4));
        // граница для получения стипендии - создаю объект с оценкой 4 , только объекты с оценкой выше 4 получат стипендию
        NavigableMap<StudentsAverageGrade, Set<SubjectGrade>> luckyBastards = (NavigableMap<StudentsAverageGrade, Set<SubjectGrade>>) gradesMap.tailMap(border);
        // создаю отдельный мап состоящий только из объектов, у которых averageGrade > 4

        System.out.println("++++++++++++++++++++++++++");
        System.out.println("Scholarship winners: ");
        printGrades(luckyBastards, false);
        System.out.println("++++++++++++++++++++++++++");

        System.out.println("Person who is very close to scholarship:");
        StudentsAverageGrade almostRich = gradesMap.lowerKey(border); // у мап из всех оценок запрашиваю ключ
        System.out.println(almostRich);
    }

    private static void printGrades(Map<StudentsAverageGrade, Set<SubjectGrade>> grades, boolean printValue){
        Set<StudentsAverageGrade> averageGradeAsKey = grades.keySet(); //создаю множество ключей взятых из МАП на входе
        for (StudentsAverageGrade everyGrade: averageGradeAsKey){
            System.out.println(everyGrade);
            if(printValue){
                System.out.println(grades.get(everyGrade)); //если в методе параметр printValue будет задан как true, то запрашиваю значение у МАП по ключу
            }
        }
    }

    public static NavigableMap<StudentsAverageGrade, Set<SubjectGrade>> createGrades() { //метод возвращает МАП
        Set<SubjectGrade> artjomGrades = new HashSet<>();
        artjomGrades.add(new SubjectGrade("math", 3));
        artjomGrades.add(new SubjectGrade("biology", 5));
        artjomGrades.add(new SubjectGrade("physics", 3));
        artjomGrades.add(new SubjectGrade("literature", 4));
        artjomGrades.add(new SubjectGrade("music", 5));
        artjomGrades.add(new SubjectGrade("sport", 5));

        Set<SubjectGrade> antonGrades = new HashSet<>();
        antonGrades.add(new SubjectGrade("math", 2));
        antonGrades.add(new SubjectGrade("biology", 3));
        antonGrades.add(new SubjectGrade("physics", 2));
        antonGrades.add(new SubjectGrade("literature", 3));
        antonGrades.add(new SubjectGrade("music", 4));
        antonGrades.add(new SubjectGrade("sport", 5));

        Set<SubjectGrade> olgaGrades = new HashSet<>();
        olgaGrades.add(new SubjectGrade("math", 5));
        olgaGrades.add(new SubjectGrade("biology", 4));
        olgaGrades.add(new SubjectGrade("physics", 5));
        olgaGrades.add(new SubjectGrade("literature", 3));
        olgaGrades.add(new SubjectGrade("music", 5));
        olgaGrades.add(new SubjectGrade("sport", 3));

        Set<SubjectGrade> kosGrades = new HashSet<>();
        kosGrades.add(new SubjectGrade("math", 4));
        kosGrades.add(new SubjectGrade("biology", 3));
        kosGrades.add(new SubjectGrade("physics", 3));
        kosGrades.add(new SubjectGrade("literature", 4));
        kosGrades.add(new SubjectGrade("music", 5));
        kosGrades.add(new SubjectGrade("sport", 4));

        NavigableMap<StudentsAverageGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new StudentsAverageGrade("Artjom", calcAverage(artjomGrades)), artjomGrades);
        map.put(new StudentsAverageGrade("Anton", calcAverage(antonGrades)), antonGrades);
        map.put(new StudentsAverageGrade("Olga", calcAverage(olgaGrades)), olgaGrades);
        map.put(new StudentsAverageGrade("Kos", calcAverage(kosGrades)), kosGrades);
        // в дерево добавляются объекты, имя и средняя оценка это ключ, а множество оценок это значение
        return map;
    }

    private static float calcAverage(Set<SubjectGrade> grades) {
        float sum = 0;
        for (SubjectGrade e : grades) {
            sum += e.getGrade();
        }
        return sum / grades.size();
    }
}
