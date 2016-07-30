package Start;

public class QuickFindUF3 { //the weighted quick-union
	
	private int[] id = new int[10];
	private int[] sz = new int[10];
	
	public QuickFindUF3(int N){
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
		if(i == j) return; 
		if(sz[i] < sz[j]){
			id[i] = j; sz[j] += sz[i];
			}
		else{
			id[j] = i; sz[i] += sz[j];
			}
	}
	public static void main(String[] args){
		QuickFindUF3 x = new QuickFindUF3(10);
		x.union(6, 2);
		x.union(6, 9);
		x.union(7, 1);
		x.union(2, 5);
		x.union(2, 3);
		x.union(0, 4);
		x.union(7, 0);
		x.union(7, 9);
		x.union(8, 9);
		x.show();
		//6-2 6-9 7-1 2-5 2-3 0-4 7-0 7-9 8-9
	}

	private void show() {
		for(int i = 0; i < id.length; i++){
			System.out.print(id[i] + " ");
		}
	}
}
