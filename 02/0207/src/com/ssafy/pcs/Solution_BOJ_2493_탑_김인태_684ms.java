package com.ssafy.pcs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BOJ_2493_탑_김인태_684ms {
	public static void main(String[] args) throws Exception {
		// int[] result;
		Stack<int[]> S = new Stack<int[]>();
		// int index = 1;	//	스택에 들어가는 원소의 순서번호
		// int out = 0;	//	pop된 원소의 갯수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//	입력 받으면서 판단하기위해	높이의 최소 0을 먼저 넣어놓음.
		// result = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long beforeTime = System.currentTimeMillis();
		
		for(int i=1;i<=N;i++) {
			int b = Integer.parseInt(st.nextToken());
			while(!S.isEmpty()) {
				if(S.peek()[0]<b) {
					S.pop();
				}else {
					sb.append(S.peek()[1]).append(" ");
					break;
				}
			}
			if(S.isEmpty()) {
				sb.append("0 ");
			}
			S.push(new int[] {b, i});
		}
		System.out.println(sb);
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		System.out.println(secDiffTime);
	}	//	end of main
}//	end of class




//		int[] result;
//		Stack<Integer> S = new Stack<Integer>();
//		int index = 1;	//	스택에 들어가는 원소의 순서번호
//		int out = 0;	//	pop된 원소의 갯수
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		//	입력 받으면서 판단하기위해	높이의 최소 0을 먼저 넣어놓음.
//		S.push(0);
//		result = new int[N+1];
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		//	현재 들어오는 빌딩보다 작은 빌딩은 스택에 존재하지 않는다.
//		while(st.hasMoreTokens()) {
//			int b = Integer.parseInt(st.nextToken());
//			if(S.peek() < b) {		// 현재 들어오는 빌딩보다 작은 빌딩은 없으므로 현재까지 나간 원소의 갯수를 결과배열에 넣고. 스택에도 쌓는다.	
//				if(b<out) {
//					result[index++]=out;
//					S.push(b);					
//				}else {
//					result[index++]=0;					
//				}
//			}else {		//	만약 현재 들어온 빌딩보다 작은 빌딩이 존재하면, 스택에서 제거하면서 갯수를 센다.
//				while(S.size()!=1) {
//					S.pop();
//					out++;
//				}		//	초기상태까지 비우면 그 때 스택에 값을 집어 넣으며, 배열에도 값을 넣는다.
//				result[index++]=out;
//				S.push(b);
//		
//			}
//		}	//	end of while
//		
//		for(int i=1;i<N+1;i++) {
//			sb.append(result[i]).append(" ");
//		}
//		System.out.println(sb);