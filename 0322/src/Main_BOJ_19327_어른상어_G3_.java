import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 4방
 *  1   2      3		 4
 *	위, 아래, 왼쪽(<-), 오른쪽(->)
 *
 */

public class Main_BOJ_19327_어른상어_G3_ {
	
	static class Info {
		int shark=0;
		int smell=0;
	}
	
	static class Shark {
		int number=0;		//	M
		int[][] prior = new int[4][];	//	4방별 우선순위 		
		int smell = 0;		//	K
		int dir=0;		//	방향
		
		int x=0;
		int y=0;
		
		@Override
		public String toString() {
			final int maxLen = 10;
			return "Shark [number=" + number + ", prior="
					+ (prior != null ? Arrays.asList(prior).subList(0, Math.min(prior.length, maxLen)) : null)
					+ ", smell=" + smell + ", dir=" + dir + ", x=" + x + ", y=" + y + "]";
		}
		
		
		public void go(Info[][] map) {
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Info[][] map = new Info[N][];
		Shark[] srr = new Shark[M+1];
		for(int i=1; i <= M; i++) {
			srr[i] = new Shark();
		}
		
		int time = 0;	//	정답
		
		
		// 격자판 생성
		for (int i = 0; i < N; i++) {
			map[i] = new Info[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = new Info();
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp != 0) {
					map[i][j].shark = tmp;
					map[i][j].smell = k;
					srr[tmp].number=tmp;
					srr[tmp].smell=k;
					srr[tmp].x = i;
					srr[tmp].y = j;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			srr[i].dir = Integer.parseInt(st.nextToken());
		}
		
		
		// 상어 정보 입력
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				srr[i].prior[j] = new int[4];
				for (int l = 0; l < 4; l++) {
					srr[i].prior[j][l] = Integer.parseInt(st.nextToken());
				}
			}
		}	
		
//		for (int i = 1; i <= M; i++) {
//			System.out.println(srr[i]);
//		} //정상입력 완료

		// 사이클
		while(true) {
			// 상어 배열 순회
			for (int i = 1; i <= M; i++) {
				go(map, srr[i]);
				
				
				
			}
		}	//	end of while
		
		
	}	//	end of main
	
	
	public static void go(Info[][] map, Shark shark) {
		
	}

}
