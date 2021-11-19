import java.util.Random;

public class Vektor {
    private double x;
    private double y;
    private double z;

    public Vektor(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
    }

    public static double scalarProduct(Vektor v1, Vektor v2) { //scalarnoeProizvedeie
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public static Vektor crossProduct(Vektor v1, Vektor v2) { //vektornoeProizvedenie
        return new Vektor(
                v1.y * v2.z - v1.z * v2.y,
                v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x);
    }

    public static double getAngle(Vektor v1, Vektor v2) {
        return scalarProduct(v1, v2) / (v1.length() * v2.length());
    }

    public static Vektor calcSum(Vektor v1, Vektor v2) {
        return new Vektor(
                v1.x + v2.x,
                v1.y + v2.y,
                v1.z + v2.z);
    }

    public static Vektor calcDiff(Vektor v1, Vektor v2) {
        return new Vektor(
                v1.x - v2.x,
                v1.y - v2.y,
                v1.z - v2.z);
    }

    public static Vektor[] generateVektors(int N){
        Vektor[] vektors = new Vektor[N];
        Random random = new Random();
        for (int i = 0; i < N; i++){
            vektors[i] = new Vektor(
                    random.nextDouble()+ random.nextInt(),
                    random.nextDouble()+ random.nextInt(),
                    random.nextDouble()+ random.nextInt());
        }
        return vektors;
    }
}
