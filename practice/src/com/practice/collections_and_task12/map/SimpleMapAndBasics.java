package com.practice.collections_and_task12.map;

import java.util.HashMap;
import java.util.Map;

public class SimpleMapAndBasics {
    public static void main(String[] args) {
        Map<String,Integer> treasures = new HashMap<>();
        treasures.put("bronze", 125);
        treasures.put("silver", 300);
        treasures.put("gold",500);

        treasures.put("silver", 333); // если тот же ключ использовать для другого значения, происходит перезапись

        System.out.println(treasures.get("silver"));
        //ключ и значение
        // если в качестве ключа используется объект класса, то тогда должны быть соблюдены следующие условия:
        // все поля класса final или в классе нет сеттеров для полей
        // сам класс final и не имеет подклассов
        // если поле класса хранит ссылку на объект, к нему все те же требования
        // класс должеть имлементировать методы equals & hash code
    }
}
