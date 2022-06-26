import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일반적인 방문 배열이 아닌 '현재까지의 상태'를 기억하는 방문 배열을 사용해야 하고 그래서 3차원의 방문배열을 사용해야 한다.
 * 
 * 백준 게시판에 등록된 필독에서는 다음과 같이 설명한다.
 * 1. 가중치가 없는 최단 경로는 무조건 BFS입니다. 왜 DFS가 안 될까요? 그 이유는 당연하게도, 
 * 특정 칸에 처음 도달했을 때까지의 경로의 길이가 다른 경로를 통해 도달한 길이보다 짧다는 보장이 전혀 없기 때문입니다. 
 * 아직까지 이 사실을 모르고 계셨다면, 이 문제는 아직 풀기에 너무 어렵습니다. 더 기본적인 BFS 문제들 (10https://www.acmicpc.net/proble... 등) 을 먼저 풀어보세요.
 * 
 * 2. 모든 칸을 전부 0으로 하나씩 바꾸어보고 BFS를 돌리는 것을 반복해서는 통과될 수 없습니다. 대부분의 알고리즘 문제가 그렇듯이, 
 * 풀이를 짜기 전에 반드시 해야 하는 것 중 하나는 시간 복잡도를 생각하는 것입니다. 시간 복잡도 계산, 전혀 어렵지 않습니다. 
 * 벽이 최대 O(NM)개 있는 맵에서, 벽을 하나 부술 때마다 O(NM)개의 칸을 탐색해야 하죠? 그러니 O((NM)^2)입니다. 
 * 이 수는 우리가 대충 1초에 돌 수 있다고 보는 단위인 1억을 10000배나 뛰어넘는 1조입니다. 절대 통과될 수 없을 것입니다.
 * 
 * 3. 칸마다 방문 체크 하나씩만 하는 방법으로는 풀 수 없습니다. 어떤 칸에 도달했을 때 나는 "아직 벽을 부술 수 있는 상태"일 수도 있고, "더 이상 벽을 부술 수 없는 상태"일 수도 있습니다. 
 * 큐에 그 상태를 넣은 것만으로 되는 것이 아닙니다. 당장 이 지점까지 어떻게든 최단으로 오는 길만 구했다고 해서, 그 이후의 여정도 최적으로 만들 수 있는 건 아닙니다. 
 * 구체적인 예시로는 다음과 같은 것들이 있습니다.
 * 
 * 3-1. 현재 칸까지 벽을 안 부수고 최단으로 올 수 있었다고 가정해봅시다. 현재 지점에서 목표 지점까지 가는 데에, 벽을 한 개 부수고 가는 것이 안 부수고 가는 것보다 최적이 나온다고 해봅시다.
 *  그렇다면 지금 내가 벽을 더 부술 수 있는 상태라는 사실을 알고 있어야만 할 것입니다.
 *  
 * 3-2. 벽을 안 부수고도 현재 칸까지 도달이 가능하지만, 벽을 부수고 오는 것이 더 짧다고 가정해봅시다. 현재 지점에서 목표 지점까지 가려면 무조건 벽을 한 개 부숴야만 된다고 해봅시다. 
 * 비록 현재 칸까지는 벽을 부수고 오는 것이 최적이었지만, 이 상태로는 끝에 아예 도달을 못 하죠? 현재 칸까지는 더 멀더라도 벽을 안 부수고 와야, 끝에 도달이 가능합니다.
 * 
 * 4. (스포일러) 그래서 이 문제에서는 BFS에 대해 새로운 테크닉을 요구합니다. 단순히 좌표만을 큐에 넣어 탐색하는 방식을 넘어, "현재 상태" 자체를 큐에 넣어서 문제를 풀어야 합니다. 
 * 즉, 어떤 좌표에 있는가 뿐만 아니라, "여기까지 오면서 벽을 부순 적이 있는가" 여부를 함께 큐에 저장해서 탐색하고, 각각을 별개로 방문 체크해줘야 하는 문제입니다. 
 * visited[x][y]가 아니라, visited[x][y][벽을 부순 적이 있는가?] 가 되어야 합니다.
 * 
 * 5. 이 문제에서는 같은 칸에 방문하는 경우 벽을 안 부순 것이 더 유리하기 때문에 벽을 부쉈는지 여부를 방문 배열에 기록하여 부순 횟수가 더 적을 때만 방문하는 방법도 됩니다. 
 * 그러나 이는 문제의 특성 때문에 이 문제에서만 통하는 그리디이므로 다른 문제에도 함부로 사용해서는 안 됩니다.
 * @author kit938639
 *
 */

public class Main_BOJ_2206_벽부수고이동하기_G4_668ms {

	private static int N, M;
	private static char[][] map;

	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static boolean[][][] visited;
	
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
		visited = new boolean[N][M][2];	//	visited[][][0] : 벽을 부시지 않는 경우의 방문 체크, visited[][][1] : 벽을 부시는 경우의 방문체크
		que.add(new int[] {0,0,1,0});	//	x, y, dist, 벽을 부신 여부(0: false(부신적이 없다), 1: true(부신적이 있다))
		
		int ans = 0;
		int x = 0;
		int y = 0;
		while(!que.isEmpty()) {
			int[] coord = que.poll();
			x = coord[0];
			y = coord[1];
			int dist = coord[2];
			
			if(x==N-1 && y==M-1) {
				System.out.println(dist);
				System.exit(0);
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(map[nx][ny]=='0') {	// 다음 위치가 벽이 아닐 때
					if(coord[3]==0 && !visited[nx][ny][0]) { // 부신적이 없는 경우, 부신 적이 없으므로 visited[][][0]에서 방문 체크
						que.add(new int[] {nx, ny, dist+1, 0});	// 다음 위치가 벽이 아니므로 부실 수가 없고 이전까지도 부신적이 없기에 부신 여부는 0!. 따라서 coord[3]=0
						visited[nx][ny][0]=true;
					}else if(coord[3]==1 && !visited[nx][ny][1]) { // 벽을 한 번 부신 적이 있는 경우, visited[][][1]에서 방문 체크
						que.add(new int[] {nx, ny, dist+1, 1});	//	다음 위치가 벽은 아니지만 이전에 부신 전적이 있기에 부신 여부는 1!. 따라서 coord[3] = 1
						visited[nx][ny][1]=true;
						
					}
				}else {	//	다음 위치가 벽인 경우
					if(coord[3]==0) {	// 부신 경우가 없으면 부시고 가면 됨.
						que.add(new int[] {nx, ny, dist+1, 1});	// 벽을 부셨으므로 부신 여부를 업데이트 하고
						visited[nx][ny][1] = true;	//	방문 체크도 visited[][][1]에 한다.
					}
				}
			}
		}
		
		System.out.println(-1);
		
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
