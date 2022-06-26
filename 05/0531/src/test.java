import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * (*7+15)%7
 * @author kit938639
 *
 */
public class test {
	
	private static int[] arr = {1,5,4,2,9,7};
	private static int n, a, b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			flip(a, b);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void flip(int a, int b) {
		for(int i=a; i<=b; i++) {
			arr[i] = arr[((i * 7) + 15) % 7];
		}
	}
}

//0 1 2 3 4 5
//1 * 7 = 7 + 15 = 22 % 7 = 1
//2 * 7 = 14 + 15 = 29 % 7 = 1
//3 * 7 = 21 + 15 = 36 