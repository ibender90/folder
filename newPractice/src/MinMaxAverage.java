import java.util.Arrays;

public class MinMaxAverage {
    public static void main(String[] args) {
        double[] numbers = new double[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random();
        }
        System.out.println("Unsorted array" + Arrays.toString(numbers));

        double min = numbers[0];
        double max = numbers[0];
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if(numbers[i] < min){
                min = numbers[i];
            }
            sum += numbers[i];
        }
        double average = sum / numbers.length;
        System.out.println("maximum is " + max);
        System.out.println("minimum is " + min);
        System.out.println("average is " + average);

        for (int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length-1; j++){
                if (numbers[j] > numbers[j+1]){
                    double temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        System.out.println("sorted array" + Arrays.toString(numbers));
    }
}
