import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 입력 : 카드 갯수, 넘지 않으면서 3장의 카드의 합이 최대한 가까워야하는 수
 * N개의 카드
 * 전형적인 조합문제
 * @author kit938639
 *
 */

public class Solution_BOJ_2798_블랙잭_B2_김인태_128ms {

	static int ans=0, res[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		res = new int [3];
		comb(0,0, N, M, input);
		
		System.out.println(ans);
	}	//	end of main
	
	public static void comb(int cnt, int start, int N, int M, int[] input) {
		if(cnt==3) {
			int tmp=0;
			for(int i=0;i<3;i++) {
				tmp+=res[i];
			}
			//System.out.println(Arrays.toString(res)+" "+tmp);
			
			if(tmp>=ans && tmp <=M) {
				ans = tmp;
			}
			return;
		}
		for(int i=start; i<N; i++) {
			res[cnt] = input[i];
			comb(cnt+1, i+1, N, M, input);
		}
	}

}


//5 21
//5 6 7 8 9

//21

//10 500
//93 181 245 214 315 36 185 138 216 295
//497