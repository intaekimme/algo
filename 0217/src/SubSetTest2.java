

import java.util.Scanner;

public class SubSetTest2 {

	static int N, input[],S, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		ans=0;
		
		input = new int [N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0,0);
		System.out.println(ans);
		System.out.println(callCnt);
	}
	
	static int callCnt=0;
	
	public static void generateSubset(int cnt, int sum) {	//	cnt :	부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
															//	sum : 직전까지 구성된 부분집합의 합
		++callCnt;
		// 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		if(sum==S) {
			++ans;
			for(int i=0; i< cnt; i++) {
				System.out.print(isSelected[i]?input[i]+" ":"");
			}
			System.out.println();
			return;
		}
		if(sum>S) {
			return;
		}
		if(cnt == N) {	//	마지막 원소까지 부분집합에 다 고려된 상태
			return;
		}
		//	현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt + 1, sum+input[cnt]);	//	변화해서 들어감
		//	현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt + 1, sum);	//	변화하지 않으면서 들어감
	}

}
