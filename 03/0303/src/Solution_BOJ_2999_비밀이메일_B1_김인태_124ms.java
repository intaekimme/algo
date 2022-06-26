import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 약수 문제
 * R<=C, R*C=N
 * C^2=N
 * N은 최대 100
 * C는 최대 10
 * 
 * 
 * 상근이가 받은 메시지가 주어진다 = 정인이가 암호화 해서 보냄
 * 해독한 메시지를 출력
 * 
 * @author kit938639
 *
 */
public class Solution_BOJ_2999_비밀이메일_B1_김인태_124ms {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();		//	정인이가 보낸 문자 길이
		System.out.println(N);
		int sr=0;
		int sc=0;
		int sqrt = (int) Math.sqrt(N);
		for(int i=1; i<=sqrt; i++) {
			if(N%i==0) {
				sr = i;
				sc = N/i;
			}
		}
		
		System.out.println(sr+", "+sc);
		
		char[][] map = new char[sr][sc];	//	암호화 방식의 역순=복호화,	단계1	
		int idx=0;
		for (int c = 0; c < sc; c++) {
			for (int r = 0; r < sr; r++) {
				map[r][c] = str.charAt(idx++);
			}
		}
		
		for (int r = 0; r < sr; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
			
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < sr; r++) {		//	단계2	
			for (int c = 0; c < sc; c++) {
				sb.append(map[r][c]);
			}
		}
		
		System.out.println(sb);
	}	//	end of main
	
	
}	//	end of class


//		128ms
//		for (int r = 1; r < 101; r++) {		//	조건에 맞는 수 찾기
//			for (int c = r; c < 101; c++) {
//				if(r<=c && r*c==N) {
//					sr=r;
//					sc=c;
//				}
//			}
//		}


