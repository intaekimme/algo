import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 최소경로라 해서 다익스트라 알고리즘인줄 알았는데...
 * dfs-백트랙킹이었다...
 * @author kit938639
 *
 */


public class Solution_정올_1681_해밀턴순환회로_IM_김인태_128ms {
	
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	//	정점의 개수
		
		int[][] adjMatrix = new int[N][];
		int start = 0;
		
		for(int i=0;i<N;i++) {
			adjMatrix[i] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visited = new boolean[N];		//	최소비용 확정 여부
		visited[0]=true;						//	출발지점 1
		dfs(1, 0, 0, N, adjMatrix, visited);	
		
		System.out.println(ans);
	}	//	end of main
	
	/**
	 * 
	 * @param cnt	방문한 갯수
	 * @param cur	현재 위치
	 * @param sum	현재까지 이동경로 합
	 * @param N		정점 갯수
	 * @param adjMatrix	인접행렬
	 * @param visited	방문체크
	 */
	
	public static void dfs(int cnt, int cur, int sum, int N, int[][] adjMatrix, boolean[] visited) {
		if(sum>ans) return;		//
		if(cnt==N) {
			if(adjMatrix[cur][0]!=0 && ans > sum + adjMatrix[cur][0]) {
				ans=sum+adjMatrix[cur][0];
			}
			return;
		}
		for(int i=1; i<N; i++) {
			if(adjMatrix[cur][i]==0 || visited[i]) continue;
			visited[i]=true;
			dfs(cnt+1, i, sum+adjMatrix[cur][i], N, adjMatrix, visited);
			visited[i]=false;
		}
	}

}
