package decorator;

import java.math.BigDecimal;

public abstract class ServiceDecorator extends Price{
	
	public ServiceDecorator(BigDecimal cost) {
		super(cost);
	}
	
	public ServiceDecorator(){
	}
	
	public ServiceDecorator(Price price){
	}

	public abstract String getDescription();
	
}
