package com.ssafy.pcs;

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
		
		permutation(0);

	}
	
	//	현재 자리에 수 뽑기
	public static void permutation(int cnt) {	//	cnt : 현재까지 뽑은 순열 수의 개수
		if(cnt == R) {	//	nPr에서 r개를 뽑아야 하는데 현재 cnt개를 뽑음, cnt<=R	
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			//	기존자리의 수들과 중복되는지 체크
			if(isSelected[i])	continue;
										//		   0 1 2 R
			numbers[cnt] = input[i];	//	number[ , , ]
			isSelected[i] = true;
			//	다음수 뽑으러 가기
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	

}
