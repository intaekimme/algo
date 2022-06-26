import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * layer 1 : 1
 * layer 2 : 2~7
 * layer 3 : 8~19
 * layer 4 : 20~37
 * layer 5 : 38~ 61
 * ...
 * layer 2부터
 * 각 layer의 시작은 초항이 2이고 계차가 6인 계차수열
 * 각 layer의 끝은 초항이 7이고 계차가 6인 계차수열
 * @author kit938639
 *
 */


public class Solution_BOJ_2292_벌집_B2_김인태_124ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start = 2;		//	layer 2 시작
		int end = 7;		//	layer 2 끝
		
		int idx=2;		//	계차
		
		while(true) {	//	범위 내에 도달해 있을 때까지 반복
			if(N==1) {	//	1이면 1칸이동이므로 1출력
				System.out.println("1");
				break;
			}
			if(start<=N && N<=end) {	//	시작 끝 사이에 도착하면 종료
				System.out.println(idx);
				break;
			}else {		//	아직 범위에 도달하지 않았다면 레이어증가
				start = start + 6*(idx-1);
				end = end + 6*idx;
				idx++;
			}
		}	//	end of while	
	}	//	end of main

}	//end of class
