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
			
			int l1 = (int) Math.pow(x1-x2,2) + (int) Math.pow(y1-y2, 2);
			
			if(x1==x2 && y1==y2 && r1==r2) sb.append(-1).append("\n");
			else if(l1 > Math.pow(r1+r2, 2)) sb.append(0).append("\n");
			else if(l1 < Math.pow(r1-r2, 2)) sb.append(0).append("\n");
			else if(l1 == Math.pow(r1-r2, 2)) sb.append(1).append("\n");
			else if(l1 == Math.pow(r1+r2, 2)) sb.append(1).append("\n");
			else sb.append(2).append("\n");
			
		}
		System.out.println(sb);
	}

}
