public class Simple {
    public static void main(String[] args) {

        for (int i = 2; i < 100; i ++){
            boolean simpleNumber = true;

            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    simpleNumber = false;
                    break;
                }
            }
            if (simpleNumber){
                System.out.println(i);
            }
        }


    }
}
