import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SWEA_16935_배열돌리기3_김인태 {

	static int N;
	static int M;
	static int R;
	
	static int[] r;
	static int[][] map;
	static int[][] result;
	
	static boolean printResult;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = new int[M];
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		r = new int[R];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			r[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<R;i++) {
			switch (r[i]) {
			case 1:
				sol1();
				break;
			case 2:
				sol2();
				break;
			case 3:
				sol3();
				break;
			case 4:
				sol4();
				break;
			case 5:
				sol5();
				break;
			case 6:
				sol6();
				break;
			default:
				break;
			}
		}
		
		int w = map.length;
		int h = map[0].length;
		
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		
	}	//	end of main
	
	
	public static void sol1() {
		Stack<int []> stack = new Stack<int[]>();
		N = map.length;
		for(int i=0;i<N;i++) {
			stack.add(map[i]);
		}
		for(int i=0;i<N;i++) {
			map[i]=stack.pop();
		}
	}
	
	public static void sol2() {
		N = map.length;
		M = map[0].length;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M/2;j++) {
				int tmp = map[i][j];
				map[i][j]=map[i][M-j-1];
				map[i][M-j-1]=tmp;
			}
		}
	}
	
	public static void sol3() {
		N = map.length;
		M = map[0].length;
		result = new int[M][N];
		Stack<int[]>stack = new Stack<int[]>();
		
		for(int i=0;i<N;i++) {
			stack.add(map[i]);
		}
		
		// N*M
		// M*N
	
		int j =0;
		while(!stack.isEmpty()) {
			int[] arr = stack.pop();		// arr.length == M 
			for(int i=0;i<M;i++) {
				result[i][j] = arr[i];
			}
			j++;
		}	// result를 채움
		map = new int[M][N];
		map = result;
	}
	
	public static void sol4() {
		N = map.length;
		M = map[0].length;
		result = new int[M][N];
		List<int[]> list = new ArrayList<int[]>();
		
		for(int i=0;i<N;i++) {
			list.add(map[i]);
		}
		
		// N*M
		// M*N
	
		int size = list.size();
		for(int i=0, j=0; i<size; i++) {
			int[] arr = list.get(i);
			for(int k=0; k<M; k++) {
				result[k][j] = arr[M-1-k];
			}
			j++;
		}
		map = new int [M][N];
		map = result;
	}
	
	public static void sol5() {
		N = map.length;
		M = map[0].length;
		int[] dr = {0,N/2,N/2};
		int[] dc = {M/2,M/2,0};
		
		for(int r=0; r<N/2; r++) {
			for(int c=0; c<M/2; c++) {
				for(int i=0;i<3;i++) {
					int swap = map[r][c];
					map[r][c]=map[r+dr[i]][c+dc[i]];
					map[r+dr[i]][c+dc[i]]=swap;
					
				}
			}
		}
	}
	
	public static void sol6() {
		N = map.length;
		M = map[0].length;
		int[] dr = {N/2, N/2, 0};		// 1, 2, 3, 4
		int[] dc = {0, M/2, M/2};
		
		
		for(int r=0; r<N/2; r++) {
			for(int c=0; c<M/2; c++) {
				for(int i=0;i<3;i++) {
					int swap = map[r][c];
					map[r][c]=map[r+dr[i]][c+dc[i]];
					map[r+dr[i]][c+dc[i]]=swap;
					
				}
			}
		}
	}
}