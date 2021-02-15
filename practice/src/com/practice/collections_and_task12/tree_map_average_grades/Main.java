package com.practice.collections_and_task12.tree_map_average_grades;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        NavigableMap<AverageStudentsGrade, Set<SubjectGrade>> map = createGrades();
        printGrades(map, true);
    }

    private static void printGrades(Map<AverageStudentsGrade, Set<SubjectGrade>> grades, boolean printValue){
        Set<AverageStudentsGrade> averageGradeAsKey = grades.keySet(); //создаю множество ключей взятых из МАП на входе
        for (AverageStudentsGrade gr: averageGradeAsKey){
            System.out.println(gr);
            if(printValue){
                System.out.println(grades.get(gr)); //если в методе параметр printvalue будет задан как true, то запрашиваю значение у МАП по ключу
            }
        }

    }

    private static NavigableMap<AverageStudentsGrade, Set<SubjectGrade>> createGrades() { //метод возвращает МАП
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

        NavigableMap<AverageStudentsGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AverageStudentsGrade("Artjom", calcAverage(artjomGrades)), artjomGrades);
        map.put(new AverageStudentsGrade("Anton", calcAverage(antonGrades)), antonGrades);
        map.put(new AverageStudentsGrade("Olga", calcAverage(olgaGrades)), olgaGrades);
        map.put(new AverageStudentsGrade("Kos", calcAverage(kosGrades)), kosGrades);
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
