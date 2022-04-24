import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14890_경사로_김인태 {

	private static int[][] rmap;
	private static int[][] map;
	private static int N, L, cnt;
	private static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		rmap = new int[N][N];
		check = new boolean[N];
		
		for(int i = 0;i < N; i++) {
			String s = br.readLine();
			for(int j = 0, index = 0; j < N; j++, index+=2) {
				map[i][j] = s.charAt(index);
			}
		}
		
		for(int i=0; i < N; i++) {
			
		}
		System.out.println(cnt);
	}


	
}
