import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서쪽 N
 * 동쪽 M (0 < N ≤ M < 30)
 * 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개)만큼 지으면 최대
 * 다리끼리는 서로 겹쳐질 수 없다 = 이전 선택의 다음것부터만 선택할 수 있다.
 * @author kit938639
 * 
 * 조합코드 시간초과
 *
 */

public class Solution_BOJ_1010_다리놓기_S5_김인태_128ms {

	
	static int ans2=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			comb2(0, 0, N, M);
//			sb.append(ans2).append("\n");
//			ans2=0;
			
			sb.append(comb(M,N)).append("\n");
		}	//	end of tc
				
		System.out.println(sb);
	}	//	end of main
	
	
	public static int comb(int M, int N) {
		int ans=1;
		for(int i=1;i<=N;i++) {
			ans = ans*(M-i+1)/i;	//	이전 결과 재활용 = 메모이제이
		}
		return ans;
	}
	
	
	/**
	 * MCN 조합 수 계산
	 * @param cnt : N
	 * @param start : 0
	 */
	public static void comb2(int cnt, int start, int N, int M) {
		if(cnt==N) {
			ans2++;
			return;
		}
		for(int i=start; i<M; i++) {
			comb2(cnt+1, i+1, N,M);
		}
	}	//	end of comb
	
}	//	end of class
