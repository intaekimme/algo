import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_김인태 {
	
	static Queue<Integer> queue;
	static int mod = 1;  
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i <= 10; i++) {
			StringBuilder sb = new StringBuilder();
			int testCase = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue = new LinkedList<Integer>();
			
			//	queue에 넣는 작
			while(st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			sol2();
			// System.out.println(text);
			
			sb.append("#").append(testCase).append(" ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			
			System.out.println(sb);
			
		}

	}	//	end of main
	
	
	public static void sol2() {
		//	1 ~ 5 빼기
		mod=1;
		while(mod<6) {
			int tmp = queue.poll() - mod;
			if(tmp<=0)
				tmp  = 0;
			queue.offer(tmp);
			mod++;
			if(tmp==0)	return;
		}	//	end of while
		sol2();
	}	//	end of sol

	public static void sol() {
	outer:	while(true) {
			for(int i=1;i<6;i++) {
				int tmp = queue.poll()-i;
				if(tmp<=0) {
					tmp=0;
				}
				queue.offer(tmp);
				if(tmp == 0) 	break outer;
			}
		}
	}
	
}
