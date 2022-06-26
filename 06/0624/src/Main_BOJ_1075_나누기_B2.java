import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1075_나누기_B2 {

	private static int N, F;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		F = Integer.parseInt(br.readLine());
		
		int min_N = N - N % 100;
		int max_N = min_N + 100;
		
		int res = 0;
		for(int i=min_N; i<=max_N; i++) {
			if(i % F == 0) {
				res = i % 100;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(res < 10) {
			sb.append(0).append(res);
		}else sb.append(res);
		
		System.out.println(sb);
	}

}
