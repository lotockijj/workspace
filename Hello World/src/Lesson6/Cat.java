package Lesson6;
/* Метод finalize класса Cat
В классе Cat создать метод protected void finalize() throws Throwable
*/
public class Cat{
	String name;
	Cat(String name){
		this.name=name;
	}
	protected  void finalize() throws  Throwable{
   System.out.println(name + " destroyed");
	}
}

