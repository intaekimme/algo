package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2563_색종이_B1_김인태_128ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[100][100];
		
		int sum=0;
		
		for(int tc=0; tc<N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int i=w-1; i<w+9;i++) {
				for(int j=h-1; j<h+9;j++) {
					if(map[i][j]==0) {
						map[i][j]=1;
						sum++;
					}
				}
			}
		}	//	end of tc
		
		System.out.println(sum);
	}	//	end of main

}	//	end of class
