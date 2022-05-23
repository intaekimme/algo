import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 작은 수부터 차례로 더하다 보면 n까지의 합
 * 이후의 숫자를 더해야 할 때 n보다 작은 수에서 골라야 할 경우가 있다.
 * 이 때 n까지 사용했으므로 더 이상 사용할 숫자가 없다. 이 경우가 정답이다. 
 * @author kit938639
 *
 */
public class Main_BOJ_1789_수들의합_S5 {

	private static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		long n = 1;
		while(true) {
			if(N < n*(n+1)/2) break;
			n++;
		}
		System.out.println(n-1);
	}

}
