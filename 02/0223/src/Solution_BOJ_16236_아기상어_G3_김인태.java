import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_16236_아기상어_G3_김인태 {
	
	
	static class Shark{
		int level=2;
		int up=0;
		
		public void shark(){};
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][][] map = new int[N][][];
		int[] feed = new int[7];
		
		int sr=0;		// start row(시작행)	
		int sc=0;		// start col(시작열)	
		
		for(int i=0;i<N;i++) {
			map[i]=new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val==9) {
					sr=i;
					sc=j;
					map[i][j][0]=val;	//	값
				}else {
					map[i][j][0]=val;
					feed[val]++;					
				}
			}
		}
		feed[0]=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j][1]= Math.abs(sr-i) + Math.abs(sc-j); //	맨하탄 거리
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.println(Arrays.toString(map[i][j]));
			}
		}
		
		
		
		
		
		sol(map, sr, sc);
	}	//	end of sol
	
	public static void sol(int[][][] map, int sr, int sc) {
		
		return;
	}

}
