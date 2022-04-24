import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_2239_스도쿠_answer {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[9][9];
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<9;i++) {
			String input = br.readLine();
			for(int j=0;j<9;j++) {
				map[i][j] = input.charAt(j)-'0';
				if(map[i][j]==0) list.add(new int[] {i,j});
			}
		}
		
		go(0, map, list);
	}

	private static void go(int l, int[][] map, ArrayList<int[]> list) {
		if(list.size()==l) {
			print(map);
			System.exit(0);
		}
		
		int x = list.get(l)[0];
		int y = list.get(l)[1];
		
		boolean[] visited = new boolean[10];
		
		for(int i=0; i<9; i++) {
			if(map[x][i]!=0) visited[map[x][i]]=true;
		}
		for(int i=0; i<9; i++) {
			if(map[i][y]!=0) visited[map[i][y]]=true;
		}
		
		int bx = (x/3) * 3;
		int by = (y/3) * 3;
		
		for(int i=bx; i<bx+3; i++) {
			for(int j=by; j<by+3; j++) {
				if(map[i][j]!=0) visited[map[i][j]] = true;
			}
		}
		
		for(int i=1; i<10; i++) {
			if(!visited[i]) {
				map[x][y] = i;
				go(l+1, map, list);
				map[x][y]=0;
			}
		}

	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
