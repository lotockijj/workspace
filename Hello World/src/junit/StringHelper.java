package junit;

public class StringHelper {
/*Remove all charachter 'A' in first 2 positions
 * of given String. "ABCD" => BCD, "AACD" => CD,
 * "AAAA" => AA.
 */
	public String truncateAInFirst2Positions(String str){
		if(str.length() <= 2){
			return str.replaceAll("A", "");
		}
		String first2Chars = str.substring(0, 2);
		String stringMinusFirst2Chars = str.substring(2);
		return first2Chars.replace("A", "") + stringMinusFirst2Chars;
	}
	
	public boolean areFirstAndLastTwoCharactersTheSame(String str){
		
		if(str.length() <=1){
			return false;
		}
		if(str.length() == 2){
			return true;
		}
			String first2Chars = str.substring(0, 2);
			String last2Chars = str.substring(str.length() - 2);
			return first2Chars.equals(last2Chars);
	}
}
