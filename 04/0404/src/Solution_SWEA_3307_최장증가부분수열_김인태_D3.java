
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3307_최장증가부분수열_김인태_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[n];
			int[] lis = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			int max = 0;
			for(int i=0; i<n; i++) {	//	모든 원소에 대해 자신을 끝으로 하는 LIS 길이 계산
				lis[i] = 1;	// 자신 혼자 LIS 구성할 때의 길이 1로 초기화
				for(int j=0; j<i; j++) { // 첫원소부터 i원소 직전까지 비교
					if(arr[j]<arr[i] && lis[i] < lis[j]+1) {	//	arr[j]<arr[i]: 증가수열의 모습
						lis[i] = lis[j]+1;
					}
				}
				if(max<lis[i]) max = lis[i];
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
