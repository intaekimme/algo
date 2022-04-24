package com.ssafy.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트 {

	static int N, L;
	static Map<Integer, Integer> history;
	static int[] input;
	static int[][] numbers;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(tk.nextToken());
			L = Integer.parseInt(tk.nextToken());
			history = new HashMap<Integer, Integer>();
			
			input = new int[N];
			numbers = new int[N+1][];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				StringTokenizer tk2 = new StringTokenizer(str);
				int score = Integer.parseInt(tk2.nextToken());
				int cal = Integer.parseInt(tk2.nextToken());
				history.put(cal, score);
				input[i] = cal;
			}
			
			combination(0, 0);
			sb.append("#").append(testCase).append(" ").append(result).append("\n");		
		}
		System.out.println(sb);
	}	// end of main

	public static void combination(int cnt, int start) {
		if(cnt==N) {
			result = 0;
			return;
		}
		
		for (Map.Entry<Integer, Integer> entry : history.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			
		}
		
		
		
		for(int i = start; i < N; i++) {
			
			// numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}	
		
	}
	
}	// end of class
