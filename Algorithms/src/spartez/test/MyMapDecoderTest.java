package spartez.test;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import spartez.MyMapDecoder;

public class MyMapDecoderTest {
	private MyMapDecoder myDecoder;
	
	@Before
	public void setUp() throws Exception {
		myDecoder = new MyMapDecoder();
	}

	@Test
	public void testDecode() {
		Map<String, String> map = myDecoder.decode("one=1&two=2");
		for(String str : map.keySet()){
			System.out.println("key: " + str + ", value: " + map.get(str));
		}
		// "=value&key="
	}

}
