import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17471_게리멘더링 {

	private static int N, min;
	private static int[][][] map;
	private static boolean[] visited;
	private static int[] num = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			map[i][i][0] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			for(int t=0; t<tmp; t++) {
				int j = Integer.parseInt(st.nextToken());
				map[i][j][1]=1;
				map[j][i][1]=1;
			}
		}
		
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=N; j++) {
//				System.out.print(Arrays.toString(map[i][j]));				
//			}
//			System.out.println();
//		}
		visited = new boolean[N+1];
		min = Integer.MAX_VALUE;
		subset(1);
		if(min==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(min);

	}	//	end of main
	
	public static void subset(int start) {
		if(start == N) {
//			count++;
//			System.out.println(Arrays.toString(visited));
			
			gerry();
			return;
		}
		
		visited[start] = true;
		subset(start+1);
		visited[start] = false;
		subset(start+1);
		
	}

	
	public static void gerry(){
		
		ArrayList<Integer> areaA = new ArrayList<>();
		ArrayList<Integer> areaB = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) areaA.add(i);
			else areaB.add(i);
		}
		
		if(areaB.size()==0 || areaA.size()==0) return;
		else if(areaA.size()==1 && comb(0,0,areaB)) {
			int sum = 0;
			for(int i=0; i<areaB.size(); i++) {
				sum += map[areaB.get(i)][areaB.get(i)][1];
			}
			int val = Math.abs(map[areaA.get(0)][areaA.get(0)][0] - sum);
			if(val < min) {
				min = val;
			}
		}
		else if(areaB.size()==1 && comb(0,0,areaA)) {
			int sum = 0;
			for(int i=0; i<areaA.size(); i++) {
				sum += map[areaA.get(i)][areaA.get(i)][1];
			}
			int val = Math.abs(map[areaB.get(0)][areaB.get(0)][0] - sum);
			if(val < min) {
				min = val;
			}
		}else if(areaA.size()>1 && areaB.size()>1) {
			if(comb(0,0,areaA)) {
				int val=0;
				for(int i=0; i<areaA.size(); i++) {
					val += map[areaA.get(i)][areaA.get(i)][0];
				}
				if(comb(0,0,areaB)) {
					int val2 = 0;
					for(int i=0; i<areaB.size(); i++) {
						val2+= map[areaB.get(i)][areaB.get(i)][0];
					}
					if(Math.abs(val2-val) < min){
						min = Math.abs(val2-val);
					}
				}else return;
				
			}else {
				return;
			}
		}
		
//		System.out.println();
//		System.out.println(areaA.toString());
//		System.out.println(areaB.toString());
//		System.out.println();
//		
//		comb(0, 0, areaA);
//		System.out.println("======================");
//		comb(0, 0, areaB);
		
	}
	
	public static boolean comb(int start, int cnt, ArrayList<Integer> list) {
		if(cnt == 2) {
//			System.out.println(Arrays.toString(num));
			return map[num[0]][num[1]][1]==1 ? true : false;
		}
		for(int i=start; i<list.size(); i++) {
			num[cnt] = list.get(i);
			comb(i+1, cnt+1, list);
		}
		
		return false;
	}
}
