package Start;

public class QuickFindUF { //quick-find algorithm.
	
	private int[] id = new int[10];
	
	public QuickFindUF(int N){
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q){
		return id[p] == id[q];
	}
	
	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++){
			if(id[i] == pid) id[i] = qid;
		}
	}
	
	public static void main(String[] args){
		QuickFindUF x = new QuickFindUF(10);
		x.union(0, 4);
		x.union(5, 8);
		x.union(9, 1);
		x.union(7, 1);
		x.union(9, 8);
		x.union(6, 8);
		x.show();
	}

	private void show() {
		for(int i = 0; i < id.length; i++){
			System.out.print(id[i] + " ");
		}
	}
}
