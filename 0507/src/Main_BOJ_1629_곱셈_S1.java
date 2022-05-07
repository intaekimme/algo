import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1629_곱셈_S1 {

	private static int A, B, C;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(power(B));
	}

	public static long power(int b) {
		if(b==1) 
			return A%C;
		
		long val = power(b/2) % C;
		if (b % 2 == 1) {
			return ((val * val % C) * A) % C;
		} else {
			return (val * val) % C;
		}
	}
	
}
