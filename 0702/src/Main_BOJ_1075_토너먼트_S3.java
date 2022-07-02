import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 참가자 번호를 0부터 시작하게 1씩 뺀다음 xor 연산함
 * 그 결과를 1씩 오른쪽으로 쉬프트하여 0이 될 때까지 ++
 * 대진표의 제일 위 노드부터 0 1을 넣는다고 생각하면 이해 가능
 * (문제가 애초에 tree처럼 생겼기 때문에 bitwise operation으로 풀 수 있을 확률이 높음) ??
 *
 */
public class Main_BOJ_1075_토너먼트_S3 {

	
	private static int N, jimin, hansu;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		jimin = Integer.parseInt(st.nextToken());
		hansu = Integer.parseInt(st.nextToken());
		
		int xor_result = (jimin-1) ^ (hansu-1);
		int ans = 0;
		while(true) {
			if(xor_result>=1) {
				ans++;
				xor_result >>= 1;
			}else {
				break;
			}
		}
		System.out.println(ans);
	}

}
