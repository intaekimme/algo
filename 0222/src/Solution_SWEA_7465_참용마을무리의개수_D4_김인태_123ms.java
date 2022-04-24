import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 인접행렬을 bfs로 푸는 문제인줄 알았는데
 * union-find 문제였다.
 * @author kit938639
 *
 */


public class Solution_SWEA_7465_참용마을무리의개수_D4_김인태_123ms {
	
	//	단위집합 생성
	public static int[] makeSet(int N) {
		int[] parents = new int[N];
		//	자신의 부모노드를 자신의 값으로 세팅
		for(int i=1;i<N;i++) {
			parents[i] = i;
		}
		return parents;
	}
	
	// a의 집합찾기 : a의 대표자 찾기
	public static int findSet(int[] parents, int a) {
		if(a==parents[a])	return a;
		return parents[a] = findSet(parents, parents[a]);	//	path compression
	}
	
	public static boolean union(int[] parents, int a, int b) {
		int aRoot = findSet(parents, a);
		int bRoot = findSet(parents, b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] parents = makeSet(N+1);
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				union(parents, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for(int i=1;i<=N;i++) {
				if(parents[i]==i) ans++;	
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		
	}	//	end of main

}	// end of class




/* 인접행렬에 bfs 적용해 푸는 문제인줄 알았는데 union find 문제였다.
 * public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				map[i][j] = map[j][i] = 1;
			}
			
			for(int i=0;i<map.length;i++) {
				System.out.println(Arrays.toString(map[i]));
			}	//	정상출력 확인
			
			sb.append("#").append(tc).append(" ").append(bfs(N, map)).append("\n");
			
		}
		
		System.out.println(sb);
		
	}	//	end of main
	
	//	인접행렬로 탐색
	public static int bfs(int N, int[][] adjMatrix) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		int cnt=0;
		int p=N;
		boolean isCount;
		boolean isAlone;
		
		for(int r=1;r<=N;r++) {	//	각 사람마다 모두 확인 , 일반적인 bfs로 풀경우 연결이 안되어 있으면 탐색 중단됨.
			queue.offer(r);
			visited[r] = true;
			isCount=false;	//	무리로 확인될 때만 카운트
			while(!queue.isEmpty()) {
				int current = queue.poll();
				
				//current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
				for(int j=1; j<N; j++) {
					if(!visited[j] && adjMatrix[current][j]!=0){
						queue.offer(j);
						visited[j] = true;
						isCount=true;	//	무리가 있기에 카운트
						p--;
					}
				}
				
//				if(!isCount) p--;
			}
//			if(isCount)	{
//				cnt++;	//	무리
//			}
			
		}
		return --p;
	}
 * 
 */
