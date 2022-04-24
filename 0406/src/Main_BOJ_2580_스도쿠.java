import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_2580_스도쿠 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] map = new int[9][9];
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0)
					list.add(new int[] {i,j});
			}
		}
		
		go(0, map, list);		
	}

	private static void go(int idx, int[][] map, ArrayList<int[]> list) {
		if(list.size() == idx) {
			print(map);
			System.exit(0);
		}
		
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		
		boolean[] check = new boolean[10];
		
		for(int i=0; i<9; i++) {
			if(map[x][i] != 0) check[map[x][i]]=true;
		}
		
		for(int i=0; i<9; i++) {
			if(map[i][y] != 0) check[map[i][y]]=true;
		}
		
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		
		for(int i = startX; i < startX + 3; i++) {
			for(int j = startY; j < startY + 3; j++) {
				if(map[i][j] != 0) check[map[i][j]] = true;
			}
		}
		
		for(int i=1; i<10; i++) {
			if(!check[i]) {
				map[x][y] = i;
				go(idx+1, map, list);
				map[x][y]=0;
			}
		}
		
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
