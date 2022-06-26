import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 부분집합 문제로 구현
 *	음식의 신맛 *= 재료의 신맛
 *	음식의 쓴맛 += 재료의 쓴맛
 *	이 때 신맛은 1,000,000,000(십억)의 범위를 넘지 말아야 한다.
 * @author kit938639
 *
 */


public class Solution_BOJ_2961_도영이가만든맛있는음식_김인태 {

	static int N;
	static boolean[] isSelected;
	static int min = 1000000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	//	재료의 갯수
		
		ArrayList<int[]> arr = new ArrayList<int []>(N);
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});		
			//	신 맛, 쓴 맛
		}
		
		isSelected = new boolean[N];
		subSet(0, arr);
		
		System.out.println(min);
	}	//	end of main
	
	public static void subSet(int cnt, ArrayList<int []>arr) {
		if(cnt==N) {	//	기저 조건
			int sour = 1;
			int bitter = 0;
			for(int i=0; i< N; i++) {
				System.out.print((isSelected[i]?Arrays.toString(arr.get(i)):"X")+" ");
				if(isSelected[i]) {
					sour *= arr.get(i)[0];
					bitter += arr.get(i)[1];
				}	
			}
			int result = Math.abs(sour-bitter);
			if(cnt!=0&&result<min)
				min=result;
			System.out.println(min);
			return;
		}else {
			
			isSelected[cnt] = true;
			subSet(cnt+1, arr);
			
			isSelected[cnt] = false;
			subSet(cnt+1, arr);
			
			
		}
		
	}	//	end of subSet
	

}	//	end of class
