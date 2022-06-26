import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_교환학생 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] week = new int[7];
			for(int i=0;i<7;i++) {
				week[i] = Integer.parseInt(st.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			for (int start = 0; start < 7; start++) {
				if(week[start]==0) continue;	//	수업이 열리지 않는 날은 패스
				
				int day = start, cnt=0;
				while(true) {
					if(week[day % 7]==1)	cnt++;	//	수업이 열리면 카운팅
					
					++day;	//	하루 지남
					if(cnt == N) {	//	머무른 최소 일 수	
						min = Math.min(min, day-start);
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+min);
			
		}	//	end of TC		
	}	//	end of main

}	//	end of class
 