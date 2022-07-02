import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 라운드를 돌며 임한수와 김지민이 가지는 수 중 큰 수가 짝수이고 두 수의 차가 1이면 이번 라운드에서 만난다.
 * 다음 라운드에서 새로운 순서를 줄 때는 이번 라운드 순서에 1을 더하고 2로 나눠주면 된다.
 * @author kit938639
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
		
		int cnt = 1;
		
		while(true) {
			if(Math.abs(jimin - hansu) == 1 && Math.max(jimin, hansu)%2 == 0) {
				break;
			}else {
				jimin = (jimin + 1) / 2;
				hansu = (hansu + 1) / 2;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
