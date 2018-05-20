import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class perfect_Squares {
	int numSquares(int n) 
    {
        if (n <= 0)
        {
            return 0;
        }
        
        // cntPerfectSquares[i] = the least number of perfect square numbers 
        // which sum to i. Note that cntPerfectSquares[0] is 0.
        int[] cntPerfectSquares = new int[n+1];
       // vector<int> cntPerfectSquares(n + 1, INT_MAX);
        Arrays.fill(cntPerfectSquares, Integer.MAX_VALUE);
        cntPerfectSquares[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            // For each i, it must be the sum of some number (i - j*j) and 
            // a perfect square number (j*j).
            for (int j = 1; j*j <= i; j++)
            {
                cntPerfectSquares[i] = Math.min(cntPerfectSquares[i], cntPerfectSquares[i - j*j] + 1);
            }
        }
        
        return cntPerfectSquares[n];
    }
	
	   public static void main(String arg[]){
	    	perfect_Squares ps = new perfect_Squares();
	    	
	    	//for(int i = 0; i < 12; i++){
	    	long startTime = System.currentTimeMillis();
	    	
	    	System.out.println(ps.numSquares(1156474));
	    
	    	long estimatedTime = System.currentTimeMillis() - startTime;
	    	System.out.println(estimatedTime);
	    	//}
	    	
	    }
}
