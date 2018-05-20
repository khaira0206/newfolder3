import java.util.HashSet;
import java.util.Set;

public class word_Break {
    public boolean[] wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f;
    }
    public static void main(String arg[]){
    	word_Break wb = new word_Break();
    	String s = "leetcode";
    	Set<String> dict = new HashSet<>();
    	dict.add("l");
        dict.add("eet");
        dict.add("code");
       
    	
    }
}
