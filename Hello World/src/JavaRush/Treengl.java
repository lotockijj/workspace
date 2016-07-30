package JavaRush;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/
public class Treengl{
    public static void main(String[] args) throws Exception{
    	String s = "8"; 
    	for(int i = 0; i < 10; i++){
    			System.out.println(s);
    		s = s + "8"; 
    	}
        //напишите тут ваш код
    }
}

