import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1297_TV크기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		double y = D / Math.sqrt(1+Math.pow(W, 2)/Math.pow(H, 2));
		double x = y * W / H;
		
		int h = (int)x;
		int w = (int)y;
		
		System.out.println(w+" "+h);
		
	}

}
