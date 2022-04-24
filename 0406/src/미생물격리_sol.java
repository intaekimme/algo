import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 미생물격리_sol {
	static int N,M,K;
	static micro map[][];
	static int[] dr = {0, -1, 1, 0, 0};	// 0, 상, 하, 좌, 우
	static int[] dc = {0, 0, 0, -1, 1};	//	0, 1, 2, 3, 4
	static PriorityQueue<micro> pq;
	
	static class micro implements Comparable<micro>{
		int r, c, cnt, dir;

		public micro(int r, int c, int num, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(micro o) {
			return -(this.cnt - o.cnt); // 내림차순, 최대힙
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new micro[N][N];
			pq = new PriorityQueue<micro>();
			

			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());				
				int c = Integer.parseInt(st.nextToken());				
				int cnt = Integer.parseInt(st.nextToken());				
				int dir = Integer.parseInt(st.nextToken());	
				
				
				pq.add(new micro(r,c,cnt,dir));
			}
			
			sb.append("#").append(tc).append(" ").append(move()).append("\n");
		}	//	end of for
		System.out.println(sb);
		
	}	// end of main

	private static int move() {	// 주어진 M 시간 동안 미생물 이동 처리	
		int time = M, nr, nc, remainCnt=0;
		
		while(time-- > 0) {
			// 군집리스트에서 군집들을 하나씩 모두 꺼내어 처리
			micro m;
			while(!pq.isEmpty()) {
				m = pq.poll();
				
				nr = m.r += dr[m.dir];
				nc = m.c += dc[m.dir];
				
				if(nr==0 || nr == N-1 || nc==0 || nc == N-1) { // 가장자리 약품이 칠해진 셀
					if((m.cnt = m.cnt/2) == 0) continue; // 해당 군집은 크기가 0으로 죽어허빔...
				
					// 방향 반대로 턴, 소멸되지 않은 것들은 위 if문을 통과하고 여기를 거침
					if(m.dir % 2 == 1) m.dir++;
					else m.dir--;
				}
				
				if(map[nr][nc] == null) { // 해당 자리에 처음 이동한 미생물 군집이면 그자리에 세팅
					map[nr][nc] = m;
				}else { // 해당 자리에 처음 이동한 미생물 군집이 아니면 기존 군집에 합치기
					map[nr][nc].cnt += m.cnt;
				}
				
					
			} // end of inner while
			
			remainCnt = reset();
		}
		
		return remainCnt;
	}
	
	
	private static int reset() { // 매 시간마다 필요한 정리, 초기화 작업
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != null) {
					pq.add(map[i][j]);
					total += map[i][j].cnt;
					map[i][j] = null;
				}
			}
		}
		return total;
		
	}
	
	
}