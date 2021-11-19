import java.util.Random;

public class WeightOfElement {
    private int[] elements = new int[10];
    private int[] weight = new int[10];

    public WeightOfElement(int[] elements, int[] weight) {
        this.elements = elements;
        this.weight = weight;
    }

    public int getRandomElement() {
        Random random = new Random();
        int bound = createSubArray().length;
        return createSubArray()[random.nextInt(bound)];
    }

    public int getNewLength() {
        int length = 0;
        for (int number : this.weight) {
            length += number;
        }
        return length;
    }

    public int[] createSubArray() {
        int[] sub = new int[getNewLength()];
        int offset = 0;
        for (int indexOfWeight = 0; indexOfWeight < 10; indexOfWeight++) {
            for (int j = 0; j < weight[indexOfWeight]; j++) {
                sub[offset] = elements[indexOfWeight];
                offset++;
            }
        }
        return sub;
    }
}

class Test {
    public static void main(String[] args) {
        int[] testNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] weigths =     {1, 3, 7, 4, 6, 2, 1, 7, 6, 7};
        WeightOfElement weight = new WeightOfElement(testNumbers, weigths);

        int result = weight.getRandomElement();
        System.out.println(result);
    }
}
