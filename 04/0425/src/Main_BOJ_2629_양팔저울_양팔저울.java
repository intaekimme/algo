import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 추의 무게 500g이하
 * 추의 갯수 30개, 추로 표현 가능한 최대 무게는 15000
 * @author kit938639
 *
 */

public class Main_BOJ_2629_양팔저울_양팔저울 {

	private static int N;
	private static int[] chu;
	private static int[] brr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		chu = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			chu[i]= Integer.parseInt(st.nextToken()); 
		}
		
		boolean[][] memo = new boolean[N][30*500+1];
		memo[0][0] = true;
		memo[0][chu[0]] = true;
		for(int i=1; i<N; i++) {
			for(int j=0; j<memo[i].length; j++) {
				if(!memo[i-1][j]) continue;
				memo[i][j] = true;
				int a = j + chu[i];
				int b = j - chu[i];
				if(b<0) b = -b;
				memo[i][a] = true;
				memo[i][b] = true;
			}
		}
				
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(st.nextToken());
			sb.append(x <= 15000 && memo[N-1][x] ? "Y " : "N ");
		}
		System.out.println(sb.toString());
		
		
	}

}
