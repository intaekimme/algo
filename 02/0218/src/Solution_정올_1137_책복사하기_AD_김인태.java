import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_정올_1137_책복사하기_AD_김인태 {
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());		//	책의 권수	= 책 배열 길이
			int k = Integer.parseInt(st.nextToken());		//	사람 수
			
			int avg=0;		//	한 사람당 맡을 책 쪽수 평균
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[m];		//	책당 쪽수
			
			
			for(int i=0;i<m;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				avg+=arr[i];
			}
			
//			Arrays.sort(arr);		//	오름차순 정렬
			avg/=k;
//			System.out.println(Arrays.toString(arr)+","+avg);
			
			sol(0, avg, 0, arr, m, k);
		}
		System.out.println(sb);
	}	//	end of main
	
	/**
	 * 
	 * @param start		점프 시작할 인덱스
	 * @param jump		뛸 배열
	 * @param cnt		뛴 횟수
	 * @param arr		책 배열
	 * @param people	사람 수
	 */
	
	public static void sol(int start, int jump, int cnt, int[] arr, int arrSize, int people) {
		if(start >= arrSize-1) {
			sb.append("\n");
			return;
		}
		int sum=0;
		int idx=start;
		while(sum<=jump && idx<arrSize) {
			sum+=arr[idx++];
		}
		cnt++;
		if(cnt<people) {
			sum-=arr[--idx];
			for(int i=start; i<idx; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("/ ");	
		}else {
			for(int i=start; i<idx; i++) {
				sb.append(arr[i]).append(" ");
			}			
		}
		
		sol(idx, jump, cnt, arr, arrSize, people);
	}

}
