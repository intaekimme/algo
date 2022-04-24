import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_김인태 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int testCase = 1; testCase <= TC; testCase++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int end = N/2;
			System.out.println(end);
			
			String[] srr = br.readLine().split(" ");
			
			sb.append("#").append(testCase).append(" ");
			
			if(N%2!=0) {// 홀수라면
				for(int i = 0; i < end; i++) {
					sb.append(srr[i]).append(" ").append(srr[i+end+1]).append(" ");
				}
				sb.append(srr[end]);
			}else {		// 짝수라
				for(int i = 0; i<end; i++) {
					sb.append(srr[i]).append(" ").append(srr[i+end]).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
