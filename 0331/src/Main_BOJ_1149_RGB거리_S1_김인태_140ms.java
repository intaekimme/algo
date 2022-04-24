import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인접한 집의 색깔은 같지 않아야 한다.
 * 모든 집을 칠하는 비용의 최솟값을 구해보자.
 * 그리디적인 접근 법으로는 정답을 구할 수 없다.
 * 매 순간은 최소를 선택하지만, 처음 시작에서 나눠진 모든 경우에 대한 결과를 보고
 * 그 결과에서 최소를 구해야 한다.	
 * @author kit938639
 *
 */


public class Main_BOJ_1149_RGB거리_S1_김인태_140ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());		
		int[][] rgb = new int[n][3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] min = new int[3];
		for(int i=0; i<n; i++) {
			int[] tmp = min.clone();	//	누적값
			min[0] = Integer.min(rgb[i][0]+tmp[1], rgb[i][0]+tmp[2]);
			min[1] = Integer.min(rgb[i][1]+tmp[0], rgb[i][1]+tmp[2]);
			min[2] = Integer.min(rgb[i][2]+tmp[0], rgb[i][2]+tmp[1]);
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(ans>min[i])
				ans=min[i];
		}
		
		System.out.println(ans);
	}

}
