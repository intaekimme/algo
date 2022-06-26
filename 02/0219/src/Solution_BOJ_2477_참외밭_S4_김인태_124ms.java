import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 		북
 * 서		동
 * 		남
 * 
 * 얼만큼 회전했든지 간에
 * 가장 긴 두 변은 모듈러 연산 시 결과 차이가 절댓값 1이다.
 * 때문에 첫번째로 발견한 긴 변의 이전이나 다음에는 두번째로 발견한 긴 변이 있어야 한다.
 * 두번 째로 발견한 긴 변에서 2, 3 번째 후에 발견한 변들의 길이의 곱이
 * 빼야할 작은 사각형의 넓이이다.
 * @author kit938639
 *
 */


public class Solution_BOJ_2477_참외밭_S4_김인태_124ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int[] arr = new int[6];
		int[] ns = new int[3];
		int[] ew = new int[3];
		
		int idxNS = 0;
		int idxEW = 0;
		
		int res=0;
		
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			arr[i]=val;
			
			switch (direction) {
			case 1:
				ew[idxEW++] = val;
				break;
			case 2:
				ew[idxEW++] = val;
				break;
			case 3:
				ns[idxNS++] = val;
				break;
			case 4:
				ns[idxNS++] = val;
				break;
			}
		}
		
		
		
		Arrays.sort(ns);
		Arrays.sort(ew);
		
		for(int i=0;i<6;i++) {
			if(arr[i]==ns[2]) {
				//처음 발견한 것, NS
				if(arr[(i+1)%6]==ew[2]) {	//	NS EW
					res = ((ns[2]*ew[2])-(arr[(i+3)%6]*arr[(i+4)%6]))*K;
				}
				else {		//	EW NS					
					res = ((ns[2]*ew[2])-(arr[(i+2)%6]*arr[(i+3)%6]))*K;
				}
				
			}
		}
		System.out.println(res);
		
	}

}
