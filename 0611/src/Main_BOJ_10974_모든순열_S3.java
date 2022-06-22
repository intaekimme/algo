import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_10974_모든순열_S3 {

	private static int N;
	private static int[] arr, ans;
	private static boolean[] visited;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		ans = new int[N];
		for(int i=1; i<=N; i++) {
			arr[i-1] = i;
		}
		sb = new StringBuilder();
		
		func(0);
		System.out.println(sb);
	}

	public static void func(int cnt) {
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[cnt] = arr[i];
				func(cnt+1);
				visited[i] = false;				
			}
		}
	}
}
