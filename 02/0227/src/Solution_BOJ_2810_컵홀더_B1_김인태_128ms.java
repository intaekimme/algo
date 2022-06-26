import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 비둘기집의 원리
 * 사람 수 > 홀더 : 홀더 수 출력
 * 사람 수 <= 홀더 : 사람 수 출
 * @author kit938639
 *
 */


public class Solution_BOJ_2810_컵홀더_B1_김인태_128ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	//	좌석수 = 사람수
		char[] seat = br.readLine().toCharArray();
		
		int sCnt=0;
		int llCnt=0;
		
		for(int i=0; i<seat.length; i++) {
			if(seat[i]=='S') sCnt++;
		}
		llCnt = (N-sCnt)/2;
		
		int cupHolder = 1 + sCnt + llCnt;
		
		if(N > cupHolder)	System.out.println(cupHolder);
		else System.out.println(N);
	}

}

//3
//SSS
//3

//4
//SLLS
//4

//9
//SLLLLSSLL
//7