import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_김인태_181ms {

	static int[] input;
	static int[] numbers;
	static int N, M;
	static StringBuilder sb;
	
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			input = new int[N];
			numbers = new int[N*(N-1)/2];		//	nC2 크기만큼 할당
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ");
			sol();
			max=0;
			System.out.println(sb);
		}	//	end of for
		
	}	//	end of main

	public static void sol() {
		int l = 0;
		for(int i=0;i<N;i++) {		//	n개중 2개 뽑으므로 2중for문 사용
			for(int j=i+1; j<N;j++) {
				numbers[l]=input[i]+input[j];	//	가능한 경우 다 넣음
				l++;
			}
		}
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i]>max && numbers[i]<=M) {	//	판단
				max = numbers[i];
			}
		}
		if(max == 0)
			sb.append(-1);		// 가능한 경우 없으므로 -1
		else
			sb.append(max);		//	가능하면 기록한 값 출력
	}	//	end of sol
	
}	//	end of class
