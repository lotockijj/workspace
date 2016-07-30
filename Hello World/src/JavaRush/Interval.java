package JavaRush;

public class Interval {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
    }

    public static void checkInterval(int a){
        if(a>50 && a<100){
            System.out.printf("Число %d содержится в интервале.", a);
        }
            else {
                System.out.printf("Число %d не содержится в интервале.", a);
            }//::CODE:
    }
}
