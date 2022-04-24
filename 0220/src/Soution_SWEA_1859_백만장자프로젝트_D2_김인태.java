import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 
 * 
 * 
 * @author kit938639
 *
 */



public class Soution_SWEA_1859_백만장자프로젝트_D2_김인태 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}

			int income=0;		//	매도하여 얻은 수입
			int day=0;			//	매입매도 시작할 날짜
			
		here:	while(day<N-1) {		//	매입매도를 N일 전까지는 계속 반복
				
				int max=0;		//	매도할 가격
				int sell=0;		//	매도할 날짜
				
				int cnt=0;			//	매입한 갯수
				int outcome=0;		//	매입하여 생긴 지출

				for(int i=day;i<N;i++) {	//	매입매도 시작한 날짜부터 N일까지의 매도 최댓값을 찾음
					int tmp = arr[i];
					if(tmp>max) {
						sell = i;
						max = tmp;
					}
					else break here;
				}
				
				while(day<sell) {	//	매도할 날짜 전까지는 계속 매입
					outcome += arr[day++];
					cnt++;
				}
				//	while문 탈출 시 매도할 날짜가 된 것과 동일
				income += max * cnt - outcome;
			}	//	end of while
			
			
			sb.append("#").append(tc).append(" ").append(income).append("\n");
		}	//	end of testCase
		
		System.out.println(sb);
	}	//	end of main

}	//	end of main
