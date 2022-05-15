import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17387_선분교차2 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int x1, y1, x2, y2, x3, y3, x4, y4;
	static int[][] l1, l2;
	
	public static void main(String[] args) {
		try {
			input();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		1) x1 = x2 인 경우, 즉 수직인 경우
		if(x1 == x2) {
//			1-1) x1 = x2, x3 = x4, x1 = x3
			if(x3 == x4) {
				if(x1 == x3) {
					
				}
//			1-1) x1 = x2, x3 = x4, x1 != x3
				else {
					System.out.println(0);
					System.exit(0);
				}
			}
			else {
				
			}
		}
		
	}

	public static void input() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		l1 = new int[2][2];
		l2 = new int[2][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				l1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(l1[1][0] < l1[0][0]) {
			int tmp = l1[0][0];
			l1[0][0] = l1[1][0];
			l1[1][0] = tmp;
			
			tmp = l1[0][1];
			l1[0][1] = l1[1][1];
			l1[1][1] = tmp;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				l2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(l2[1][0] < l2[0][0]) {
			int tmp = l2[0][0];
			l2[0][0] = l2[1][0];
			l2[1][0] = tmp;
			
			tmp = l2[0][1];
			l2[0][1] = l2[1][1];
			l2[1][1] = tmp;
		}
		
	}

	public static void calc() {
		if(l1[0][1] == l1[0][0]) {
			
		}
	}
	
	public static int getIncl(int[][] L) {
		return L[1][1] - L[0][1] / L[1][0] - L[0][0];
	}
}
