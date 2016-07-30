package JavaRush;

public class ThreeTime{
    public static void print3(String s){
        System.out.print(s + " ");
        System.out.print(s + " ");
        System.out.print(s);
        System.out.println();
    }
    public static void main(String[] args){
        print3("window");
        print3("file");
    }
}
