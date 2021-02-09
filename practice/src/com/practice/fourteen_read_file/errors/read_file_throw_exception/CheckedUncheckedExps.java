package com.practice.fourteen_read_file.errors.read_file_throw_exception;

public class CheckedUncheckedExps {
    public static void main(String[] args) {
        //Checked exception (compile time expt) исключительные случаи в ходе компиляции программы, не обработав их, код не скомпилируется
        //Unchecked exception (runtime exception) ошибка в ходе работы программы

        String name = null;
        name.length(); // вызываем метод ссылаясь на пустоту NullPointerException
    }
}
