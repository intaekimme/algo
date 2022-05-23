import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1789_수들의합_S5 {

	private static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		long n = 1;
		long res = 0;
		while(true) {
			if(N - n*(n+1)/2 < n) {
				res = n;
				break;
			}else {
				n++;
			}
		}
		System.out.println(res);
	}

}
