import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1043_거짓말 {

	private static int N, M, truth;
	static boolean[] T;
	static int[][] party;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		truth = Integer.parseInt(st.nextToken());
		
		if(truth==0) {
			System.out.println(M);
			System.exit(0);
		}
		else {
			T = new boolean[N+1];
			for(int i=0; i<truth; i++) {
				T[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		party = new int[M][];
		map = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			party[i] = new int[p+1];
			party[i][0] = p;
			for(int j=1; j<=p; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
				map[party[i][j-1]][party[i][j]] = map[party[i][j]][party[i][j-1]] = true;
			}
		}
		
		
//		for(int i=0; i<map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));			
//		}
		
		 	for (int i = 1; i <= N; i++) {
		 		if (T[i])
		 			dfs(i);		 		
		 	}

	        int cnt = 0;
	        for (int i = 0; i < M; i++) {
	        	if (!T[party[i][0]])
	        		cnt++;	        	
	        }

	        System.out.println(cnt);
	}

	
	static void dfs(int n) {
        for (int i = 1; i <= N; i++) {
            if (map[n][i] && !T[i]) {
                T[i] = true;
                dfs(i);
            }
        }
    }
}
