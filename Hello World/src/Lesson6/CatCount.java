package Lesson6;
/* Cчётчик котов
В конструкторе класса Cat [public Cat()] увеличивать счётчик котов (статическую переменную этого же класса catCount) на 1. В методе finalize уменьшать на 1.
*/

public class CatCount{
    public static int catCount = 0;
    public CatCount (){
        catCount++;
    }

    protected void finalize() throws Throwable {
       catCount--;
    }
    //напишите тут ваш код

    public static void main(String[] args) {
    }
}

