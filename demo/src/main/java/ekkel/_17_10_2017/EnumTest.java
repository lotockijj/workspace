package ekkel._17_10_2017;

public class EnumTest {
	enum Day{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURDAY, FRIDAY, SATURDAY
	}
	
	public void print(){
		for(Day d : Day.values()){
			System.out.println(d + " " + d.ordinal());
		}
	}
	
	public static void main(String[] args) {
		EnumTest test = new EnumTest();
		test.print();
	}
}
