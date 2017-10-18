package designpatterns.fourteen;

import org.junit.Assert;
import org.junit.Test;

import designpatterns.builder.Builder;
import designpatterns.builder.Container;
import designpatterns.builder.FactoryBuilder;

public class BuilderTest {

	@Test
	public void test() {
		FactoryBuilder factory = new FactoryBuilder();
		Builder builder = factory.getBuilder("Packet");
		Container container = new Container(builder);
		container.build();
		Assert.assertEquals("AB packet", 
				builder.getObject().toString());
		
		builder = factory.getBuilder("BOX");
		container = new Container(builder);
		container.build();
		Assert.assertEquals("CD box", builder.getObject().toString());
	}

}
