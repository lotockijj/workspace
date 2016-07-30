package Lesson5;
/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/
public class CatFight {
    public static void main(String[] args) {
        Cat a = new Cat("Tom", 2, 4, 6);
        Cat b = new Cat("Jery", 1, 1, 1);
        Cat c = new Cat("Dog", 10, 10, 10);
        if (a.fight(b)==true){
        	System.out.println(a.name + " win.");
        } else{
        	System.out.println(b.name + " win");
        }
        if (b.fight(c)==true){
        	System.out.println(b.name + " win.");
        } else{
        	System.out.println(c.name + " win");
        }
        if (a.fight(c)==true){
        	System.out.println(a.name + " win.");
        } else{
        	System.out.println(c.name + " win");
        }
        System.out.format("%f, %<+020.10f %n", Math.PI);
    	//напишите тут ваш код
    }

    public static class Cat {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
