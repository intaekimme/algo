import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_BOJ_12059_가장오래걸리는스도쿠_김인태 {

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] cmap = new char[9][];
		for(int i=0;i<9;i++) {
			cmap[i] = br.readLine().toCharArray();
		}		
		int[][] map = new int[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0; j<9;j++) {
				map[i][j] = cmap[i][j]-'0';
			}
		}
		boolean[] visited = new boolean[10];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(map[i][j]==0) {
					int val = go(i, j, map, visited);
					if(val==0) {
						j--;
						map[i][j]=0;
					}
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

	private static int go(int r, int c, int[][] map, boolean[] visited) {
		for(int i=1; i<=9; i++) {
			if(check(i, r, c, map, visited)) {
				map[r][c]=i;
				visited[i]=true;
				return i;
			}
		}
		return 0;
	}

	private static boolean check(int i, int r, int c, int[][] map, boolean[] visited) {
		if(rowCheck(i, r, c, map, visited)&&
		colCheck(i, r, c, map, visited)&&
		boxCheck(i, r, c, map, visited)) return true;
		else return false;
	}

	private static boolean rowCheck(int i, int r, int c, int[][] map, boolean[] visited) {
		for(int j=0; j<9; j++) {
			if(map[r][j]==i || visited[i]) return false;
		}
		return true;
	}

	private static boolean colCheck(int i, int r, int c, int[][] map, boolean[] visited) {
		for(int j=0; j<9; j++) {
			if(map[j][c]==i || visited[i]) return false;
		}
		return true;
	}

	private static boolean boxCheck(int i, int r, int c, int[][] map, boolean[] visited) {
		if(r%9<3) {
			if(c%9<3) {
				for(int x=0; x<3; x++) {
					for(int y=0; y<3; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			if(c%9>=3 && c%9<6) {
				for(int x=0; x<3; x++) {
					for(int y=3; y<6; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			if(c%9>=6 && c%9<9) {
				for(int x=0; x<3; x++) {
					for(int y=6; y<9; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			return true;
		}
		if(r%9>=3 && r%9<6) {
			if(c%9<3) {
				for(int x=3; x<6; x++) {
					for(int y=0; y<3; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			if(c%9>=3 && c%9<6) {
				for(int x=3; x<6; x++) {
					for(int y=3; y<6; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			if(c%9>=6 && c%9<9) {
				for(int x=3; x<6; x++) {
					for(int y=6; y<9; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			return true;
		}
		if(c%9>=6 && c%9<9) {
			if(c%9<3) {
				for(int x=6; x<9; x++) {
					for(int y=0; y<3; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			if(c%9>=3 && c%9<6) {
				for(int x=6; x<9; x++) {
					for(int y=3; y<6; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
			if(c%9>=6 && c%9<9) {
				for(int x=6; x<9; x++) {
					for(int y=6; y<9; y++) {
						if(map[x][y]==i || visited[i]) return false;
					}
				}
				return true;
			}
		}
		return true;
	}

}
