import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) continue;
	    	tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	public static void main(String args[]){
		int[] nums = {1,2,2};
		subsets ss = new subsets();
		
		
		for( List num: ss.subsets(nums)){
			
			System.out.println(num);
		}
		
		List<Integer> ls =  new ArrayList<Integer>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.remove(2);
        for( int num :ls){
			
			System.out.println(num);
		}
		
	}
}
