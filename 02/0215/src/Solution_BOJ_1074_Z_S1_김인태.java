import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1074_Z_S1_김인태 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double N = Double.parseDouble(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int end = (int)Math.pow(2.0, 2*N) - 1;
		
		int val = (int)Math.pow(2.0, 2*N)*r + (int)Math.pow(2.0, 2*(N-1))*c;
		
		
		System.out.println(val);
		
	}

}
