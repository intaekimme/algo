import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또_S2_88ms {

	private static int N;
	private static int[] arr, input;
	private static boolean[] visited;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = null;
		
		arr = new int[6];
		while(true) {
			Arrays.fill(arr, 0);
			String tc = br.readLine();
			if(tc.charAt(0) == '0') break;
			
			st = new StringTokenizer(tc);
			N = Integer.parseInt(st.nextToken());
			
			input = new int[N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			func(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void func(int start, int cnt) {
		if(cnt==6) {
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					sb.append(input[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		for(int i = start; i<N; i++) {
			visited[i] = true;
			func(i+1, cnt+1);
			visited[i] = false;
		}
		
	}

}