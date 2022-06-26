import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * i
 * @author kit938639
 *
 */

public class Solution_딸기케이크나누기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	//	testCase 수
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());	//	정사각케이크 크기
			
			
			int[][] cake = new int[N][];
			int berry = 0;
			for (int i = 0; i < N; i++) {
				cake[i] = new int[N];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					cake[i][j] = tmp;
					berry+=tmp;
				}
			}
			int nberry = berry/4;
			boolean flag=false;
			
			int[] avg = new int[4];
			here: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					for(int r=0; r<=i; r++) {		//	1
						for(int c=0; c<=j; c++) {
							avg[0]+=cake[r][c];
						}
					}
					
					for(int r=0; r<=i; r++) {		//	2
						for(int c=j+1; c<=N-1; c++) {
							avg[1]+=cake[r][c];
						}
					}
					
					for(int r=i+1; r<=N-1; r++) {
						for(int c=0; c<=j; c++) {
							avg[2]+=cake[r][c];
						}
					}
					
					for(int r=i+1; r<=N-1; r++) {
						for(int c=j+1; c<=N-1; c++) {
							avg[3]+=cake[r][c];
						}
					}

					
					for(int k=0;k<4;k++) {
						if(avg[k]==nberry) {
							flag = true;
						}
						else {
							flag = false;
							break;
						}
							
					}
					
					Arrays.fill(avg, 0);
					
					if(flag) {
						sb.append("#").append(tc).append(" ").append(1).append("\n");
						break here;
					}				
				}
			}
			if(!flag)
				sb.append("#").append(tc).append(" ").append(0).append("\n");
		}
		
		System.out.println(sb);
	}	//	end of main
	
}
