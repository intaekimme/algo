import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1002_터렛_S3 {

	private static int TC, x1, y1, r1, x2, y2, r2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<TC; tc++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());

			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int a = -10_000; a <= 10_000; a++) {
				for(int b = -10_000; b <= 10_000; b++) {
					int l1 = (int) (Math.pow(x1 - a, 2) + Math.pow(y1 - b, 2));
					int l2 = (int) (Math.pow(x2 - a, 2) + Math.pow(y2 - b, 2));
					
					if(l1 == (int)Math.pow(r1, 2) && l2 == (int)Math.pow(r2, 2)) cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
