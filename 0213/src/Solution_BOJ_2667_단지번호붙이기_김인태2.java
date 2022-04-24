import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 문제 : Queue 사용!	
 * @author kit938639
 *
 */


public class Solution_BOJ_2667_단지번호붙이기_김인태2 {

	static int N;
	
	static int[] dx = {0,1,0,-1};	//	상, 우, 하, 좌
	static int[] dy = {-1,0,1,0};
	static Queue<Point> queue;
	static ArrayList<Integer> arr;
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[][]map = new char[N][];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		queue = new LinkedList<Point>();
		arr = new ArrayList<Integer>();	
				
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				bfs(x,y, map);				
			}
		}
		
		arr.sort(null);
		
		StringBuilder sb = new StringBuilder();
		
		int size = arr.size();
		sb.append(size+"\n");
		
		for(int i=0; i<size; i++) {
			sb.append(arr.get(i)+"\n");
		}
		System.out.println(sb);
		
	}	//	end of main

	
	public static void bfs(int x, int y, char[][] map) {
		map[x][y]='0';
		queue.offer(new Point(x,y));
		int cnt=0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny]!='0') {
					map[nx][ny] = '0';
					cnt++;
					queue.offer(new Point(nx, ny));
				}	// end of if
				
			}	// end of for		
		}	// end of while
		
		if(cnt>1)
			arr.add(cnt);
		
	}	// end of bfs
	
	
	private static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}	// end of Point class
	
	
}	//	end of class
