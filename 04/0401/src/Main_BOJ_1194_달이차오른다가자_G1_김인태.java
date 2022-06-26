import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 내 지점에서 출구까지의 최단 경로를 찾아야 한다. 일단 BFS로 접근해보자
 * 내가 한 지점으로 이동할 때 고려해야 할 사항
 * 방문체크를 해야하는가? 방문체크를 하긴 해야 인접한 두 지점을 무한 반복하는 경우가 없다.	
 * 내가 이동하려는 지점의 형태가 어떤 모양인가?	
 * 1. 빈 : 방문하지 않았다면 방문한다.
 * 2. 벽 : 갈 수 없다.
 * 3. 열쇠 : 지도에 대응하는 문이 있다면 일단 먹자?
 * 4. 문 : 
 * 5. 출	
 * 
 * 출구가 여러 개라면 내가 어느 한 출구에 도착했다고해서 그 출구까지 이동한 경로가 최소라는 보장이 없다.
 * 따라서 모든 출구에 대한 이동 값을 확인해야 한다.
 * 
 * 탐색을 종료해야하는 경우
 * 1. 모든 출구의 이동 경로를 다 찾은 경우
 * 2. 모든 출구의 이동 경로를 찾는 도중 내 사방으로 이동할 수 없는 경우는 해당 출구 탐색 중지 -> -1
 * 
 * 결과 출력
 * 모든 출구에 대하여 적어도 1개의 양수값이 있다면 양수 값중 최솟값을 출력
 * 그렇지 않다면 -1 -> 해당 출구까지의 이동경로를 저장하는 배열 초깃값을 -1로 설정.
 * 
 * 
 * 
 * @author kit938639
 *
 */


public class Main_BOJ_1194_달이차오른다가자_G1_김인태 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][];
		// map 입력받음
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		// map을 한 번 순회하면서 필요한 정보를 수집
		// index : 문번호, 0: 해당 문까지 이동한 경로 수, 1: y좌표, 2: x좌표
		List<int[]> exit = new ArrayList<int[]>();
		
		// index : a,b,c,d,e,f 6개 (0~5),  0:y좌표, 1:x좌표, List[i]의 크기=i키의 갯수
		List<int[]> key = new ArrayList<int[]>(6);
		
		// index : A,B,C,D,E,F 6개 (0~5),  0:y좌표, 1:x좌표, List[i]의 크기=i문의 갯수
		List<int[]> door = new ArrayList<int[]>(6);
		
		int[] start = new int[2];
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<m; x++) {
				if(map[y][x]=='1') {
					exit.add(new int[] {-1, y, x});
					continue;
				}
				if('a'<=map[y][x] && map[y][x]<='f') {
					key.add(map[y][x]-'a', new int[] {y, x});
					continue;
				}
				if('A'<=map[y][x] && map[y][x]<='F') {
					door.add(map[y][x]-'A', new int[] {y, x});
					continue;
				}
				if(map[y][x]=='0') {
					start[0] = y;
					start[1] = x;
					continue;
				}
				
			}
		}	//	end of for
		
		
		
		for (int[] arr : exit) {
			System.out.println(Arrays.toString(arr));
		}	
		System.out.println();
		for(int[] arr : key) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
		for(int[] arr : door) {
			System.out.println(Arrays.toString(arr));
		}
		
	}

}
