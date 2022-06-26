import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_1992_쿼드트리_김인태 {

	private static char[][] m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		m = new char[N][];	//	뒤에 N을 넣는 경우, 
		
		for(int i=0;i<N;i++) {
			m[i] = br.readLine().toCharArray();		//	array 복사하는 가장 빠른 방법인 arraycopy를 사용함.
		}
		
		System.out.println(go(0,0,N));
	}

	
	public static String go(int sr, int sc, int size) {
		//	정사각 영역이 같은 값이라면, 그 숫자를 리턴
		int same = isSame(sr,sc,size);
		if(same == '0' || same == '1') {
			return same -'0' + "";
		}
		//	같은 값이 아니라면 (좌상, 우상, 좌하, 우하)	
		int nextSize = size>>1;
		
		return new StringBuilder().append("(")		
		.append(go(sr			,sc				,nextSize))
		.append(go(sr			,sc+nextSize	,nextSize))
		.append(go(sr+nextSize	,sc				,nextSize))
		.append(go(sr+nextSize	,sc+nextSize	,nextSize))
		.append(")").toString();

	}
	/**
	 * 정사각 영역의 시작좌표 : (sr,sc), 정사각 영역의 한변의 크기 : size
	 * 정사각 영영의 값이 모두 동일한지 체크하는 메서드
	 * 리턴 0,1,-1(모두 동일하지 않을 때) 	 
	 */
	public static int isSame(int sr, int sc, int size) {
		char t = m[sr][sc];
		for(int r = sr, er = sr + size; r< er; r++) {
			for(int c = sc, ec = sc+size; c<ec; c++) {
				if(t != m[r][c])	return -1;
			}
		}
		return 0;
	}
	
}
