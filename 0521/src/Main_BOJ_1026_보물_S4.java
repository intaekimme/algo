import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_1026_보물_S4 {

	private static int N;
	private static int[] A;
	private static Integer[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N+1];
		A[0] = -1;
		B = new Integer[N+1];
		B[0] = 101;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1 - o2);
			}
		});
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			ans += A[i]*B[i];
		}
		System.out.println(ans);
	}

}
