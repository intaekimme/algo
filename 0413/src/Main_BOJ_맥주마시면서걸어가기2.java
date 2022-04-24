import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 맥주는 편의점 도착하면 항상 20개로 fix해서 채우므로 갯수를 세는 것이 의미가 없다
 * 문제 잘 읽자
 * @author kit938639
 *
 */
public class Main_BOJ_맥주마시면서걸어가기2 {


	static int n;
	static ArrayList<int[]> shop;
	static int[] home, festival;
	static final int M = 50;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; tc++) {
			n = Integer.parseInt(br.readLine());
			
			home = new int[2];
			st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			shop = new ArrayList<int[]>(n);
			festival = new int[2];	//	혹시 몰라서 하나 준비	
			for(int i=0; i<n+1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(i==n) {
					festival[0] = x;
					festival[1] = y;
					break;
				}else {
					shop.add(new int[] {x, y});
				}				
			}
			
			Collections.sort(shop, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					int dist1 = dist(home, o1);
					int dist2 = dist(home, o2);
					if(dist1 > dist2) {
						return 1;
					}else if(dist1 == dist2){
						return 0;
					}else {
						return -1;
					}
				}
			});
						
			
//			System.out.println(Arrays.toString(home));
//			for(int i=0; i<n+1; i++) {
//				System.out.println(Arrays.toString(shop.get(i)));
//			}
//			System.out.println(Arrays.toString(festival));
			
			System.out.println(bfs(shop) ? "happy" : "sad");
			
			
		}	// end of TC
		
	}	//	end of main
	
	public static int dist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}
	
	static boolean bfs(ArrayList<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.add(new int[] {home[0],home[1]});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			if(dist(pos, festival) <= 1000) {
				return true;
			}
			
			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					int[] nList = list.get(i);
					int dis = dist(pos, nList);
					if(dis <= 1000) {
						visited[i] = true;
						q.add(nList);
					}
				}
			}
		}
		return false;
	}	// end of bfs

}	//	end of class
