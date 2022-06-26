import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 부분집합 문제
 * @author kit938639
 *
 */


public class Solution_BOJ_1759_암호만들기_G5_김인태_124ms {

	static int L;
	static int C;
	
	static char[] input;
	static boolean[] isSelected;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());		//	뽑아야 하는 갯수
		C = Integer.parseInt(st.nextToken());		//	입력의 갯수		CCL
		
		input = new char[C];
		isSelected = new boolean[C];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			input[i]= st.nextToken().charAt(0);
		}
		
		
		sb = new StringBuilder();
		
		Arrays.sort(input);		//	정렬 먼저!!!
		sol(0, 0);
		System.out.println(sb);
	}	// end of main
	
	public static void sol(int cnt, int start) {
		if(cnt == L) {		//	L개의 암호를 뽑으면
			int vowels = 0;		//	모음 갯수
			int consonant = 0;	//	자음 갯수
			
			for(int i=0; i<C; i++) {	//	자음, 모음 갯수 세기
				if(isSelected[i]) {
					if(input[i]=='a' || input[i]=='e' || input[i]=='i' ||	
						input[i]=='o' || input[i]=='u') {
						vowels++;	//	모음이면
					}else {
						consonant++;	//	자음이면
					}
				}
			}
			
			if(vowels>=1 && consonant>=2) {		//	문제 조건: 모음 갯수, 자음 갯수 적어도 1개이상, 2개이상
				for(int i=0; i<C; i++) {
					if(isSelected[i])
						sb.append(input[i]);
				}
				sb.append("\n");
			}
			
		}else {
			for(int i=start; i<C; i++) {
				isSelected[i]=true;
				sol(cnt+1,i+1);
				isSelected[i]=false;
			}
		}
	}
	

}	//	end of class
