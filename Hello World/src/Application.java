import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Application {
	
	 public static void main(String[] args) {
	        List<String> list = new LinkedList<>();
	       for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	        for (int i = 0; i < 4; i++) {
	            list.add(args[i]);
	        }
	        //System.out.println(evalRPN(list));
	    }

	    public static int evalRPN(List list) {
	        int returnValue = 0;
	        String operators = "+-*/";

	        Stack<String> stack = new Stack<String>();

	        for (int i = 0; i < list.size(); i++) {
	            if (!operators.contains(list.get(i).toString())) { //push to stack if it is a number
	                stack.push(list.get(i).toString());
	            } else {//pop numbers from stack if it is an operator
	                int a = Integer.valueOf(stack.pop());
	                int b = Integer.valueOf(stack.pop());
	                switch (list.get(i).toString()) {
	                    case "+":
	                        stack.push(String.valueOf(a + b));
	                        break;
	                    case "-":
	                        stack.push(String.valueOf(b - a));
	                        break;
	                    case "*":
	                        stack.push(String.valueOf(a * b));
	                        break;
	                    case "/":
	                        stack.push(String.valueOf(b / a));
	                        break;
	                }
	            }
	        }

	        returnValue = Integer.valueOf(stack.pop());

	        return returnValue;
	    }

}
