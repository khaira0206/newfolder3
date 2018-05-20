package collections;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

 class pair {
	 
	List<Integer> Inbound_List ;
	List<Integer> Outbound_List ;
	Float rank;
	
	public pair(Float val){
		 Inbound_List = new LinkedList<Integer>();
		 Outbound_List = new LinkedList<Integer>();
		  rank = val;
	}
	LinkedList<Integer> getInbound(){
		return (LinkedList<Integer>) Inbound_List;
	}
	LinkedList<Integer> getOutbound(){
		return (LinkedList<Integer>) Outbound_List;
	}
	
}

class GraphAdj1{
	
	   Map<Integer, pair> adj_List;
	  float dist ;
	  int number_of_vertices ;
	  
	  HashMap<Integer , Float> rank = new HashMap<Integer, Float>();
	  
	  
	  
	   public GraphAdj1(int number_of_vertices){
		   adj_List = new HashMap<Integer, pair>();
		   float val  = (float)1 / number_of_vertices;
		   for(int i = 1; i <= number_of_vertices; i++){
			  // System.out.println(rank.values());
				  rank.put(i, val);
			  }
		   
		   this.number_of_vertices = number_of_vertices;
	
	        for (int i = 1 ; i <= number_of_vertices ; i++)
	        { 
	        	adj_List.put(i, new pair(val));
	        }
		  
		   
	   }
	   public void addEdge(int src, int dest){
		   
		   if (src > adj_List.size() || dest > adj_List.size())
	       {
	          // System.out.println("the vertex entered in not present ");
	           return;
	       }
		   
		    pair dlist =  adj_List.get(dest);
		    dlist.getInbound().add(src);
		    adj_List.put(dest, dlist);
		    
		    pair slist =  adj_List.get(src);
		   slist.getOutbound().add(dest);
		   adj_List.put(src, slist);
	   }
	   
	   public void  show(){
		   
		   Iterator<Entry<Integer, pair>> it = adj_List.entrySet().iterator();
		   while(it.hasNext()){
			   Entry<Integer, pair> pair = it.next();
			   System.out.println(" In "+pair.getValue().Inbound_List +" "+pair.getKey()+" "+" Out " + pair.getValue().Outbound_List);
		   }
	   }
	   
	   public Map<Integer, pair> pageRank(){
		   
		   for(int i = 1; i <= 50; i++){
			   step(adj_List);
			 // rank =  normalize(rank);
			  // System.out.println(rank.values());
		   }
		   for(int i = 1; i <= number_of_vertices; i++){
			   System.out.println(adj_List.get(i).rank);
		   }
		   
		   return adj_List;
	   }
	   public HashMap<Integer, Float> normalize(HashMap<Integer, Float> rank2){
		   
		   float sqr = 0;
		   float val;
		   Iterator<Entry<Integer, Float>> it = rank2.entrySet().iterator();
		   while(it.hasNext()){
			   val = it.next().getValue();
			   sqr += val * val; 
		   }
		   while(it.hasNext()){
			   val = it.next().getValue();
			   rank2.put(it.next().getKey(), (float) (val / Math.sqrt(sqr)));
		   }
		   return rank2;
				   
		   
	   }
	   public void step(Map<Integer, pair> adj_List){
		   
		 
		   
		   float dampFactor = (float) 0.85;		   
		   float constant = (float)(1 - dampFactor)/number_of_vertices;
		   
		   for(int i = 1; i <= adj_List.size() ; i++){
			  float val = 0;
			  int j = 0;
			  float val1 = rank.get(i);
			   for(int a : adj_List.get(i).getInbound()){
				   
				  val = val+ ( adj_List.get(a).rank / adj_List.get(a).getOutbound().size());
				
			   }
			   val *=  dampFactor;
			   val += constant;
			   adj_List.get(i).rank = val;
			// rank.put(i, val);
			   val1 =0;
		   }
		   
		
	   }
	   
	   
	
	
}

public class pageRank1 {

	public static void main(String arg[] ){
		int n = 50;
		int m = 500;
		int val = 0;
		Random random = new Random();
		HashMap<Integer , Integer> vetices = new HashMap<Integer , Integer>();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			val = random.nextInt(m);
		    Random random1 = new Random();
		
		for(int j = 1; j <= val; j++){
		
			for(int k = 0; k < 5; ){
			int b = random1.nextInt(val);
			if(j != b){
				if( j < b)
			vetices.put(j, b);
				k++;
			}
			
			}
		}
		GraphAdj1 ga = new GraphAdj1(vetices.size());
		
		Iterator<Entry<Integer, Integer>> it = vetices.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, Integer> pair = it.next();
			ga.addEdge(pair.getKey(), pair.getValue());
			
		}
		ga.pageRank();
		System.out.println("-------------------------------");
		}
		
		
		
		
		
		
		
	
	}
	
	
	
	
	
}
