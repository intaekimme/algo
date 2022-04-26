import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_11000_강의실배정_fail {

	static class Lecture implements Comparable<Lecture>{
		int start;
		int end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if(this.start==o.start) {
				return this.end-o.end;
			}else {
				return this.start-o.start;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>();
		

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			pq.add(new Lecture(S, T));

		}

		if(pq.size()==1) {
			System.out.println(1);
			System.exit(0);
		}
		
		int prev = pq.poll().end;
		int room=1;
		while(!pq.isEmpty()) {
			Lecture l = pq.poll();
			if(prev>l.start) room++;
			else prev = l.end;
		}
		System.out.println(room);
	}

}


//4
//1 3
//2 4
//3 5
//2 7
//3