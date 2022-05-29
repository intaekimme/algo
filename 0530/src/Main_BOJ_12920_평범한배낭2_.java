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
		
//		ArrayList<int[]> D = new ArrayList<int[]>();
		
		ArrayList<Integer> wx = new ArrayList<Integer>();
		ArrayList<Integer> vx = new ArrayList<Integer>();
		wx.add(0, 0);
		vx.add(0, 0);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
//			핵심 알고리즘, 질문 참조
			for(int j=1; K>0; j<<=1) {
				int ix = Math.min(j, K);
//				D.add(new int[] {V * ix, C * ix});
				wx.add(V * ix);
				vx.add(C * ix);
				K -= ix;
			}
		}
//		for(int i=0; i<D.size(); i++) {
//			int[] tmp = D.get(i);
//			for(int j=0; j<tmp.length; j++) {
//				System.out.print(tmp[j]+ " ");
//			}
//			System.out.println();
//		}
		Integer[] w = new Integer[wx.size()];
		Integer[] v = new Integer[vx.size()];
		wx.toArray(w);
		vx.toArray(v);
		
//		for (Integer integer : w) {
//			System.out.print(integer+" ");
//		}
//		System.out.println();
//		for (Integer integer : v) {
//			System.out.print(integer+" ");
//		}
		
//		System.out.println("\n-------------------");
//		BOJ_12865_평범한배낭_G5 알고리즘을 문제에 맞게 변형
		dp = new int[w.length+1][M+1];
		for(int i=1; i<w.length; i++) {
			for(int j=1; j<=M; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
//		for(int i=0; i<w.length; i++) {
//			for(int j=0; j<=M; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[w.length-1][M]);
	}

}
