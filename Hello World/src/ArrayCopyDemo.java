
class ArrayCopyDemo {
    public static void main(String[] args) {
//        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
//                'i', 'n', 'a', 't', 'e', 'd' };
//        char[] copyTo = new char[7];
// 
//        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
//        System.out.println(new String(copyTo));
        ArrayCopyDemo demo = new ArrayCopyDemo();
        System.out.println(demo.returnSumOfNumbers("1234"));
    }
    
    public int returnSumOfNumbers(String str){
    	int sum = 0;
    	for(int i = 0; i < str.length(); i++){
    		if(!Character.isDigit(str.charAt(i))){
    			throw new NumberFormatException();
    		}
    		//sum += Integer.parseInt(Character.toString(str.charAt(i)));
    		sum += Character.getNumericValue(str.charAt(i));
    	}
    	return sum;
    }
}