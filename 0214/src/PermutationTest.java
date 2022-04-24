

import java.util.Arrays;
import java.util.Scanner;

// nPr
// n개의 수 입력받아 처리


public class PermutationTest {

	static int N;
	static int R;
	static int[] input, numbers;	// input : 입력수배열, numbers : 선택수배
	static boolean[] isSelected;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		long start = System.nanoTime();
		permutation(0, 0);
		long end = System.nanoTime();
		System.out.println(end-start);

	}
	
	//	현재 자리에 수 뽑기
	public static void permutation(int cnt, int flag) {
		if(cnt == R) {
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			//	기존자리의 수들과 중복되는지 체크
//			if(isSelected[i])	continue;
			if((flag & 1<<i) != 0)	continue;
			
			numbers[cnt] = input[i];
//			isSelected[i] = true;
			//	다음수 뽑으러 가기
			permutation(cnt+1, flag | 1<<i);
//			isSelected[i] = false;
		}
	}
	

}
