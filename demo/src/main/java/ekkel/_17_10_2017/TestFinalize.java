package ekkel._17_10_2017;

public class TestFinalize {
	boolean isEmpty;
	
	public TestFinalize(boolean checkout){
		this.isEmpty = checkout;
	}
	
	@Override
	protected void finalize() throws Throwable {
		isEmpty = true;
		super.finalize();
		if(isEmpty == false){
			System.out.println("Error. ");
		}
	}
	
	public static void main(String[] args) {
		new TestFinalize(false);
		System.gc();
	}
}
