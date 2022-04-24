import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *  N : 맵의 크기, 1<= N <=10
 *  (1,1)부터 시작하므로 11,11짜리 배열 만들기
 *  
 *  M : 나무 갯수, 1<= M <= N^2(최대 100)개
 *  
 *  K : 지난 년도, 1<= K <= 1000
 *  년도 하나 당 4계절 최대 4000번의 과정
 *  
 *  A[r][c] : 양분의 양, 입력으로 들어오는 양분의 양은 맵과 동일하게 매핑
 *  
 *  1<=입력으로 주어지는 나무의 나이<=10
 *  
 *  처음 주어지는 나무 위치는 모두 서로 다르지만, 나무가 번식하면서 한 자리에 여러 나무가 생길 수 있다.
 *  
 * =============================================================================
 * 시간 제한 : 0.3초, 메모리 제한 : 512MB >> 가용할 수 있는 메모리의 양이 매우 많다. 활용
 * 
 * 탐색에서 시간이 걸리므로 탐색의 과정을 최대한 줄여야 한다. 탐색은 나무탐색 -> "나무 위치를 관리하자"
 * map size = 4byte * 11 * 11 = 484byte, 맵은 양분만 관리
 * i * col + j = i,j
 * 
 * @author kit938639
 *
 */


public class Main_BOJ_16235_나무제테크_G4_김인태 {

	static class tree implements Comparable<tree>{
		int x;
		int y;
		int age;
		
		public tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) {
			return this.age - o.age;
		}
		
	}
	
	
	private static int N,M,K;
	private static int[][] map, A;
	private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	private static PriorityQueue<tree> pq;
	private static Stack<tree> newTree;
	private static Stack<tree> growTree;
	private static Stack<tree> deadTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], 5);
		}		
		A = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pq = new PriorityQueue<tree>();
		newTree = new Stack<tree>();
		growTree = new Stack<tree>();
		deadTree = new Stack<tree>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			pq.add(new tree(x, y, age));
		}
		
		for(int i=0; i<K; i++) {
			//봄
			spring();
			
			//여름
			summer();
			
			//가을
			autumn();
			
			//겨울
			winter();
		}	
		
		System.out.println(pq.size());
		
	}	//	end of main
	
	public static void spring() {
		int size = pq.size();
		for(int i=0; i<size; i++) {
			tree t = pq.poll();
			int x = t.x;
			int y = t.y;
			if(t.age <= map[x][y]) {
				map[x][y] -= t.age;
				t.age++;
				growTree.push(t);
			}else {
				deadTree.push(t);
			}
		}
	}
	public static void summer() {
		int size = deadTree.size();
		for(int i=0; i<size; i++) {
			tree t = deadTree.pop();
			int x = t.x;
			int y = t.y;
			map[x][y] += t.age/2;
		}
	}
	public static void autumn() {
		int size = growTree.size();
		for(int i=0; i<size; i++) {
			tree t = growTree.pop();
			if(t.age % 5 == 0) {
				go(t);
			}
			pq.add(t);
		}
	}
	public static void winter() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]+=A[i][j];
			}
		}
	}
	
	public static void go(tree tr) {
		int x = tr.x;
		int y = tr.y;
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(round(nx, ny)) {
				pq.add(new tree(nx, ny, 1));
			}
		}
	}
	
	public static boolean round(int nx, int ny) {
		return nx>=0 && nx<N && ny>=0 && ny<N;
	}
	
	
//	public static void spring2() {
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				while(!map[i][j].trees.isEmpty()) {
//					tree tr = map[i][j].trees.poll();
//					if(tr.age <= map[i][j].nut) {
//						map[i][j].nut -= tr.age;
//						tr.age++;
//						map[i][j].growTree.push(tr);
//					}else {
//						map[i][j].deadTree.push(tr);
//					}
//				}	//	end of while
//				while(!map[i][j].growTree.isEmpty()) {
//					map[i][j].trees.add(map[i][j].growTree.pop());
//				}
//			}	//	end of inner for
//			
//		}	//	end of outer for
//		
//	}
//	
//	public static void summer2() {
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				while(!map[i][j].deadTree.isEmpty()) {
//					map[i][j].nut += map[i][j].deadTree.pop().age/2;
//				}
//			}
//		}
//	}
//	
//	
//	public static void autumn2() {
//		for(int i=1;i<=N;i++) {
//			for(int j=1; j<=N; j++) {
//				for (tree tr : map[i][j].trees) {
//					if(tr.age % 5 == 0) {
//						go(tr);
//					}
//				}
//			}
//		}
//		
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				while(!map[i][j].newTree.isEmpty()) {
//					map[i][j].trees.add(map[i][j].newTree.pop());
//				}
//			}
//		}
//	}
//	
//	public static void winter2() {
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				map[i][j].nut+=A[i][j];
//			}
//		}
//	}
	
}


