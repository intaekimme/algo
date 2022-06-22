import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BOJ_1253_좋다_G4 {

	private static int N, lo, hi;
	private static int[] arr;
	private static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		map = new HashMap<Integer, Integer>(N);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			map.put(arr[i], arr[i]);
		}
		
		Arrays.sort(arr);
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(fn(arr[i])) cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	public static boolean fn(int val) {
		lo = 0;
		hi = N-1;
		
		while(lo<=hi) {
			int mid = (lo+hi) >> 1;
			int rest = val - arr[mid];
			try {
				int check = map.get(rest);
				if(check == rest) {
					return true;
				}else {
					if(arr[mid] < rest) hi = mid - 1;
					else lo = mid + 1;
				}
			} catch (Exception e) {
				if(arr[mid] < rest) hi = mid - 1;
				else lo = mid + 1;
			}
		}

		return false;
	}

}
