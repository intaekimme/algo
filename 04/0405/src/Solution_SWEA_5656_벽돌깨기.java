/**
 * SWEA_1767_프로세서연결과 같은 시뮬레이션 문제
 * 핵심 : 구슬을 쏠 수 있는 자리가 여러개 이며 어느 순서로 쏘느냐에 따라 제거되는 벽돌의 갯수가 다르다.
 * 
 * 구슬 : 선택할 수 있는 자리가 여러개이다. 같은 자리를 다시 선택할 수 있다. 구슬이 선택한 자리의 순서에 따라
 * 		결과가 달라질 수 있다 => 중복순열로 순서를 골라보자
 * 	중복순열 : 중복순열의 코드를 돌린다. 입력으로 주어진 N개 크기의 순열을 만들면 해당 순열로 벽돌을 제거하는 작업을 시행한다.
 * 
 * 벽돌 : 하나의 벽돌에 의해 연쇄적으로 다른 벽돌들이 제거될 수 있다. 크기가 1인 벽돌은 자기 자신만 제거된다.
 * 		크기가 N인 벽돌은 중심부터 시작해서 상하좌우로 폭발을 일으킨다.
 * map의 구조를 3차원으로 설계하자. => 	[y][x][0] : 벽돌이 폭발을 일으키는 크기, 
 * 			[y][x][1] : 제거여부, 0은 폭발의 영향받지않음, 1은 폭발의 영향으로 제거 대상
 * 
 * 순열의 순서로 벽돌에 구슬을 다 쏘고나면 남은 벽돌의 갯수를 센다. 남은 벽돌의 갯수는 더 적은 결과가 나오면 갱신한다.
 * =더 많은 벽돌을 제거하였다.
 * 
 * !!!!!!
 * 벽돌이 제거된 이 후 벽돌을 떨어뜨리는 과정은 생각하지 못함
 * !!!!!!
 * 
 * !!!!!!
 * 구슬이 남은 중간에 벽돌이 모두 제거가 된 경우가 있을 수 있다.
 * !!!!!
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기 {

	static int N, W, H, map[][][], origin[][][], numbers[];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			numbers = new int[N];
			map = new int[H][W][2];
			origin = new int[H][W][2];
			for(int y=0; y<H; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<W; x++) {
					int val = Integer.parseInt(st.nextToken());
					if(val!=0) {
						map[y][x][0] = val;
						origin[y][x][0] = val;
					}
				}
			}
			
			
		}	//	end of TC
		
	}	// end of main
	
	// 수업시간 copy에 해당하는 부분
	private static void reset() {
		for(int y=0; y<H; y++) {
			for(int x=0; x<W; x++) {
				map[y][x][0] = origin[y][x][0];
			}
		}
	}
	
	// 수업 go에 해당
	private static void setShoot(int cnt) {
		if(cnt == N) {
			reset();
			shoot();
			return;
		}
		
		for(int i=0; i<W; i++) {
			numbers[cnt] = i;
			setShoot(cnt+1);
		}
	}
	// 수업 gp에 해당
	private static void shoot() {
		for(int i=0; i<N; i++) {
			int col = numbers[i];
			
			int row=0;
			while(row < H && map[row][col][0] == 0) {
				row++;
			}
			explosion(row, col);
		}
	}

	// boom에 해당
	private static void explosion(int row, int col) {
		Queue<int[]> q = new LinkedList<int[]>();
		map[row][col][1]=1;
		
		q.add(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int effect_size =  map[x][y][0];
			int isVisit = map[x][y][1];
			q.poll();

			for(int i=0;i<4;i++) {
				int ny = y + dy[i] * effect_size;	//	이건 내가 잘못함 한번에 간다...누적해야 하는데
				int nx = x + dx[i] * effect_size;
				
				if(isAvailable(ny, nx)) {
					map[nx][ny][1] = 1;
					q.add(new int[] {ny, nx});					
				}
			}
		}
		
		
	}

	private static boolean isAvailable(int ny, int nx) {
		if(ny<0 || ny>=H || nx<0 || nx>=W) return false;
		if(map[ny][nx][1] == 1) return false;
		return true;
	}

}
