public class Divider {
    public static double divide(double a, double b){
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }
}
