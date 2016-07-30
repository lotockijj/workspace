package Lesson5;
/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat(String name, int age, int weight, int strength){
    	this.name = name;
    	this.age = age; 
    	this.weight = weight;
    	this.strength = strength;
    }

    public boolean fight(Cat anotherCat){
    	int incAge = this.age>anotherCat.age ? 1:0;
        int incWeight = this.weight>anotherCat.weight ? 1:0;
        int incStrength = this.strength>anotherCat.strength ? 1:0;
        return (incAge+incWeight+incStrength)>0;
        }
    public static void main (String [] args) {
        Cat CatVaska = new Cat("Vaska",12,3,1);
        Cat CatBardic = new Cat("Bardik",13,3,13);
        if (CatVaska.fight(CatBardic)) System.out.printf("Победа %s",CatVaska.name);
            else System.out.printf("Победа %s", CatBardic.name);//напишите тут ваш код
    }
}
