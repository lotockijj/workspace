package designpatterns.sixteenth;

public class Candidate {
	private String name;
	private int age;
	private int experience;
	private String type;
	
	public Candidate(String name, int age, int experience, String type) {
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getExperience() {
		return experience;
	}
	public String getType() {
		return type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", age=" + age + ", experience=" + experience + ", type=" + type + "]";
	}
	
}
