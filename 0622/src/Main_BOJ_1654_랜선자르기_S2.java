import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1654_랜선자르기_S2 {

	private static int K, N;
	private static long lo, hi, mid;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		hi = 0;
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > hi) hi = arr[i];
		}
		
		lo = 0;
		hi++;
		

		while(lo < hi) {
			 mid = (lo+hi)/2;
			
			long cnt = 0;
			for(int i=0; i<K; i++) {
				cnt += arr[i] / mid;
			}
			if(cnt < N) {
				hi = mid;
			}else {
				lo = mid + 1;
			}
		}
		
		System.out.println(lo-1);
		
	}
	
	

}
