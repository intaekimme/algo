package com.ssafy.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BOJ_2493_탑_김인태_my {

	
	static List<Integer> L;
	static boolean isMove = false;
	static int tmp = 0;
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		int[] R;
		Stack<Integer> S = new Stack<Integer>();;
		int index = 1;
		int out = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
//		L = new ArrayList<Integer>(N);
		S.push(0);
		R = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		while(st.hasMoreTokens()) {
//			L.add(Integer.parseInt(st.nextToken()));
//		}
		
		while(st.hasMoreTokens()) {
			int b = Integer.parseInt(st.nextToken());
			if(S.peek() < b) {
				R[index++]=out;
				S.push(b);
			}else {
				while(S.size()!=1) {
					S.pop();
					out++;
				}
				R[index++]=out;
				S.push(b);
			}
		}
		
		//sol(N-1, N-2);
		
		//sol2(tmp);

		for(int i=1;i<N+1;i++) {
			sb.append(R[i]).append(" ");
		}
		System.out.println(sb);
		
	}	//	end of main
	
//	public static void sol(int start, int present) {
//		System.out.println(Arrays.toString(R));
//		if( present < 0 || start < 0) {	//	basis
//			return;
//		}else {		//	inductive
//			System.out.println(L.toString());
//			System.out.println("start: "+start+": "+L.get(start)+", present: "+present+": "+L.get(present));
//			if(L.get(start) < L.get(present)) {		
//				if(isMove) {
//					R[start]=present+1;
//					sol(start-1, present);
//				}else {
//					R[start]=present+1;
//					
//					sol(start - 1, present - 1);					
//				}
//			}else {
//				isMove = true;
//				sol(start, present - 1);
//			}			
//		}
//	}	//	end of sol
	
//	public static void sol2(int tmp) {
//		if(S.isEmpty()) {
//			return;
//		}
//		else {
//			int index = S.size();
//			int top = S.pop();
//			if(S.peek() > top) {
//				if(tmp != 0) {
//					R[tmp]=index-1;
//					R[index]=index-1;
//					System.out.println(Arrays.toString(R));
//					tmp = 0;
//					sol2(tmp);
//				}else {
//					R[index] = S.size(); 
//					sol2(tmp);					
//				}
//			}
//			else {
//				tmp = index;
//				sol2(tmp);
//			}
//		}
//			
//	}
	
	
	
}//	end of class