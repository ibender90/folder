package linkedList;

public class ListRunner {
    public static void main(String[] args) {
        MySLL someList = new MySLL();
        someList.add(2);
        someList.add(3);
        someList.add(4);
        someList.add(5);

        System.out.println(someList);
        System.out.println(someList.getAt(0));

        someList.removeAt(2);
        System.out.println(someList);
    }
}
