package JavaRush9;
/* Исключение при работе с числами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int a = 42 / 0;
*/
public class Solution{
    public static void main(String[] args) throws Exception{
        try{
            int a = 42 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
        //напишите тут ваш код
    }
}