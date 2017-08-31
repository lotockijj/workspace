package designpatterns.fourteen;

public class FactoryBuilder {
	
	public Builder getBuilder(String bld){
		Builder builder = null;
		if(bld.equals("Packet")){
			builder = new PacketBuilder();
		}
		if(bld.equals("BOX")){
			builder = new BoxBuilder();
		}
		return builder;
	}

}
