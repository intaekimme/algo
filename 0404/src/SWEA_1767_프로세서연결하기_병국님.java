import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.print.StreamPrintService;
import javax.sound.midi.Synthesizer;

public class SWEA_1767_프로세서연결하기_병국님 {
	private static int N;
	private static int size;
	private static boolean[] visited;
	private static ArrayList<Info> list;
	private static int[][] arr;
	private static int min;
	
	
	static class Info{
		int x;
		int y;
		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
	}
	public static void combi(int start, int cnt, int value) {
//		System.out.println(cnt);
		if(cnt==value) {
			dfs(0,0);
			return;
		}
		
		for (int i = start; i < size; i++) {
			visited[i]=true;
			combi(i+1,cnt+1,value);
			visited[i]=false;
		}
		
		
	}
	static int [] dx = {-1,1,0,0};
	static int  [] dy = {0,0,-1,1};
	public static void dfs(int idx, int cnt) {
//		System.out.println(idx);

		if(idx==size) { //탈출 조건
			min = Math.min(min,cnt);
			return;
		}
//		System.out.println(Arrays.toString(visited));
		if(!visited[idx]) {	//	확인하지 않은 코어라면 전선으로 전원까지 연결할 수 있는 지 확인해봄
			dfs(idx+1,cnt);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			Info cur = list.get(idx);
			int score = 0;
			int x = cur.x;
			int y = cur.y;
//			System.out.println(x+":"+y);
			boolean flag=false;
			while(true) {
				
				x+=dx[i];
				y+=dy[i];
//				System.out.println(x+":"+y);
				if(x<0 || x>=N || y<0 || y>=N) {
					flag=true;
					break;
				}
				
				if(arr[x][y]==0) {
					arr[x][y]=2;
					score++;
				}
				
				else if(arr[x][y]!=0)break;
//				print();
//				System.out.println();
				
				
				
			}
			if(flag) { //끝까지 갔을 경우 -> 조건식으로 하니까 들어가게됨.
				dfs(idx+1,cnt+score);
			}
			System.out.println("--------------------------");
			for(int j=0;j<N;j++) {
				System.out.println(Arrays.toString(arr[j]));
			}
			while(true) { //다시지우기
				
				x-=dx[i];
				y-=dy[i];
				
//				System.out.println(x+":"+y);
				if(x==cur.x && y==cur.y)break;
				arr[x][y]=0;
			}
			
		}
	}
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			list = new ArrayList<Info>();
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if(arr[i][j]==1)  list.add(new Info(i,j));
				}
			}
			min=Integer.MAX_VALUE;
			visited = new boolean[12]; //최대 코어개수가 12개
			size = list.size();
//			System.out.println(size);
			for (int i = size; i>=1; i--) { //조합을 사용해서 경우의 수 여러개 만들기 최대부터 세어줘야함.
//				System.out.println(i);
				combi(0,0,i);
				if(min<Integer.MAX_VALUE) break; //조합을 멈춰주기위해서. 최대 코어만 구하면되니까
			}
			
			
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}//end of testCase
		System.out.println(sb.toString());
		
	}
	
	
}
