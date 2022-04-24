package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_1158_요세푸스문제_김인태 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//	queue 채우기
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		
		sb.append("<");
		while(!queue.isEmpty()) {	// 비어있지 않으면 계속
			if(queue.size()>1) {	//	queue 사이즈가 1보다 크면 , 추가
				for(int i=1; i<K; i++) {	//	K-1번은 뽑아서 뒤에 추가
					int tmp = queue.poll();
					queue.add(tmp);
				}	// end of for
				sb.append(queue.poll()+", ");
			}else {					//	queue 사이즈가 1이면 > 추가
				sb.append(queue.poll()+">");
			}
		}	//	end of while
		
		System.out.println(sb);
	}	// end of main

}	// end of class