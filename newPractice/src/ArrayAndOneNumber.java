import java.util.Arrays;
import java.util.Random;

public class ArrayAndOneNumber {
    public static void main(String[] args) {
        int[] myArray = new int[30];
        Random random = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(10);
        }
        System.out.println("original  "+Arrays.toString(myArray));

        int numberToRemove = 1;
        int length = myArray.length;
        for (int i = 0; i < length; i++) {
            if (myArray[i] == numberToRemove) {
                length--;
                int[] anotherArray = new int[length];
                int offset = 0;
                for (int j = 0; j < length; j++) {
                    if (j == i){
                        offset = 1;
                    }
                    anotherArray[j] = myArray[j + offset];
                }
                myArray = anotherArray;
                i = 0;
            }
        }
        System.out.println("removed 1 " + Arrays.toString(myArray));
    }
}
