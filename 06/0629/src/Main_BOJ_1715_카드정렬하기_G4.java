import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BOJ_1715_카드정렬하기_G4 {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(N);
		
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int res = 0;
		int tmp = 0;
		int cnt = 0;
		while(true) {
			if(pq.isEmpty()) {
				res += tmp;
				break;
			}
			if(cnt%2 == 0 && cnt!=0) {
				res += tmp;
				pq.add(tmp);
				tmp=0; cnt=0;
				continue;
			}
			tmp += pq.poll();
			cnt++;
		}
		
		System.out.println(res);
	}

}