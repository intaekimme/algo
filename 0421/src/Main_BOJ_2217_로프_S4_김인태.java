import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 그리디 문제
 * 지역적 최선, 차후 고려x
 * 로프 n개 입력 -> 오름차순 정렬
 * i번째 일때 들을 수 있는 최대 무게 = arr[i](무게) * N-i
 * i+1번째는 i번째보다 로프가 1개 적음 하지만 들 수 있는 무게가 증가할 수 있다.
 * 증가하면 최대무게 갱신	
 * @author kit938639
 *
 */


public class Main_BOJ_2217_로프_S4_김인태 {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println("====");
		int ans = 0;
		for(int i=0; i<N; i++) {
			int val = arr[i] * (N-i);
//			System.out.println(val);
//			System.out.println("---");
			if(ans<val) ans = val;
		}
		
		System.out.println(ans);
	}

}

//10 15 20 21
//10 40
//15 45
//20 40
//21 21
