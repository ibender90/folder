package com.practice.collections_task12.task4;

public class Task4 {
    public static void main(String[] args) {
        MusicBand mb1 = new MusicBand("Linkin Park", 1995);
        mb1.addMember("Chester", "Bennington");
        mb1.addMember("Jason", "Stetheim");
        mb1.printMembers();
        mb1.removeMember("Jason Stetheim");
        mb1.printMembers();
        MusicBand mb2 = new MusicBand("Eminem",2008);
        mb2.addMember("Eminem","White");
        mb2.addMember("Mickel", "Jackson");
        mb2.printMembers();
        MusicBand.transferMembers(mb1,mb2);
        mb1.printMembers();
        mb2.printMembers();
    }
}
