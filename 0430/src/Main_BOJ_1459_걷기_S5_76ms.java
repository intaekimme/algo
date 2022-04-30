import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1459_걷기_S5_76ms {

	private static long X, Y, W, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		W = Long.parseLong(st.nextToken());		//	직각 이동
		S = Long.parseLong(st.nextToken());		//	대각 이동
		
		long time = 0;
		if(2*W <= S) time = (X+Y) * W;	//	대각 이동 비용이 두 대변의 이동비용 합보다 큰경우 직각으로만 이동
		else {	//	대각 이동
			if(W <= S) {	//	대각 이동 후 직각 이동이 유리
				if(X<=Y) {
					time = X * S + (Y-X) * W;
				}else {	//	X > Y
					time = Y * S + (X-Y) * W;				
				}
			}
			else {	//	대각 위주로의 이동이 유리 W > S
				if(X<=Y) {
					long val = Y-X;
					if(val%2==0) time = Y * S;	//	대각 이동만으로 갈 수 있는 경우
					else {
						time = (Y-1) * S + W;	//	대각 이동 후 최소 한 번은 직각이동 해야 도착하는 경우
					}
				}else {	//	X > Y
					long val = X-Y;
					if(val%2==0) time = X * S;	//	대각 이동만으로 갈 수 있는 경우
					else {
						time = (X-1) * S + W;	//	대각 이동 후 최소 한 번은 직각이동 해야 도착하는 경우
					}
				}						
			}
		}
		
		System.out.println(time);
	}

}
