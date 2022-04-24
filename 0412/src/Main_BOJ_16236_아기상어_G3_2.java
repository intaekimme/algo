import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어_G3_2 {

	static class fish{
		int x;
		int y;
		int size;
		boolean isShark;
		
		
		
		public fish(int x, int y, int size, boolean isShark) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.isShark = isShark;
		}



		@Override
		public String toString() {
			return "fish [x=" + x + ", y=" + y + ", size=" + size + ", isShark=" + isShark + "]";
		}

		
	}
	
	static class Comp implements Comparator<fish>{

		fish f;
		
		public Comp(fish f) {
			this.f = f;
		}


		@Override
		public int compare(fish o1, fish o2) {
			int dist1 = dist(f, o1);
			int dist2 = dist(f, o2);
			
			if(dist1 - dist2 == 0) {
				return Integer.compare(o1.x, o2.x);
			}else {
				return dist1 > dist2 ? 1:-1;
			}
		}
		
	}
	
	static int dist(fish a, fish b) {
		return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st = null;
		
		PriorityQueue<fish> pq = new PriorityQueue<fish>();
		
		fish shark = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 9) {
					shark = new fish(i,j,2,true);
				}
				map[i][j] = val;
			}
		}
		
		Comp comp = new Comp(shark);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int val = map[i][j];
				if(val != 0 && val != 9) {
//					pq.add(new fish(i,j, val, false), comp);
				}
			}
		}
		
		
	}

}
