import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
//import java.util.Queue;
import java.util.StringTokenizer;

public class S5719 {

	private static class Hand{
		int alien;
		int position;
		boolean istop;
		
		public Hand(int alien, boolean istop) {
			super();
			this.alien = alien;
			this.istop = istop;
		}

		@Override
		public String toString() {
			return "Hand [alien=" + alien + ", istop=" + istop + "]";
		}
		
	}
	
	private static int T, F, N;
	private static int[] alien;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			F = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
						
			int[] count = new int[N+1];
			Deque<Hand> que = new LinkedList<Hand>();
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int alien = Integer.parseInt(st.nextToken());
				
				count[alien]++;
				Hand hand = new Hand(alien, false);
				que.add(hand);
			}
			int queSize = que.size();
			que.peekLast().istop = true;
//			Arrays.sort(count);
			
			for(int i=1; i<count.length; i++) {
				System.out.print(count[i]);
			}
			System.out.println();
			
			for (Hand hand : que) {
				System.out.print(hand+" ");
			}
//			입력완료
			
			int turn = 0;
			int floor = 0;
//			while(true) {
//				if()
//				
//			}
		}
	}

}
