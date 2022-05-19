import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1931_회의실배정_S1 {

	static class Session {
		int start;
		int end;
		
		public Session(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		PriorityQueue<Session> pq = new PriorityQueue<>(new Comparator<Session>() {

			@Override
			public int compare(Session o1, Session o2) {
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}
				return o1.end - o2.end;
			}
		
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Session(start, end));
		}
		
		int pivot = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Session s = pq.peek();
			if(s.start >= pivot) {
				pivot = s.end;
				cnt++;
			}
			pq.poll();
		}
		
		System.out.println(cnt);
	}

}

//7
//3 10
//2 2
//1 3
//2 2
//9 10
//4 9
//2 2
//5

//5
//1 1
//1 1
//1 1
//1 1
//1 1
//5