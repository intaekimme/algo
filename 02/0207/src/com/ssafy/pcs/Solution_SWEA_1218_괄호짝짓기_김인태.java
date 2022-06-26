package com.ssafy.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_김인태 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= 10; i++) {
			int size = Integer.parseInt(br.readLine());
			char[] crr = new char[size];
			crr = br.readLine().toCharArray();
			
			sb.append("#").append(i).append(" ").append(Solution(size, crr)).append("\n");
		}
		System.out.print(sb);
	}	//	end of main

	public static int Solution(int size, char[] crr){
		Stack<Character> s = new Stack<Character>();
		
		// 넘겨 받은 배열을 검사하기 위해 원소 하나씩 스택에 넣는다.
		for(int i  = 0; i < size; i++) {
			//	여는 괄호는 그냥 집어 넣는다.
			if(crr[i]!=')' && crr[i]!=']' && crr[i]!='}' && crr[i]!='>')
				s.push(crr[i]);
			else {
				if(crr[i]==')' && !s.isEmpty() && s.peek()=='(')
					s.pop();
				else if(crr[i]==']' && !s.isEmpty() && s.peek()=='[')
					s.pop();
				else if(crr[i]=='}' && !s.isEmpty() && s.peek()=='{')
					s.pop();
				else if(crr[i]=='>' && !s.isEmpty() && s.peek()=='<')
					s.pop();
				else
					return 0;				
			} // end of else
		}	// end of for stack
		
		// 여기까지 도달하면 정상이므로 return 1
		return 1;
	}	// end of sol
	
}	// end of class

// 플랫하게 보자
// 입력값이 (, {, [, < 이라면 무조건 스택에 쌓는다.
// 입력값이 닫는 괄호라면 매칭이 될 때만 빼고 그것이 아니라면 넣는다. (이것은 차후 오류 발생)