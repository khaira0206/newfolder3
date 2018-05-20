package collections;

import java.util.List;
import java.util.ListIterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;



class Node{
	float rank;
	Set<Object> values;
	
	Node(){
		rank =  0;
	    values = new HashSet<Object>();
	}
}

class GraphAdj {

	
	
	Map<Object, Node> adj_List3 = new HashMap<Object, Node>();
	
	int size = 0;
	
	
	int t_words = 0;
	
	Set<String> stopWords = new HashSet<String>();
	ArrayList<String> all_words = new ArrayList<String>();
	HashMap<String, Integer> fileMap;
	HashMap<Integer, String> fileMap1;
	HashMap<Integer, Float> rank = new HashMap<Integer, Float>();

	public GraphAdj(int number_of_vertices) {
		try {
		
		
		

		File file = new File("story.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		int lineNo = 1;
		while (true) {
			Map<Integer, String> value = new HashMap<Integer, String>();
			String line;
			
				line = br.readLine();
			
			
			if (line == null) {
				break;
			}
			value.put(lineNo, line);
			
			lineNo ++;
		
		}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}
	
	
	public void createGraph(){
		try {
			
		File file = new File("story.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		int lineNo = 0;
		
	
		float rank_val = (float)1 / size;
		
		
		while (true) {
			Node key_val1 = new Node() ;
			Node key_val2 = new Node() ;
			Set<Object> value;
			String line;
			
			line = br.readLine();
			if (line == null) {
				break;
			}
			value = lineTokenizer(line);
		
			key_val1.rank = rank_val;
			
			key_val1.values = value;
			adj_List3.put(lineNo, key_val1);
			
		
			
			
			Iterator<Object> it = value.iterator();
			
          while(it.hasNext()){
        	  String sttr = (String) it.next();
        	 
               
            
        	  if(!adj_List3.containsKey(sttr)){
        		  Set<Object> set = new HashSet<Object>();
                  set.add(lineNo);
                  key_val2.rank = rank_val;
                  key_val2.values = set;
                  adj_List3.put(sttr, key_val2);
        		 
        		
        		  Iterator<Entry<Object, Node>> it21 =  adj_List3.entrySet().iterator();
        		
        	  }
        	  else {
        		  
        		  Node upd =  adj_List3.get(sttr);
        		  adj_List3.remove(sttr);
        		  Node key_val3;
        		  upd.values.add(lineNo);
        		  
        		  adj_List3.put(sttr, upd);
        		  
        		  Iterator<Entry<Object, Node>> it2 =  adj_List3.entrySet().iterator();
        		 
        	  }
        	  
        	  
        	  
				
			}
          lineNo++;
          value = null;
		
		}
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public HashMap<Integer, Float> pageRank() {

		for (int i = 1; i <= 50; i++) {
			step();
			
		}
		Map<Object, Node> sortedMap = sortByValue(adj_List3);
		Iterator<Entry<Object, Node>> it233 =  sortedMap.entrySet().iterator();
		
		
		
		int count1 =0,count2 =0;
		HashMap<Integer, Object>  res_map1 = new HashMap<Integer, Object>();
		
		
		  while(it233.hasNext()){
	 Map.Entry pair12 = (Map.Entry) it233.next();
		  
		  Node node = (Node) pair12.getValue();
		  if(pair12.getKey() instanceof String && count1 < 10){
			  
			  count1++;
		 System.out.println("Top10 Words is : "+pair12.getKey() );
		 System.out.println("");
		 
		  }
		  if(pair12.getKey() instanceof Integer && count2 < 10){
			  count2++;
			  res_map1.put((Integer) pair12.getKey(), fileMap1.get(pair12.getKey()));
		 
		 
		  }
		  }
		  
		  Map<Integer, Object> res_map3 = new TreeMap<Integer, Object>(res_map1);
		  Iterator<Entry<Integer, Object>> it =  res_map3.entrySet().iterator();
		  while(it.hasNext()){
				 Map.Entry pair12 = (Map.Entry) it.next();
				 System.out.println("Top10 Sentences Number is : "+pair12.getKey()+"  "+fileMap1.get(pair12.getKey()));
				 System.out.println("");
				 
		  }
		  
		  
		return rank;
	}
	
	private static Map<Object, Node> sortByValue(Map<Object, Node> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<Object, Node>> list =
                new LinkedList<Map.Entry<Object, Node>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<Object, Node>>() {
            public int compare(Map.Entry<Object, Node> o1,
                               Map.Entry<Object, Node> o2) {
            	return (int) (o2.getValue().rank - o1.getValue().rank); 
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Object, Node> sortedMap = new LinkedHashMap<Object, Node>();
        for (Map.Entry<Object, Node> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
    return sortedMap;    
	}

	public void step() {

		float dampFactor = (float) 0.85;
		float constant = (float) (1 - dampFactor) / size;
		Object obj1 = null;
		 float val = 0;
			Iterator<Entry<Object, Node>> it =  adj_List3.entrySet().iterator();
			  while(it.hasNext()){
				 
		 Map.Entry pair = (Map.Entry) it.next();
		 	  obj1 = pair.getKey();
		       
			  Node node = (Node) pair.getValue();
			  float rank_val = node.rank;
			  Iterator<Object> setIt = node.values.iterator();
			  val = rank_val;
			  while(setIt.hasNext()){
				  Object obj =setIt.next();
				 val +=  (float) adj_List3.get(obj).rank / adj_List3.get(obj).values.size();
			  }
			  
			 
			val *= dampFactor;
			val += constant;
			 adj_List3.get(obj1).rank = val;
			
			  }
			  
		

	}

	public void make_stopwords(String fname) {
		try {
			Scanner input = new Scanner(new File(fname));
			while (input.hasNext()) {
				stopWords.add((String) input.next());
			}
		} catch (Exception e) {
			System.out.println(" " + e);
		}

	}

	public HashMap<String, Integer> readFile(File file) throws IOException {

		fileMap = new HashMap<String, Integer>();
		fileMap1 = new HashMap<Integer, String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        int lineno = 0;
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			fileMap = pTokenizer(line, fileMap);
			fileMap1.put(lineno, line);
			lineno ++;
			
		}
		size = fileMap.size();
		return fileMap;

	}
	
	public Set<Object> lineTokenizer(String line){
		
		Set<Object> strings = new HashSet<Object>() ;
		
		String str1;
		String delim = "~`^=_{}?,.&!'[ ]:;-\"( )%&@#$/";
		StringTokenizer tok = new StringTokenizer(line, delim);
		int count = tok.countTokens();
		
		for (int j = 0; j < count; j++) {
			str1 = tok.nextToken().toLowerCase();
			
			if (!stopWords.contains(str1) && str1.length() != 1) {
				
				if (!strings.contains(str1)) {
					strings.add(str1);
					
				} 

			}
		}
		return strings;
		
		
	}
	

	public HashMap<String, Integer> pTokenizer(String str, HashMap<String, Integer> fileMap) {

		String delim = "~`^=_{}?,.&!'[ ]:;-\"( )%&@#$/";
		String str1;

		StringTokenizer tok = new StringTokenizer(str, delim);
		int count = tok.countTokens();

		int validWords = 0;
		

		for (int j = 0; j < count; j++) {
			str1 = tok.nextToken().toLowerCase();
			
			if (!stopWords.contains(str1)) {
				validWords++;

				all_words.add(str1);
				Integer weight = 1;

				if (fileMap.containsKey(str1)) {

					int freq = fileMap.get(str1);
					fileMap.remove(str1);

					fileMap.put(str1, freq + weight);

				} else {
					fileMap.put(str1, weight);
				}

			}
		}
		t_words = t_words + validWords;
		
		return fileMap;

	}

}

public class pageRank {

	public static void main(String arg[]) {
		
		
		 try {
			GraphAdj ga = new GraphAdj(11);

			String stopWordFile = "stops.txt";
			File file = new File("story.txt");
			ga.make_stopwords(stopWordFile);

			HashMap<String, Integer> filemap = ga.readFile(file);
            ga.createGraph();
            
            HashMap<Integer, Float> rank = ga.pageRank();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
