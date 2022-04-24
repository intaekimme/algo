import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리_S1_김인태_수업 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// N(2 <= N <= 1,000)
		int[][] a = new int[N][3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			a[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int memo[][] = new int[N][3];
		memo[0] = a[0];
		for(int i=1;i<memo.length;i++) {
			memo[i][0] = (memo[i-1][1] < memo[i-1][2]? memo[i-1][1] : memo[i-1][2]) + a[i][0];
			memo[i][1] = (memo[i-1][0] < memo[i-1][2]? memo[i-1][0] : memo[i-1][2]) + a[i][1];
			memo[i][2] = (memo[i-1][0] < memo[i-1][1]? memo[i-1][0] : memo[i-1][1]) + a[i][2];
		}
		
//		원본배열만 사용시 즉, 재사용이 없을 때.
//		for(int i=1;i<a.length;i++) {
//			a[i][0] = (a[i-1][1] < a[i-1][2]? a[i-1][1] : a[i-1][2]) + a[i][0];
//			a[i][1] = (a[i-1][0] < a[i-1][2]? a[i-1][0] : a[i-1][2]) + a[i][1];
//			a[i][2] = (a[i-1][0] < a[i-1][1]? a[i-1][0] : a[i-1][1]) + a[i][2];
//		}
		
		
//		for (int i = 0; i < memo.length; i++) {
//			System.out.println(Arrays.toString(memo[i]));
//		}
		
		int min = memo[N-1][0];
		if(min > memo[N-1][1])	min = memo[N-1][1];
		if(min > memo[N-1][2])	min = memo[N-1][2];
		System.out.println(min);
	}

}
