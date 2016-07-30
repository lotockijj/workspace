import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * byte b = 1;
short s = 2;
char c = 3;
int i = 4;
long l = 5;
float f = f;
double d = d;

What type has the following expression:
b + 1
b + s
b + s + c
b + s + c + i
b + s + c + i + l
b + s + c + i + l + f
b + s + c + i + l + f + d

---------
* Multidimensional array?
* initialization of Multidim array?
* If we have:
Object[] a = new Object[1];
can we:
a[0] = "asdf";
* varargs & arrays (what's in common, what's diff)
* variables:
String a = "1";
void m(String a) {
	a = "2";
}
System.out.println(a); // What will be printed out
-----------
TODO:
refactor (simplify) the following expr:
boolean isC() {
	return isA() ? true : isB();
}


-----------
// simplify the following:
int getVAlue() {
	return (!(!(a > 5) && (!b))) ? 1 : 0;
}

________________
char aSystem.out.println(a); // -> A = ?; // all possible options so that:
System.out.println(a); // -> 


___________________-
create theFirstArray with values 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
print this array



_______________
create two dimensions array theSecondArray, fist raw 0, 1, 2, second raw 3, 4. Print this array
 */
public class OperatorsLesson {
    //  System.out.println(a); // -> A - what can we put as "a"	
	//static char a = 'A'; 
	//static char a = 65;
	static char a = 41;
	// hex.substringInteger.toHexString((int) 'a');
	// Integer.toBinaryString((int) 'b');
	public static void main(String[] args){
		System.out.println(a);
		
		int [] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int i = 0; 
		b = null;
		while ( b != null && i<b.length ){
		System.out.println(b[i]);
		i++;
		}
		int[] z; 
		z = new int[10]; 
		z[0] = 0;
		z[1] = 1;
		z[2] = 2;
		z[3] = 3;
		z[4] = 4;
		z[5] = 5;
		z[6] = 6;
		z[7] = 7;
		z[8] = 8;
		z[9] = 9;
		int m = 0;
		do{
			System.out.println(z[m]);
			m++; 
		}while(m<10);
		int[] s = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 90}; 
		for(int l = 0; l<s.length; l++){
			System.out.println(s[l] + " ");
		}
		int[][] f = {{ 0, 1, 2}, { 3, 4}};
		for (int v = 0; v < f.length; v++) {
			for (int j=0; j<f[v].length; j++){
				System.out.println(f[v][j]);
			}
		}
		System.out.println(Arrays.deepToString(f));	
		System.out.println(Arrays.toString(f[0]));	
	
	
	while(true) {
		System.out.println("q");
		break; 
	}
		
	Boolean condition2 = true;
	do {
		break; 
	} while (true);
	
	for(short mm = 1; mm>=0; mm++){
		System.out.println("Q");
	}
	condition2 = false;
	System.out.println(condition2);
	return; 
	}
}





