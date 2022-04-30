import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17404_RGB거리2 {

	private static int N;
	private static int[][] rgb, min;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][N];
		min = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = 1_000_000;
		for(int i=0; i<3; i++) {
			visited[N-1][i]=true;
			
		}
		System.out.println(min);
	}

	private static void go(int x, int y, int sum) {
		
		if(x==N) {
			return;
		}
		
//		if(!visited[x][y]) {
//			min[x][y] = sum + rgb[x][y];
//			visited[x+1][y] = true;
//			for(int i=0; i<3; i++) {
//				if(!visited[x+1][i]) {
//					go(x+1, i, sum);
//					visited[x+1][i] = false;
//					sum-=map[x+1][i];
//				}
//			}
//		}
		
	}

}	//	end of class
