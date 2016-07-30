package JavaRush;
/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
Подсказка:
Нужно написать тело обеих существующих функций min и исправить их возвращаемые значения.
*/
public class Four{
    public static int min(int a, int b, int c, int d) {
        int mainMin;
        int m2 = min(a,b);
        int m3 = min(c,d);
        if (m2<m3)
            mainMin = m2;
        else
            mainMin = m3;
        return mainMin;
        //напишите тут ваш код
    }
    public static int min(int a, int b) {
        int m1;
        if (a<b)
            m1=a;
        else
            m1=b;
        return m1;//напишите тут ваш код
    }
    public static void main(String[] args) throws Exception{
        System.out.println( min(-20, -10) );
        System.out.println( min(-20, -10, -30, -40) );
        System.out.println( min(-20, -10, -30, 40) );
    }
}