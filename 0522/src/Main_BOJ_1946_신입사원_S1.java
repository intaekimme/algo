import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1946_신입사원_S1 {

	private static int N;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, (int[] o1, int []o2) -> o1[0] - o2[0]);
//			for(int i=0;i<N; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			// 시간 초과
			int cnt = 0;
			for(int i=N-1; i>0; i--) {
				if(arr[i][1] == 1) continue;
				for(int j=i-1; j>=0; j--) {
					if(arr[i][1]>arr[j][1]) {
						cnt++;
						break;
					}
				}
			}
			
			System.out.println(N-cnt);
		}
		
		
	}

}
