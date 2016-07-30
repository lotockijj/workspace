package Start;

public class QuickFindUF2 {
	
	private int[] id = new int[10];
	
	public QuickFindUF2(int N){
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}
	private int root(int i){
		while(i != id[i]) i = id[i];
		return i; 
	}
	
	public boolean connected(int p, int q){
		return root(p) == root(q);
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		id[i] = j; 
	}
	public static void main(String[] args){
		QuickFindUF2 x = new QuickFindUF2(10);
		x.union(1, 9);
		x.union(4, 6);
		x.union(3, 6);
		x.union(5, 0);
		x.union(1, 5);
		x.union(4, 8);
		x.union(7, 6);
		x.union(1, 7);
		x.union(1, 2);
		x.show();
	}

	private void show() {
		for(int i = 0; i < id.length; i++){
			System.out.println(id[i]);
		}
	}

}
