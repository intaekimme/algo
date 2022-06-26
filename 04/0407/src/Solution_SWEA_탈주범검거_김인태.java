import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_탈주범검거_김인태 {

	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			 N = Integer.parseInt(st.nextToken());
			 M = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][][] map = new int[N][M][6]; // 종류, 위, 아래, 왼쪽, 오른쪽, 시간
			boolean[][] visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					int val = Integer.parseInt(st.nextToken());
					map[i][j][0]=val;
					switch (val) {
					case 0:
						break;
					case 1:
						map[i][j][1]=1; // up
						map[i][j][2]=1; // down
						map[i][j][3]=1; // left
						map[i][j][4]=1; // right
						break;
					case 2:
						map[i][j][1]=1; // up
						map[i][j][2]=1; // down
						break;
					case 3:
						map[i][j][3]=1; // left
						map[i][j][4]=1; // right
						break;
					case 4:
						map[i][j][1]=1; // up
						map[i][j][4]=1; // right
						break;
					case 5:
						map[i][j][2]=1; // down
						map[i][j][4]=1; // right
						break;
					case 6:
						map[i][j][2]=1; // down
						map[i][j][3]=1; // left
						break;
					case 7:
						map[i][j][1]=1; // up
						map[i][j][3]=1; // left
						break;
					}
				}
			}	//	입력완료
			
			int cnt = 1;	//	출력할 정답
			
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {startX, startY});
			visited[startX][startY]=true;
			int time=0;
			
			while(!q.isEmpty()) {
				int size = q.size();
				if(++time >= L) break;
				
				for(int i=0; i<size; i++) {
					int x = q.peek()[0];
					int y = q.peek()[1];
					q.poll();
					
					for(int j=1; j<=4; j++) {
						int[] coord = check(j, x, y, visited, map);
						if(coord == null) continue;
						cnt++;
						visited[coord[0]][coord[1]] = true;
						q.offer(new int[] {coord[0], coord[1]});
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static int[] check(int i, int x, int y, boolean[][] visited, int[][][] map) {
		int nx, ny;
		switch (i) {
		case 1: // 위
			nx = x-1;
			ny = y;
			if(nx<0 || nx>=N || ny<0 || ny>=M) break;
			if(visited[nx][ny]) break;
			if(map[nx][ny][2]!=1) break; // 아래쪽과 연결
			if(map[x][y][1]==1) return new int[] {nx,ny};
		case 2:	// 아래
			nx = x+1;
			ny = y;
			if(nx<0 || nx>=N || ny<0 || ny>=M) break;
			if(visited[nx][ny]) break;
			if(map[nx][ny][1]!=1) break; // 위쪽과 연결 
			if(map[x][y][2]==1) return new int[] {nx,ny};
		case 3: // 왼쪽
			nx = x;
			ny = y-1;
			if(nx<0 || nx>=N || ny<0 || ny>=M) break;
			if(visited[nx][ny]) break;
			if(map[nx][ny][4]!=1) break; // 오른쪽과 연결 
			if(map[x][y][3]==1) return new int[] {nx,ny};
		case 4: // 오른쪽
			nx = x;
			ny = y+1;
			if(nx<0 || nx>=N || ny<0 || ny>=M) break;
			if(visited[nx][ny]) break;
			if(map[nx][ny][3]!=1) break; // 왼쪽과 연결 
			if(map[x][y][4]==1) return new int[] {nx,ny};

		}
		return null;
	}

}
