import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 내림차순으로 정렬을 한다면...
 * 내 이전 값보다만 작으면 정답이 된다.
 * 몇번째 감소하는 수
 * 0 1 2 3 4 5 6 7 8 9 10 20 21 30 31 32 40 41 42
 * 순서가 존재...
 * 
 * 부분집합?
 * @author kit938639
 *
 */

public class Solution_BOJ_1038_감소하는수_G5_김인태 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N<10) {
			System.out.println(N);
		}else {
			System.out.println(sol(N));			
		}
	}	// end of main
	
	
	public static int sol(int N) {
		int i=10;
		int cnt=9;
		while(i<1000000 || cnt<N) {
			int tmp = i;
			int tmp2 = i;
			
			int size=0;
			while(tmp2>0) {
				tmp2/=10;
				size++;
			}
			
			int q=tmp/10;
			do {
				int qq=tmp/100;
				if(q>qq) {
					q=qq;
					tmp-=q*100;
					size--;
				}else {
					if(size>0)	break;
					else	cnt++;
				}
			}while(tmp>0);
			i++;
		}	//	end of while
		return cnt;		
	}	//	enf of sol
	
	
}	//	end of class
