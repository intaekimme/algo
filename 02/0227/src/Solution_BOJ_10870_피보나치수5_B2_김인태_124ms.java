import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_10870_피보나치수5_B2_김인태_124ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(N));
	}
	
	public static int fibo(int n) {
		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		else {
			return fibo(n-2) + fibo(n-1);
		}
	}

}
