import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main_BOJ_4485_녹색옷을입은애가젤다지_G4_수업 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for( int testCase = 1; ; testCase++) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;	//	보초법
			int[][] m = new int [N][N];
			int[][] visited = new int[N][N];
			for(int i= 0; i<m.length; i++) {
				String str = br.readLine();
				for(int j=0, index=0; j<m.length; j++, index+=2) {
					m[i][j] = str.charAt(index) -'0';
				}
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
						
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			
			// {r,c,(0,0)~(r,c)의 현재까지거리}
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2]-o2[2];
				}
			}); 
			visited[0][0] = m[0][0];
			q.add(new int[] {0,0, visited[0][0]});
			
			while(q.size()>0) {
				int[] data = q.poll();
				int r = data[0];
				int c = data[1];
				int cost = data[2]; // 큐에 삽입당시의 (0,0)~(r,c)의 거리
				if(visited[r][c] < cost) { // 가지치기 이미 더 작은 값으로 업데이트 된 경우
					continue;
				}
				
				
//				if(r==N-1 && c==N-1) break;	 종료하면 안됨. 빙 돌아서 온 것이 더 저렴할 수 있음.
//				핵심은 거리가 아니라 비용이 최소로 드는 것이다.
				for(int i=0; i<dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(0<=nr && nr<N && 0<=nc && nc<N && visited[nr][nc] > cost+m[nr][nc]) {
						visited[nr][nc] = cost+m[nr][nc];
						q.add(new int[] {nr, nc, cost+m[nr][nc]});
					}
				}
				
			}
			
			sb.append("Problem ").append(testCase).append(": ").append(visited[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
