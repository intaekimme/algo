import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 9C7을 뽑는 조합문제
 * @author kit938639
 *
 */
public class Solution_BOJ_3040_백설공주와일곱난쟁이_B2_김인태_124ms {
	
	static int[] arr;
	static int[] res;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		res = new int[7];
		sb = new StringBuilder();
		combination(0, 0);
		System.out.println(sb);
	}	// end of main

	public static void combination(int cnt, int start) {
		int R = res.length;
		int N = arr.length;
		
		if (cnt == R ) {
			int sum=0;
			for(int i=0;i<R;i++) {
				sum+=res[i];
			}
			if(sum==100) {
				for(int i=0;i<R;i++) {
					sb.append(res[i]).append("\n");
				}
			}
			return;				
		}
		
		for(int i = start; i < N; i++) {
			res[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}
	
}
