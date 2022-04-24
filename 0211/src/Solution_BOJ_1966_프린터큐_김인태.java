import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_1966_프린터큐_김인태 {

	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());		//	문서 개수
			M = Integer.parseInt(st.nextToken());		//	궁금한 문서 몇 번째에 놓여 있는지
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			int number;
			
			for(int i=0;i<N;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(i==M) {
					number = tmp;
				}
				queue.add(tmp);
				arr[i]=tmp;
			}
			
			
			
			
			
			
			
			
			
		}
		
	}

}
