import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1은 N극 성질을 가지는 자성체를 
 * 2는 S극 성질을 가지는 자성체를 의미하며 
 * 테이블의 윗 부분에 N극이 
 * 아랫 부분에 S극이 위치한다고 가정한다.
 * 
 * 1(N)은 아래로
 * 2(S)는 위
 * 0은 빈공간, 이 곳으로 이동할 수 있는 공간
 * 
 * 
 * 셋 이상의 자성체들이 서로 충돌하여 붙어 있을 경우에도 하나의 교착 상태
 * 
 * 열을 읽어야함
 * 위에서부터 읽다가 1이 나오면 2가 나오나 체크 준비
 * 2가 발견되면 그 때 부터 교착상태 카운트
 * 그전에는 카운트 하지 않는다.
 * 
 * 
 * toCharArray로 받았는데 같은 로직인데 개수가 다르게 나옴...(공백;;;;)
 * 
 * @author kit938639
 *
 */


public class Solution_SWEA_1220_Magnetic_D3_김인태_140ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {		//	testCase : 10개	
//			char[][] map = new char[100][];		//	map 100*100 중 행 생성
			int N = Integer.parseInt(br.readLine());		//	배열의 크기, 100*100으로 고정되어 있어 필요없는 값
			
//			for(int i=0; i<100; i++) {
//				map[i] = br.readLine().toCharArray();	//	map에 값 채워 넣음	
//			}

//			for(int i=0; i<100; i++) {
//				System.out.println(Arrays.toString(map[i]));	//	map에 값 채워 넣음	
//			}
			

			int[][] map = new int [100][100];
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for(int i=0; i<100; i++) {
				boolean isBlocked=false;		//	체크 시작여부, 1이 발견되면 true  이 후 2가 발견되면 false
				for(int j=0; j<100; j++) {
					if(map[j][i]==2 && isBlocked) {
						cnt++;
						isBlocked = false;
					}
					else if(map[j][i]==1) {
						isBlocked=true;		//	발견한 문자가 '1'
						continue;
					}
				}
			}	//	end of for
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
			
		}	//	end of testCase
		
		System.out.println(sb);
	}	//	end of main

}	//	end of class
