package pizza2;


public abstract class Pizza {

	String name;
	Dough dough;
	Veggies veggies[];

	abstract void prepare();

	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return name;
	}
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("--- " + name + " ---\n");
		if(dough != null){
			result.append(dough);
			result.append("\n");
		}
		if(veggies != null){
			for(int i = 0; i < veggies.length; i++){
				result.append(veggies[i]);
				result.append(", ");
			}
			result.append("\n");
		}
		return result.toString();
	}
}