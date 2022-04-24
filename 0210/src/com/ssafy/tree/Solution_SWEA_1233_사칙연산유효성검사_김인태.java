package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 수식 이진 트리의 유효성 판별
 * 1. 연산자는 루트 노드이거나 가지 노드
 * 2. 피연산자는 모두 잎 노드
 * 
 * 주어진 것 
 * 1. 노드의 갯수 - 높이를 알 수 있지 않을까?
 * 높이 = h, h+1 <= N < 2^h+1-1
 * 총 노드의 개수는 200개를 넘지 않으며 동시에 완전 이진 트리 이기에 높이는 8이 최대
 * 
 * 구현
 * 1.  노드를 입력받음
 * 노드를 링크드리스트에 담는다.
 * 이 링크드리스트에는 내 번호(0), 나의 내용(1), 왼쪽 자식번호(2), 오른쪽 자식 번호(3)의 정보를 가지고 있는 배열
 * 
 * 2. 루트노드(리스트 인덱스 1번)에서부터 출발
 * 재귀호출
 * 종료조건 : 완전 이진트리이므로 내 왼쪽 자식이 없거나 
 * @author kit938639
 *
 */

public class Solution_SWEA_1233_사칙연산유효성검사_김인태 {
	
	static int N;
	static List<String []> tree;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=1; tc++) {
			N = Integer.parseInt(br.readLine());	//	노드 갯수
			
			tree = new LinkedList<String []>();
			
			tree.add(new String[] {"0","0","0","0"});	//	tree의 인덱스는 1부터 시작하므로 0번째는 dummy 값으로 채움
			
			//	tree 채우기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String[] tmp = new String[4];
				
				//	노드 한 개 정보 채움
				int j=0;
				while(st.hasMoreTokens()) {
					String temp = st.nextToken();
					if(temp!=null) {
						tmp[j++] = temp;						
					}
				}
				if(j<=2) {
					tmp[j+1] = "0";
					tmp[j+2] = "0";
				}
				
				//	채워진 노드를 tree에 넣음	
				tree.add(tmp);
			}	// end of for tree
			
			preOrder(1);
						
		}	//	end of tc
		
	}	// end of main
	
	
	public static void preOrder(int index) {
		if(index > N) {
			
		}
		
		int[] child = visit(index);
		preOrder(child[0]);
		preOrder(child[1]);
		
	}
	
	
	public static int[] visit(int index) {
		
		int[] child = new int[2];
		
		
		
		
		
		return child;
	}
	

}	// end of class
