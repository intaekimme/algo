import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시간초과를 예방하기 위해 방문 횟수를 논리적으로 줄임
 * 일반적으로 2차원 배열에서의 방문체크를 2차원 배열을 1차원 배열로 매핑함으로써 방문횟수를 줄임
 * @author kit938639
 *
 */

public class Main_BOJ_9663_NQueen {

	private static int[] arr;
	private static int N, cnt, op;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 퀸의 갯수 겸 map의 크기
		
		arr = new int[N];	//	인덱스 내 값 : 행, 인덱스 : 열 >> N * N 행렬을 1차원으로 매핑
		
		nQueen(0);
		System.out.println(cnt);
		System.out.println(op);
	}

	private static void nQueen(int depth) {
		op++;
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				nQueen(depth + 1);
			}
		}
	}

	private static boolean possible(int depth) {
		op++;
	    for(int i=0; i<depth; i++) {
	    	// 같은 행이면 안됨
	    	if(arr[depth] == arr[i]) {
	    		return false;
	    	}
	    	// 같은 대각선이면 안됨, 
	    	if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
	    		return false;
	    	}
	    }
		
		
		return true;
	}

}
