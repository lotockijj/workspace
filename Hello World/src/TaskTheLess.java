import java.util.Arrays;

public class TaskTheLess {

	int firstNumber;
	int secondNumber;
	MyNumber myNumber;

	private void sort(int[] a){
		Arrays.sort(a);
	}

	public MyNumber findLessDifference(int[] a){
		sort(a);
		firstNumber = a[0];
		secondNumber = a[1];
		for(int i = 0; i < a.length - 1 ; i++){
			if(a[i + 1] - a[i]  <  secondNumber  - firstNumber){
				firstNumber = a[i];
				secondNumber = a[i + 1];
			}
		}
		myNumber = new MyNumber(firstNumber, secondNumber);
		return myNumber;
	}


	public static void main(String[] args) {

		int[] a = {1, 22, 333, 7777777, 4323, 10000, 77};

		TaskTheLess test = new TaskTheLess();
		System.out.println(test.findLessDifference(a));
	}
	
	public class MyNumber{
		
		int firstNumber;
		int secondNumber;
		
		public MyNumber(int firstNumber, int secondNumber){
			this.firstNumber = firstNumber;
			this.secondNumber = secondNumber;
		}
		
		@Override
		public String toString(){
			return "First number - " + this.firstNumber +
					"\nSecond number - " + this.secondNumber;
		}
	}

}
