import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 색종이가 판의 경계를 빠져나가면 안됨
 * 색종이가 겹쳐서도 안됨
 * 하나의 색종이는 하나의 판에만 붙일 수 있음.
 * = 하나의 판은 가능만 하다면 여러 색종이가 올 수 있다.
 * 
 * 색종이를 모두 붙이기 위해서 위와 같은 판이 최소 몇 개
 * @author kit938639
 *
 *	6 * 6 크기의 색종이는 판 1장씩 카운트
 *  5 * 5 크기의 색종이는 판 1장 카운트 시 11개의  1 * 1 크기의 색종이를 담을 수 있음
 *  4 * 4 크기의 색종이는 판 1장 카운트 시 5개의 2 * 2 크기의 색종이를 담을 수 있음
 *  3 * 3 크기의 색종이는 판 1장 카운트 시 3개의 3 * 3 크기의 색종이를 담을 수 있음
 */


public class Main_BOJ_2590_색종이_G4 {

	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[6];
		for(int i=0; i<6; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt=0;
		for(int i=5; i>=2; i--) {
			if(i==5) cnt += arr[i];
			if(i==4) {
				int possible = 0;
				while(arr[i]>0) {
					arr[i]--;
					possible += 11;
					cnt++;
				}
				if(possible>=arr[0]) {
					arr[0] = 0;
				}else {
					arr[0] -= possible;
				}
			}
			if(i==3) {
				int possible = 0;
				while(arr[i]>0) {
					arr[i]--;
					possible += 5;
					cnt++;
				}
				if(possible>=arr[1]) {
					arr[1] = 0;
				}else {
					arr[1] -= possible;
				}
			}
			if(i==2) {
				int possible = 0;
				while(arr[i]>0) {
					arr[i]--;
					possible += 3;
					cnt++;
				}
				
			}
		}
	}

}
