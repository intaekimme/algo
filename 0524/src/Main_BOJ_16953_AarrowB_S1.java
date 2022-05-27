import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * A, B (1 ≤ A < B ≤ 10^9)
 * 이기에 int 자료형으로 문제 풀 시 틀린다.
 * long 자료형으로 풀어야 한다.
 * @author kit938639
 *
 */

public class Main_BOJ_16953_AarrowB_S1 {

	private static long start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Long.parseLong(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Queue<Long> que = new LinkedList<Long>();
		que.add(start);
		
		long cnt = 1;
		long size = 1;
		while(!que.isEmpty()) {
			while(size > 0) {
				long val = que.poll();
				size--;
				
				long op1 = val * 2;
				long op2 = (val * 10) + 1;
				if(op1 < end) que.add(op1);
				if(op1 == end) {
					System.out.println(cnt+1);
					System.exit(0);
				}
				if(op2 < end) que.add(op2);
				if(op2 == end) {
					System.out.println(cnt+1);
					System.exit(0);					
				}
			}
			size = que.size();
			cnt++;
		}
		System.out.println(-1);
	}

}
