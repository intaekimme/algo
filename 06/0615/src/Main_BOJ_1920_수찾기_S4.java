import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1920_수찾기_S4 {

	private static int N;
	private static int[] arr;
	private static int M;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int res = bs(Integer.parseInt(st.nextToken()));
			if(res >= 0) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int bs(int val) {
		int hi = N-1;
		int lo = 0;
		
		while(lo <= hi) {
			int mid = (hi + lo) / 2;
			
			if(val < arr[mid]) {
				hi = mid-1;
			}else if(val > arr[mid]) {
				lo = mid + 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}

}
