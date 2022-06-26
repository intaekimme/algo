import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 5 17
 * 걷기 4 1
 * 순간이동 8 2
 * 순간이동 16 3
 * 걷기 17 4
 * ans+1
 * 
 * 순간이동 10
 * 걷기 9
 * 순간이동 18 
 * 걷기 17
 * ans+1 
 * 
 * 2^17=131072
 * (4*100,000) / 1024 = 390.625KB
 * @author kit938639
 *
 */

public class Solution_BOJ_12851_숨박꼭질2_G5_김인태_340ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int max = 100001;
		boolean[] visited = new boolean[max];
				
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.offer(new int[] {n, 0});	//	시작 위치, 현재까지 걸린 시간
		visited[n] = true;
		
		int cnt=0;
		int minS=0;
		
		while(!que.isEmpty()) {
			int curL = que.peek()[0];	//	현재 위치
			int curS = que.peek()[1];	//	현재까지 걸린 시간
			que.poll();
			visited[curL] = true;
			if(minS!=0 && minS==curS && curL==k)	cnt++;		//	한 번은 도착함, 목표 위치에 도착, 걸린시간이 최소
			if(minS==0 && curL==k) {	//	최초 도착
				minS = curS;
				cnt++;
			}
			
			if(curL + 1 < max && !visited[curL+1])	que.offer(new int[] {curL+1, curS+1});
			if(curL - 1 >= 0 && !visited[curL-1])	que.offer(new int[] {curL-1, curS+1});
			if(curL * 2 < max && !visited[curL*2])	que.offer(new int[] {curL*2, curS+1});
			
		}
		
		System.out.printf("%d\n%d\n", minS, cnt);
	}

}


//		원래 아이디어
//		int ans = Integer.MAX_VALUE;
//		int min=0;
//		int cnt=0;
//		
//		while(!que.isEmpty()) {
//			int x = que.poll();
//			visited[x]=true;
//			
//			if(x>=k) {
//				min = cnt + x - k + 1;
//				if(ans > min)	ans = min;
//			}else {
//				if(!visited[x+1]) {
//					que.offer(x+1);
//				}
//				if(!visited[x-1]) {
//					que.offer(x-1);
//				}
//				if(!visited[2*x]) {
//					que.offer(2*x);
//				}
//			}
//		}


//		212ms
//		int max = 100000;
//		int[] visited = new int[100001];
//				
//		Queue<Integer> que = new LinkedList<Integer>();
//		
//		int ans=0;
//		int cnt=0;
//		
//		que.offer(n);
//		while(cnt==0) {
//			int s = que.size();
//			while(s-- != 0) {
//				int x = que.poll();
//				if(x == k)	cnt++;
//				for (int nx : new int[]{x-1, x+1, 2*x}) {
//					if(nx < 0 | nx > max)	continue;
//					if(visited[nx]!=0 && visited[nx] != visited[x]+1) continue;
//					que.offer(nx);
//					visited[nx] = visited[x] + 1;
//				}
//			}
//			ans++;
//		}
//		
//		System.out.printf("%d\n%d\n", ans-1, cnt);
//		}






//		340ms
//		int max = 100001;
//		boolean[] visited = new boolean[max];
//				
//		Queue<int[]> que = new LinkedList<int[]>();
//		
//		que.offer(new int[] {n, 0});	//	시작 위치, 현재까지 걸린 시간
//		visited[n] = true;
//		
//		int cnt=0;
//		int minS=0;
//		
//		while(!que.isEmpty()) {
//			int curL = que.peek()[0];	//	현재 위치
//			int curS = que.peek()[1];	//	현재까지 걸린 시간
//			que.poll();
//			visited[curL] = true;
//			if(minS!=0 && minS==curS && curL==k)	cnt++;		//	한 번은 도착함, 목표 위치에 도착, 걸린시간이 최소
//			if(minS==0 && curL==k) {	//	최초 도착
//				minS = curS;
//				cnt++;
//			}
//			
//			if(curL + 1 < max && !visited[curL+1])	que.offer(new int[] {curL+1, curS+1});
//			if(curL - 1 >= 0 && !visited[curL-1])	que.offer(new int[] {curL-1, curS+1});
//			if(curL * 2 < max && !visited[curL*2])	que.offer(new int[] {curL*2, curS+1});
//			
//		}
//		
//		System.out.printf("%d\n%d\n", minS, cnt);
