package Lesson6;
/* По 50 000 объектов Cat и Dog
Создать в цикле по 50 000 объектов Cat и Dog. (Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

public class Cat2{
    public static void main(String[] args){
        for(int i = 0; i<50000; i++){
            //Cat a = new Cat();
            //Dog d = new Dog(); 
        }
        //напишите тут ваш код
    }
}
/*class Cat{
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("Cat destroyed");
    }
}

class Dog{
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("Dog destroyed");
    }
}
*/