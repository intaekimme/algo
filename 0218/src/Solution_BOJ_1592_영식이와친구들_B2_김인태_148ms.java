import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 
 * 원형 큐로 생각
 * 공은 항상 헤드가 던진다
 * 왼쪽으로 던지면 헤드에서 테일로 간다.
 * 오른쪽으로 던지면 테일에서 헤드로 온다.
 * @author kit938639
 *
 */


public class Solution_BOJ_1592_영식이와친구들_B2_김인태_148ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//	사람 수
		int M = Integer.parseInt(st.nextToken());	//	공을 던지는 횟수
		int L = Integer.parseInt(st.nextToken());	//	던지는 거리
		
		Deque<Integer> c = new ArrayDeque<Integer>(N);
		
		for(int i=1;i<=N;i++) {		//	사람 원형으로 앉히기,		head는 논리적으로 1, tail은 N
			c.offer(0);
		}
		
		int cnt=0;	//	공을 던진 횟수,	1번째 사람이 공을 받아 게임 시작
		
		while(true) {
			int val = c.pollFirst()+1;
			if(val<M) {	//	
				if(val%2!=0) {	//	현재 공을 받은 횟수가 홀수면
					c.offerLast(val);
					for(int i=0;i<L-1;i++) {
						c.offerLast(c.pollFirst());
					}
				}
				else {	//	짝수면
					c.offerFirst(val);
					for(int i=0;i<L;i++) {
						c.offerFirst(c.pollLast());
					}
				}
			}	//	end of if
			else {	//	공을 던진 횟수가 M과 같으면
				break;
			}
			cnt++;			
		}	//	end of while
		System.out.println(cnt);
	}	//	end of main

}	//	end of class
