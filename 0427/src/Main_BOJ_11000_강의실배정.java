import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_11000_강의실배정 {

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

		@Override
		public String toString() {
			return "Lecture [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			list.add(new Lecture(S, T));
		}
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(list.get(0).end);
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= list.get(i).start) {
				pq.poll();
			}
			pq.add(list.get(i).end);
		}
		

		System.out.println(pq.size());
		
	}

	public static void print(PriorityQueue<Integer> pq) {
		for (Integer i : pq) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("----------------");
	}
}


//4
//1 3
//2 4
//3 5
//2 7
//3