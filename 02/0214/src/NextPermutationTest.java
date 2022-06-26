import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {

	static int N;
	static int[] input;	// input : 입력수배열, numbers : 선택수배
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		
//		long start=System.nanoTime();
		//1. 오름차순으로 정렬
		
		Arrays.sort(input);
		
		do {
			//	순열 출력
			System.out.println(Arrays.toString(input));	
		}while(np());
//		long end = System.nanoTime();
//		System.out.println(end-start);
	}
	
	private static boolean np() {
		//	1. 교환위치 찾기
		int i = N-1;	//	맨 뒤에서부터 찾기
		while(i>0 && input[i-1]>=input[i])	--i;
		
		if(i==0)	return false;		// 절벽을 만남...
		
		//	2. 교환위치에 교환할 값 찾기
		int j = N-1;
		while(input[i-1]>=input[j])	--j;
		
		//	3. 교환위치와 교환할 값 교환하기
		swap(i-1,j);
		
		//	4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 잇는 가장 작은 순열 생성(오름차순정렬)
		int k = N-1;
		while(i<k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	
	public static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
