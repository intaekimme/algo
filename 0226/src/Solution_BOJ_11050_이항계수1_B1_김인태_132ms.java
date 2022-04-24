import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_11050_이항계수1_B1_김인태_132ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int ans=0;
		ans = fact(n)/(fact(k)*fact(n-k));
		
		ans%=10007;
		
		System.out.println(ans);
		
	}
	public static int fact(int n) {
		if(n==0)
			return 1;
		else
			return n*fact(n-1);
	}

}
