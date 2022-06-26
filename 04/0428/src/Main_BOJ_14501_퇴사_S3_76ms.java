import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * f(n) = f(n-1)+f(n-2)+f(n-3) (단, n>=4, f(1)=1, f(2)=2, f(3)=4)
 * @author kit938639
 *
 */
public class Main_BOJ_14501_퇴사_S3_76ms {

	public static void main(String[] args) throws IOException {
		int[] arr = {0,1,2,4,7,13,24,44,81,149,274};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n; i++) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}
	}

}
