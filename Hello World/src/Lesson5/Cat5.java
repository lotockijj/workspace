package Lesson5;
/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/
public class Cat5{
	String name;
	int weight = 2;
	int age = 1;
	String color;
	String adress; 
	public Cat5(String name){
		this.name = name;
	}
	public Cat5(String name, int weight, int age){
		this.name = name;
		this.weight = weight;
		this.age = age; 
	}
	public Cat5(String name, int age){
		this.name = name;
		this.age = age;
	}
	public Cat5(int weight, String color){
		this.weight = weight;
		this.color = color;
	}
	public Cat5(int weight, String color, String adress){
		this.weight = weight;
		this.color = color;
		this.adress = adress; 
	}
	
	
	
    //напишите тут ваш код

}
