import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_2239_스도쿠_sol {

	private static int a[][] = new int[9][9];
	private static boolean c1[][] = new boolean[10][10];	//	행
	private static boolean c2[][] = new boolean[10][10];	//	열
	private static boolean c3[][] = new boolean[10][10];	// 구
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[9][9];
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<9;i++) {
			String input = br.readLine();
			for(int j=0;j<9;j++) {
				a[i][j] = input.charAt(j)-'0';
				if(a[i][j]==0) {
					c1[i][a[i][j]] = true;
					c2[i][a[i][j]] = true;
					c3[square(i,j)][a[i][j]]=true;
				}
			}
		}
		
		go(0);
	}
	/** z번째 칸에 값 채워보기, z칸 = (z/9 행, z%9열)*/
	private static void go(int z) {
		int r = z/9;
		int c = z%9;
		System.out.printf("%d : (%d,%d)\n",z,r,c);
		
		if(z==81) return;
		go(z+1);
	}

	public static int square(int i, int j) {
		return (i/3)*3 + (j/3);
	}
	
	
	

}
