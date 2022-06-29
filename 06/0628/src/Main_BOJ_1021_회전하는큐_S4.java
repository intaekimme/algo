import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 왼쪽 회전, 오른쪽 회전 두 개의 큐를 이용해 최소로 회전해야하는 횟수를 세고 제거 수행 
 * @author kit938639
 *
 */

public class Main_BOJ_1021_회전하는큐_S4 {

	private static int N, M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> que = new ArrayDeque<Integer>();
		for(int i=1; i<=N; i++) {
			que.add(i);
		}
		
		int cnt = 0;	//	2, 3 연산 수행 횟수 
		
		for(int i=0; i<M; i++) {
			int find = arr[i];	//	뽑아야 하는 수
			
			int searchSize = que.size();
			Integer[] search = new Integer[searchSize];
			que.toArray(search);	//	큐를 배열로 변환해 최소연산 횟수 계산
			
//			System.out.println(Arrays.toString(search));
			
			int left = 0;
			int right = 0;
			
			for(int j=0; j<searchSize; j++) {	//	2번 연산, 왼쪽으로 회전하는 경우 
				if(search[j] == find) {
					left = j;
//					System.out.println(left);
					break;
				}
			}
			
			for(int j=0; j<searchSize; j++) {	//	3번 연산, 오른쪽으로 회전하는 경우
				if(search[searchSize - 1 - j] == find) {
					right = j + 1;
//					System.out.println(right);
					break;
				}
			}
			
			if(left <= right) {	//	2번 연산의 횟수가 3번 연산 횟수보다 작거나 같은 경우
				while(left-- > 0) {
					que.addLast(que.removeFirst());	//	뒤에서 제거 후 앞에 추가
//					System.out.println(que.toString());
					cnt++;
				}
			}else {	//	3번 연산의 횟수가 2번 연산 횟수보다 많은 경우 
				while(right-- > 0) {
					que.addFirst(que.removeLast());	//	앞에서 제거 후 뒤에 추가
//					System.out.println(que.toString());
					cnt++;
				}
			}
			
//			System.out.println("---------------------");
			que.removeFirst();	//	뽑을 위치에 해당하므로 1번 연산 진행
//			System.out.println(que.toString());
//			System.out.println("=====================");
		}
		
		System.out.println(cnt);
		
	}

}
