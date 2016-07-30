package JavaRush9;
/* Исключение при работе с массивами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int[] m = new int[2]; m[8] = 5;
*/

public class Solution2{
    public static void main(String[] args) throws Exception{
        try{
    	//напишите тут ваш код

        int[] m = new int[2];
        m[8]= 5;
        } catch (ArrayIndexOutOfBoundsException e){
        	System.out.println(e);
        }

        //напишите тут ваш код

    }
}
