
public class find_union {

	public static void main(String args[]){
		int N = StdIn.readInt();
		find_union fu  = new find_union(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(fu.connected(p, q)){
				
				
			}
			
		}
		
	}
	private int[] id, sz;
	
	public find_union(int n){
		for(int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
		}
		
	}
	public boolean connected(int p, int q){
		
		return root(p) == root(q);
		
	}
	public int root(int i){
		while(i != id[i]){ 
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	public void union(int p, int q){
		
		 int i = root(p);
		 int j = root(q);
		 if (i == j) return ;
		 if(sz[i] < sz[j]){
			 id[i] = j;
			 sz[j] += sz[i];
		 }else{
			 id[j] = i;
			 sz[i] += sz[j];
		 }
		 
		 
		 
	}
	
}
