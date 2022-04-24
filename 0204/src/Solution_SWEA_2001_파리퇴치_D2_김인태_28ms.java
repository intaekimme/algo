import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2_김인태_28ms {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		long beforeTime = System.currentTimeMillis();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer nm = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(nm.nextToken());
			int M = Integer.parseInt(nm.nextToken());
			
			//	배열 생성
			int[][] arr = new int[N][N];
			
			for (int j = 0; j < N; j++) {				
				//	배열의 내용 입력받음
//				String[] s = br.readLine().split(" ");		틀린 부
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				
				//	입력받은 내용 배열에 집어넣음
				for (int t = 0; t < N; t++) {
					arr[j][t] = Integer.parseInt(st.nextToken());
				}
			}	// end of for, 
			
			//	결과 계산할 배열 생성
			int result = 0;
			int max = 0;
			for (int j = 0; j <= N-M; j++) {
				for (int k = 0; k <= N-M; k++) {
					for (int m = 0;  m < M; m++) {
						for (int t = 0; t < M; t++) {
							result+=arr[j+m][k+t];
						}
					}
					if(result>max) 
						max = result;
					result = 0;
				}
			}	// end of for, arr
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}	// end of testCase
		System.out.print(sb);
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		System.out.println(secDiffTime);
		
		
	}	// end of main
}	// end of class


//1 3 3 6 7
//8 13 9 12 8
//4 16 11 12 6
//2 4 1 23 2
//9 13 4 7 3
