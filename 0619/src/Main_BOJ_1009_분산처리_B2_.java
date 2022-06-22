import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1009_분산처리_B2_ {

	private static int TC, a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc<TC; tc++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			int res = 1;
			for(int i=0; i<b; i++) {
				res = (res * a) % 10; 
			}
			res = res != 0 ? res : 10;
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

}
