import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3036_링_S4 {

	private static int N;
	private static int[] arr;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder();
		int standard = arr[0];
		for(int i=1; i<N; i++) {
			int divisor = 0;
			if(standard > arr[i]) divisor = gcd(standard, arr[i]);
			else divisor = gcd(arr[i], standard);
			sb.append(standard/divisor).append("/").append(arr[i]/divisor).append("\n");
		}
		
		System.out.println(sb);
	}	//	end of main
	
	public static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}

}
