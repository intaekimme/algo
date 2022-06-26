import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10816_숫자카드2_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] count = new int[20000001]; // 입력받는 수의 범위 : -10_000_000 ~ 10_000_000
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N; i++) {
			count[Integer.parseInt(st.nextToken()) + 10000000]++;	// 해당 인덱스의 값 증가
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			sb.append(count[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
		}
		System.out.println(sb);
	}
}
