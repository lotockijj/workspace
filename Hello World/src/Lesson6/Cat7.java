package Lesson6;
/* Класс Util
Реализовать статический метод double getDistance(x1, y1, x2, y2). Он должен вычислять расстояние между точками.
Используй метод double Math.sqrt(double a), который вычисляет квадратный корень переданного параметра
*/

public class Cat7{
    public static double getDistance(int x1, int y1, int x2, int y2){
              return Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))); 
         //напишите тут ваш код

    }
    public static void main(String[] args){
    	
    	System.out.println(Cat7.getDistance(3, 1, 6, 6));
    }
}
