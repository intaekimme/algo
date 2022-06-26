import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_최소스패닝트리_D4_김인태 {

	static class Info implements Comparable<Info>{

		int idx;
		long val;
		
		public Info(int idx, long val) {
			this.idx = idx;
			this.val = val;
		}
		
		@Override
		public int compareTo(Info o) {
			return Long.compare(this.val, o.val);
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[V+1];
			List<Info> li[];
			li = new List[V+1];
			for(int i=1; i<=V; i++)
				li[i] = new ArrayList<Info>();
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());
				long val = Integer.parseInt(st.nextToken());
				
				li[start].add(new Info(target, val));
				li[target].add(new Info(start, val));
			}
			
			long result = 0;
			PriorityQueue<Info> pq = new PriorityQueue<Info>();
			Deque<Integer> dq = new ArrayDeque<Integer>();
			
			dq.offer(1);
			while(!dq.isEmpty()) {
				int cidx = dq.poll();
				visit[cidx] = true;
				for (int i = 0; i < li[cidx].size(); i++) {
					int next = li[cidx].get(i).idx;
					long nv = li[cidx].get(i).val;
					
					if(!visit[next])
						pq.offer(new Info(next, nv));		
				}
				while(!pq.isEmpty()) {
					int next = pq.peek().idx;
					long nv = pq.peek().val;
					pq.poll();
					if(!visit[next]) {
						visit[next] = true;
						result += nv;
						dq.add(next);
						break;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}	//	end of TC
		
		System.out.println(sb);
	}	//	end of main

}	//	end of calss
