import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BOJ_1715_카드정렬하기_G4_fail {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int res = 0;
		if(N <= 2) {
			while(!pq.isEmpty()) {
				res += pq.poll();
			}
			System.out.println(res);
		}else {
			int check = 0;
			while(!pq.isEmpty()) {
				int val = pq.poll();
				++check;
				if(check==2) {
					res += val;
					res += res;
					check=0;
				}else {
					res += val;
				}
			}
			System.out.println(res);
		}
		
	}

}
