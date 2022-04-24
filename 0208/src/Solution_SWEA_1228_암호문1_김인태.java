import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_김인태 {
	
	// 값을 바꾼다. 배열의 크기는 고정!
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=10; i++) {		//	TC =10
			int N = Integer.parseInt(br.readLine());		//	N : 원본 암호문 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList<Integer> arr = new LinkedList<Integer>();
			
			//	10개 외의 숫자는 논외
			for(int j = 0; j < N; j++) {
				arr.add(Integer.parseInt(st.nextToken()));				
			}
			
//			System.out.println(Arrays.toString(arr));
			
			int I = Integer.parseInt(br.readLine());	//	I : 명령어 개수
			//	"I" 로 끊어 문자열 저장
			String[] srr = br.readLine().split("I ");
			
//			for(int j = 1; j < srr.length; j++) {
//				//srr[j] = st.nextToken();
//				System.out.println(j+", "+srr[j]);
//			}
			
			for(int j=1; j < srr.length; j++) {
				st = new StringTokenizer(srr[j]);
				int start = Integer.parseInt(st.nextToken());		// 앞에서부터 x의 위치 바로 다음
				int condition = Integer.parseInt(st.nextToken());	// y개
				for(int k = 0; k < condition; k++) {	// y개
					int tmp = Integer.parseInt(st.nextToken());
					arr.add(start+k,tmp);
					//System.out.println(arr);
				}
				//System.out.println();
			}
			//System.out.println("==============================");
			sb.append("#").append(i).append(" ");
			for (int j =0; j < 10; j++) {
				sb.append(arr.poll()).append(" ");
			}
			sb.append("\n");
			
		}	//	end of TC for
		System.out.println(sb);
	}	//end of main

}	//	end of class


// 4 5 6 7 8 9 10
// v   v   v   v
// 0   1   2 3 4 5
// 