import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_1708_볼록껍질 {
	
	static class Point{
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	public static Comparator<Point> comp = new Comparator<Point>() {

		@Override
		public int compare(Point o1, Point o2) {
			int result = Long.compare(o1.y, o2.y);	//	기본은 y좌표로 오름차순 비교
			if(result==0) {	//	y좌표가 같은 경우 x좌표로 오름차순으로 비교
				return Long.compare(o1.x, o2.x);
			}else {
				return result;
			}
		}
	};
	
//	 매개변수를 넘기는 Comparator을 만드는 방법은 어떻게 될까? sol2의 79라인을 클래스를 안쓰고 사용하는 방법이 생각이 안남.
//	public static Comparator<Point> convex = new Comparator<Point>() {
//		
//		Point p0;
//		
//		
//		@Override
//		public int compare(Point o1, Point o2) {
//			return 0;
//		}
//		
//		
//	};
	
	static class convex implements Comparator<Point>{
		Point p0;
		public convex(Point p0) {
			this.p0 = p0;
		}

		@Override
		public int compare(Point o1, Point o2) {
			int result = ccw(p0, o1, o2);	//외적의 결과
			if(result == 0) {	//	외적의 결과가 0이면 한 직선에 세 점이 있
				long dist1 = dist(p0, o1);
				long dist2 = dist(p0, o2);
				if(dist1 > dist2) {	//p0를 기준으로 o1과o2중 가까운 순으로 정렬
					return 1; 
				}else return -1;
			}else {
				return result>0 ? -1:1;
			}
		}
	}
	
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		ArrayList<Point> pList = new ArrayList<Point>();
		Stack<Point> hull = new Stack<Point>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			pList.add(new Point(x, y));
		}
		
		Collections.sort(pList, comp);
		
//		for (Point point : pList) {
//			System.out.println(point);
//		}
		// Graham's Algo
		Point p0 = pList.remove(0);	// 제일 처음 선택한 점을 먼저 스택에 넣고 
		hull.push(p0);
		pList.sort(new convex(p0)); // 정렬된 점을
		Point p1 = pList.remove(0);
		hull.push(p1); // 차례로 스택에 넣는다.
		
		for(int i=0; i < N-2; i++) {
			Point b = pList.get(i);
			while(hull.size() >= 2) { // 만약 스택에 두개 이상의 점이 있다면
				Point a = hull.pop();	// 위의것이 뒤에 들어간것.
				Point p = hull.peek();	//먼저 들어간것
				int ccwvalue = ccw(p,a,b); // 가장 최근에 push된 두 점을 이은 직선을 기준으로
				if(ccwvalue > 0) {	//	새로운 점이 왼쪽에 있다면(=외적의 결과가 양수), 아니라면 (=외적의 결과 음수) 스택의 가장 위 점 pop 여기선 a에 해당
					hull.push(a);	//	꺼낸 점 다시 넣고
					break;
				}
			}
			hull.push(b);	// 새로운 점 스택에 push
		}
		System.out.println(hull.size());
	}

	static int ccw(Point p, Point a, Point b) {
		long result = cross(vec(p,a), vec(a,b));
		if(result > 0) {	//	외적의 결과가 양수 : 반시계방향
			return 1;
		}else if(result < 0) { // 음수, 시계방향
			return -1;
		}else {
			return 0;	//	외적이 0은 한 직선에 위
		}
	}

	// 외적의 정의
	static long cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}

	// 벡터의 정의에 의한 벡터
	static Point vec(Point a, Point b) {
		long x = b.x - a.x;
		long y = b.y - a.y;
		return new Point(x, y);
	}
	
	// 거리 공식
	static long dist(Point a, Point b) {
		return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y); 
	}
}
