
public class Nephew_chalange {

	public static void main(String arg[]){
		int n = 10000000;
		Nephew_chalange np = new Nephew_chalange();
		boolean ans = np.challenge(n);
		
			
			System.out.println("Pass the challenge = " + ans);
		
	}
	
	public boolean challenge(int n){
		
		int temp;
		
		while( n > 1){
			if(n % 2 == 0){
				System.out.println("even = " +n);
				n /=2;
				
				//sleep(3000);
			}
			else{
				System.out.println("odd = "+n);
				n = 3*n + 1;
				
			}
			
		}
		
		return n == 1;
		
		
	}
	
}
