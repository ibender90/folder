package com.practice.collections_and_task12.task5;
//Выполнять в подпапке task5 в day12 *
//        Скопировать MusicBand из прошлого задания и доработать - теперь у участника
//        музыкальной группы есть не только имя, но и возраст. Соответственно, теперь под
//        участником понимается не строка, а объект класса MusicArtist . Необходимо
//        реализовать класс MusicArtist и доработать класс MusicBand (создать копию
//        класса) таким образом, чтобы участники были - объекты класса MusicArtist . После
//        этого, надо сделать то же самое, что и требовалось в 4 задании - слить две группы и
//        проверить состав групп после слияния. Методы для слияния и для вывода участников
//        в консоль необходимо тоже переработать, чтобы они работали с объектами класса
//        MusicArtist .
public class Task5 {
    public static void main(String[] args) {

        MusicBand m1 = new MusicBand("Nirvana", 1999);
        Artist a1 = new Artist("Court Cobain", 21);
        m1.addMember(a1);
        m1.printMembers();

        MusicBand m2 = new MusicBand("Leningrad", 1995);
        Artist a2 = new Artist("Shnur", 40);
        Artist a3 = new Artist("Alex", 50);
        m2.addMember(a2);
        m2.addMember(a3);
        m2.printMembers();

        MusicBand.transferMembers(m1, m2); //m1 group list is filled with people from m2, then m2 list is wiped
        m1.printMembers();
        m2.printMembers();


    }

}
