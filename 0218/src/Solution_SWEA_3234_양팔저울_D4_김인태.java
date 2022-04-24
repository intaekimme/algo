import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 서로 다른 무게
 * 양팔저울
 * 모든 무게 추를 양팔저울 위에 올리는 순서는 총 N!가지
 * 각 추를 양팔저울의 왼쪽에 올릴 것인지 오른쪽에 올릴 것인지를 정해야 해서 총 2N * N!가지
 * 왼쪽 무게 합 >= 오른쪽 무게 
 * 
 * @author kit938639
 *
 */



//N!을 구하면서 left 합과 right 합을 함께 체크
public class Solution_SWEA_3234_양팔저울_D4_김인태 {

	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] numbers = new int[N];		// 0 -> notUsed, 1-> left, 2-> right
			
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {	//	배열 채우
				arr[i] = Integer.parseInt(st.nextToken());
			}
			res=0;
			perm(0,0,0,arr,numbers);
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void perm(int left, int right, int cnt, int[] arr, int[] numbers) {
		int N = arr.length;
		
		if(cnt == N) {
			res++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(numbers[i]==0) {
				numbers[i] = 1;
				perm(left + arr[i], right, cnt + 1, arr, numbers);
				numbers[i] = 0;
				
				if(left >= right + arr[i]) {
					numbers[i] = 2;
					perm(left, right+arr[i], cnt + 1, arr, numbers);
					numbers[i] = 0;
				}
			}
		}
	}

}
