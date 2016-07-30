
public class MetrixToArray {

	static int N = 2; 
	static int[][] a = new int[N][N];
	static int[] b = new int[N*N]; 

	public static void main(String[] args){
		int x = 0; 
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				a[i][j] = x;
				b[x] = a[i][j];
				System.out.println("i - " + i + " j - " + j);
				System.out.println("Index - " + x + " value - " + getIndex(i, j));
				x++; 
			}
		}
	}
	public static int getIndex(int i, int j){
		return b[N*i + j];
	}
	
}
