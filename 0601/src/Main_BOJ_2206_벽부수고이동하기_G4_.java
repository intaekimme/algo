import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일반적인 BFS라고 생각하고 풀었다가 틀렸다.
 * 반례를 통해서 보니 내 풀이는 벽을 부순 경우가 없는 상태에서 벽을 처음 발견하는 경우
 * 무조건 벽을 부수고 간다.
 * 이 경우 벽을 부수지 않고 해당 위치를 지나간 경우가
 * 벽을 부수고 지나간 경우보다 더 적은 이동거리를 가질 수 있기 때문에
 * 위 풀이는 틀리다.
 * @author kit938639
 *
 */

public class Main_BOJ_2206_벽부수고이동하기_G4_ {

	private static int N, M;
	private static char[][] map;

	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		Queue<int[]> que = new LinkedList<int[]>();
		visited = new boolean[N][M];
		que.add(new int[] {0,0,1});
		visited[0][0] = true;
		
		int block = 0;
		int ans = 0;
		int x = 0;
		int y = 0;
		while(!que.isEmpty()) {
			int[] coord = que.poll();
			x = coord[0];
			y = coord[1];
			int dist = coord[2];
			
			if(x==N-1 && y==M-1) {
				ans = dist;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(!visited[nx][ny] && 
					block + map[nx][ny] - '0' <= 1) {
					visited[nx][ny] = true;
					block = block + map[nx][ny] -'0';
					que.add(new int[] {nx, ny, dist+1});
				}
			}
		}
		
		if(x==N-1 && y==M-1) {
			System.out.println(ans);			
		}else {
			System.out.println(-1);
		}
		
	}

}

/*
 * 반례 정답 : 29, 내 출력 : -1
 * 8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100
*/
