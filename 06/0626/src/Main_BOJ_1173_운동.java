import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1173_운동 {

	private static int N, m, M, T, R, pulse, totaltime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		pulse = m;
		totaltime = 0;
		
		if(!isPossible()) {
			System.out.println(-1);
			System.exit(0);
		}
		
		while(true) {
			if(pulse + T <= M)
				pulse = exercise();
			else {
				pulse = rest();
				if(pulse < m) pulse = m;
			}
			if(N==0) break;
		}
		System.out.println(totaltime);
	}
	
	public static boolean isPossible() {
		if(m + T > M) return false;
		else return true;
	}
	
	public static int exercise() {
		N--;
		totaltime++;
		return pulse + T;
	}
	
	public static int rest() {
		totaltime++;
		return pulse - R;
	}
	
}
