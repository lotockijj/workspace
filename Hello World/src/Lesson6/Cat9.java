package Lesson6;
/*  ласс StringHelper
Cделать класс StringHelper, у которого будут 2 статических метода:
String multiply(String s, int count) Ц возвращает строку повторенную count раз.
String multiply(String s) Ц возвращает строку повторенную 5 раз.
ѕример:
јмиго -> јмигојмигојмигојмигојмиго
*/

public class Cat9{
    public static String multiply(String s){
    	String result = "";
        for(int i = 0; i<5; i++){
        	result+=s; 
        }
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count){
    	 String result = "";
         for(int i = 0; i<count; i++){
         	result+=s; 
         }
        //напишите тут ваш код
        return result;
    }
}

