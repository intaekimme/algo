import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * greedy 한 풀이
 * end 에서 start로 접근해 간다.
 * bfs 풀이 있으므로 github history 확인할 것
 * @author kit938639
 *
 */

public class Main_BOJ_16953_AarrowB_S1 {

	private static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		while(start != end) {
			if(end < start) {
				System.out.println(-1);
				System.exit(0);
			}
			if(end % 10 == 1) end /= 10;
			else if(end % 2 == 0) end /= 2;
			else {
				System.out.println(-1);
				System.exit(0);				
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
