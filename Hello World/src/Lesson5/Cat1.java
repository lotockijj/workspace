package Lesson5;
/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat1{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat1(){
    }

    public boolean fight(Cat anotherCat){
       int incAge = this.age>anotherCat.age ? 1:0;
       int incWeight = this.weight>anotherCat.weight ? 1:0;
       int incStrength = this.strength>anotherCat.strength ? 1:0;
       return (incAge+incWeight+incStrength)>0; //напишите тут ваш код
    }
}