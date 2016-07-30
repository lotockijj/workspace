package Lesson6;
/* Статические методы: int getCatCount() и setCatCount(int)
Добавить  к классу Cat два статических метода: int getCatCount() и setCatCount(int), с помощью которых можно получить/изменить количество котов (переменную catCount)
*/

public class Cat6{
    private static int catCount = 0;

    public Cat6(){
        catCount++;
    }

    public static int getCatCount(){
        return catCount; 
        //напишите тут ваш код
    }
    public static void setCatCount(int catCount){
        Cat6.catCount = catCount; 
        //напишите тут ваш код
    }
}
