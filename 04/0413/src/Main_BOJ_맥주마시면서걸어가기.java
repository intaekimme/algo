import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


/**
 * 맥주는 편의점 도착하면 항상 20개로 fix해서 채우므로 갯수를 세는 것이 의미가 없다
 * 문제 잘 읽자
 * @author kit938639
 *
 */
public class Main_BOJ_맥주마시면서걸어가기 {

	static class Box{
		int beer;
		
		public Box() {
			this.beer=20;
		}
		
		void refill() {
			this.beer=20;
		}
				
		int possible() {
			return this.beer * M;	//	이동 가능한 총 거리
		}
	}
	
	static int n;
	static ArrayList<int[]> shop;
	static int[] home, festival;
	static final int M = 50;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; tc++) {
			n = Integer.parseInt(br.readLine());
			
			home = new int[2];
			st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			shop = new ArrayList<int[]>(n+1);
			festival = new int[2];	//	혹시 몰라서 하나 준비	
			// 편의점과 축제를 한 리스트로 관리
			for(int i=0; i<n+1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				shop.add(new int[] {x, y});
				if(i==n) {
					festival[0] = x;
					festival[1] = y;					
				}
				
			}
			
			Collections.sort(shop, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					int dist1 = dist(home, o1);
					int dist2 = dist(home, o2);
					if(dist1 > dist2) {
						return 1;
					}else if(dist1 == dist2){
						return 0;
					}else {
						return -1;
					}
				}
			});
						
			
//			System.out.println(Arrays.toString(home));
//			for(int i=0; i<n+1; i++) {
//				System.out.println(Arrays.toString(shop.get(i)));
//			}
//			System.out.println(Arrays.toString(festival));
			
			Box box = new Box();
			
//			start
//			처음 갖고 있는 맥주의 양으로 축제까지 이동이 가능하면 happy
			
			int[] current = new int[2];
			current[0] = home[0];	//	현재 x좌표, 항상 출발지 아니면 편의점
			current[1] = home[1];	//	현재 y좌표, 항상 출발지 아니면 편의점.
			
			int idx = 0;
			int spare = 0;		//	사용가능한 여분 거리
			while(true) {
				if(box.possible() >= dist(current, festival) + spare) {
					System.out.println("happy");
					break;
				}
//			아니다. 편의점을 들러야 한다. 편의점까지 이동 가능한가?
//			1. 이동 불가
				if(box.possible() < dist(current, shop.get(idx)) + spare) {
					System.out.println("sad");
					break;
				}
//			2. 이동 가능
//				int distance = dist(current, shop.get(idx));
//				int val = box.possible() - distance;
//				int used = 0;
//				if(val%M == 0) {
//					used  = val/M;
//					spare = 0;
//				}
//				else {
//					used = val/M + 1;
//					spare = val%M;
//				}
//				current[0] = shop.get(idx)[0];
//				current[1] = shop.get(idx)[1];
				else{
					idx++;
				}
			
			}
		}
	}	//	end of main
	
	public static int dist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1]-p2[1]);
	}

}
