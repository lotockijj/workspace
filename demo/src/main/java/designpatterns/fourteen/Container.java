package designpatterns.fourteen;

public class Container {
	private Builder builder;
	
	public Container(Builder builder){
		this.builder = builder;
	}
	
	public void build(){
		builder.createComponentA();
		builder.createComponentB();
	}

}
