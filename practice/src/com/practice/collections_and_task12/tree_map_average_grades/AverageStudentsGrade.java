package com.practice.collections_and_task12.tree_map_average_grades;

public class AverageStudentsGrade implements Comparable<AverageStudentsGrade>{ //класс для сортировки объектов по полю оценка
    private final String name;
    private final float averageGrade;

    public AverageStudentsGrade(String name, float averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public float getAverageGrade() {
        return averageGrade;
    }


    @Override
    public int compareTo(AverageStudentsGrade thatGrade) {
        if(this.averageGrade < thatGrade.getAverageGrade()){
            return 1; // не корректно, но я знаю
        }
        if(this.averageGrade > thatGrade.getAverageGrade()){
            return -1;
        }
        else return name.compareTo(thatGrade.getName());
    }

    @Override
    public String toString() {
        return name +" has average grade: " + averageGrade;
    }
}
