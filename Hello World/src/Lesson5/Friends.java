package Lesson5;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friends{
	private String filename = null;
	public void initialize(String name){
		this.filename = name; 
	}
	public void initialize(String name, String age){
		this.filename = name + age; 
	}
	public void initialize(String name, String age, String sex){
		this.filename = name + age + sex; 
	}
    //напишите тут ваш код
}
