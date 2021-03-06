package spartez;

import java.util.HashMap;
import java.util.Map;
/**Decode a Map
Question
Implement a method that decodes a String to a corresponding Map. 
The String is composed of key-value pairs. 
Key is separated from value with an 'equals' character ('='). 
Pairs are separated with an 'ampersand' character ('&'). Example: key=value&key=value&....
Empty keys and values are allowed, but the equals sign must be present (e.g. "=value", "key=").
If the key is empty, empty String should be put to the map as key.
If the value is empty, empty String should be put to the map as value.
If the given String is empty, an empty Map should be returned.
If the given String is null, null should be returned.

If the given String has an invalid format, an IllegalArgumentException should be thrown.
Your implementation must implement the MapDecoder interface.
Sample Input: "one=1&two=2"
should return a Map containing {"one": "1", "two": "2"}
 */

public class MyMapDecoder{

	public Map<String, String> decode(String s){
		Map<String, String> map = new HashMap<>();
		if(s.isEmpty()){
			return map;
		}
		if(s != null){
			String[] tokens = s.split("&");
			for (int i = 0; i < tokens.length; i++) {
				String[] tok = tokens[i].split("=");
				if(tokens[i].charAt(0) == '='){
					map.put(null, "");
				} else if(tok.length == 1){
					map.put(tok[0], "");
				} else {
					map.put(tok[0], tok[1]);
				}
			}
		}
		return map;
	}
}
