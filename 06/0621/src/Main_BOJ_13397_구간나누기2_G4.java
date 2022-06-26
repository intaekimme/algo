import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13397_구간나누기2_G4 {

	private static final int INF = 100001;
	private static int N, M, lo=INF, hi=-INF;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			lo = Math.min(lo, arr[i]);
			hi = Math.max(hi, arr[i]);
		}
		hi = hi - lo;
		lo = 0;
		
		while(lo <= hi) {
			int mid = (lo+hi) >> 1;
			if(fn(mid)) hi = mid-1;
			else lo = mid+1;
		}
		System.out.println(lo);
	}
	
	public static boolean fn(int mid) {
		int cnt = 1;
		int minVal = INF;
		int maxVal = -INF;
		
		for(int i=0; i<N; i++) {
			minVal = Math.min(minVal, arr[i]);
			maxVal = Math.max(maxVal, arr[i]);
			if(maxVal - minVal > mid) {
				minVal = maxVal = arr[i];
				cnt++;
			}
		}
		return cnt <= M;
	}

}
