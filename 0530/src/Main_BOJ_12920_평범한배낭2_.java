import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_12920_평범한배낭2_ {

	private static int N, M, V, C, K;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Integer> wx = new ArrayList<Integer>();
		ArrayList<Integer> vx = new ArrayList<Integer>();
		wx.add(0, 0);
		vx.add(0, 0);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
//			V : 무게, C : 가치, K : 물건 갯수
			V = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
//			핵심 알고리즘, 질문 참조
//			k개를 1,2,4,8개로... 부분 부분으로 나눈다.
//			예를들면 k=7이면 1,2,4로 나눈다.
			for(int j=1; K>0; j<<=1) {
				int ix = Math.min(j, K);
				wx.add(V * ix);
				vx.add(C * ix);
				K -= ix;
			}
		}

		Integer[] w = new Integer[wx.size()];
		Integer[] v = new Integer[vx.size()];
		wx.toArray(w);
		vx.toArray(v);

		
//		BOJ_12865_평범한배낭_G5 knapsack 알고리즘 적용
//		dp 배열 크기 및 반목문 인자 문제에 맞게 수정 
		dp = new int[w.length+1][M+1];
		for(int i=1; i<w.length; i++) {
			for(int j=1; j<=M; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				}
			}
		}

		System.out.println(dp[w.length-1][M]);
	}

}
