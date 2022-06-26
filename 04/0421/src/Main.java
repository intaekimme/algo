import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, result;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr  = new int[N];
		result  = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int past = -1;
		for(int i=0; i<arr.length; i++) {
			int now = arr[i];
			if(visit[i] || past == now) continue;
			else {
				past = now;
				visit[i] = true;
				result[depth] = arr[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
	
}
