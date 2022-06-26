import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 방향이 같은 개미들은 상대속도가 동일하기에 절대 충돌할 일이 없다.
 * 
 * 가설 1. 방향이 같은 개미들은 한 덩어리로 볼 수 있는가?
 * 
 * ->->->  <-
 * 0.5 : ->->-><-
 * 0.5 : ->-><-->
 * 0.5+ : -><-->->
 * 0.5+ : <-->->->
 * 0.6 : <- ->->->
 * 1: <-  ->->->
 * 
 * @author kit938639
 *
 */

public class Main_BOJ_2136_개미_G3 {

	static class ant implements Comparable<ant>{
		int x;
		boolean isleft;	//	음수면 true
		
		public ant(int x, boolean isleft) {
			this.x = x;
			this.isleft = isleft;
		}

		@Override
		public int compareTo(ant o) {
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "ant [x=" + x + ", isleft=" + isleft + "]";
		}
		
		
	}
	private static int N,L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ArrayList<ant> list = new ArrayList<ant>(N);
		for(int i=0; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			if(val<0) {
				list.add(new ant(Math.abs(val), true));
			}else {
				list.add(new ant(val, false));
			}
			
		}
		Collections.sort(list);
		
		System.out.println(list.toString());
		
		int time=0;

	}

}
