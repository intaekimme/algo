import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14889_스타트와링크 {

	static int[][] map;
	static boolean[] visited;
	static int N, min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = 3000;
		comb(0, 0);
//		System.out.println("answer: "+min);
		System.out.println(min);
		
	}

	private static void comb(int start, int cnt) {
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(visited));
			process();
			return;
		}
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(i+1, cnt+1);
				visited[i] = false;
				
			}
		}
	}

	private static void process() {
		int[] star = new int[N/2];
		int[] link = new int[N/2];
		
		int idx1 = 0;
		int idx2 = 0;
		for(int i=0; i<N; i++) {
			if(visited[i]) star[idx1++] = i;
			else link[idx2++] = i;
		}
		
//		System.out.println(Arrays.toString(star)+", "+Arrays.toString(link));
//		System.out.println();
		
		
		int sum1 = sum(star);
		int sum2 = sum(link);
		
		int val = Math.abs(sum1-sum2);
		if(min > val) {
			min = val;
		}
		
	}

	private static int sum(int[] arr) {
		int sum = 0;
		int size = arr.length;
		for(int i=0; i < size; i++) {
			for(int j=i+1; j < size; j++) {
//				System.out.println(i+", "+j+"/ "+arr[i]+", "+arr[j]+"/ "+map[arr[i]][arr[j]]+", "+map[arr[j]][arr[i]]);
//				System.out.println();
				sum += map[arr[i]][arr[j]] + map[arr[j]][arr[i]];
			}
		}
		
//		System.out.println(sum);
//		System.out.println();
		return sum;
	}

}
