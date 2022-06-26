import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	그리디
 *	주어진 무게를 넘기전까지는 5kg으로만 뽑음
 *	넘으면 -5, +3 = -2을 반복하며 맞나 확인
 *	0보다 작아지면 0에서부터 3씩증가하며 다시 카운트
 *	여기서도 안 걸리면 -1
 *	
 * @author kit938639
 *
 *				  18
 *	0	5	10	15	20
 *	  5	  5    5   5
 *				  18	
 *	
 */


public class Solution_BOJ_2839_설탕배달_B1_김인태_120ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int res = 0;
		int cnt = 0;
		
		while(true) {
			if(N%5==0) {
				cnt += N/5;
				System.out.println(cnt);
				break;
			}
			
			N = N-3;
			cnt++;
			
			if(N<0) {
				System.out.println("-1");
				break;
			}
		}
	}

}
