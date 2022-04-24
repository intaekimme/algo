package com.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

//	배열로 구현
public class CompleteBinaryTree {
	
	private char[] nodes;
	private int SIZE;
	private int lastIndex;	//	마지막에 들어온 노드의 인덱스 기억
	
	public CompleteBinaryTree(int size) {
		nodes = new char[size+1];	//	1인덱스부터 사용하므로 +1 크기로 잡기
		SIZE = size;
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull())	return;
		
		nodes[++lastIndex] = e;
	}
	
	
	public void bfs() {
		
		//	이진트리의 탐색 순서	
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//	루트가 가장 먼저 탐색되도로 queue에 넣기
		queue.offer(1);
		while(!queue.isEmpty()) {
			int current = queue.poll();	//	탐색 순서에 맞는 인덱스
			
			System.out.println(nodes[current]);
			
			//	현재 노드의 자식노드들의 인덱스를 다음에 순서가 되었을때 탐색되도록 큐에 넣어준다.
			//	왼쪽 자식노드
			if(current * 2 <= lastIndex)	queue.offer(current*2);
			//	오른쪽 자식노드
			if(current * 2 + 1 <= lastIndex)	queue.offer(current*2+1);
			
			
			
		}
	}
	
	public void bfs2() {
		
		if(isEmpty())	return;
		
		//	이진트리의 탐색 순서	
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//	루트가 가장 먼저 탐색되도로 queue에 넣기
		queue.offer(1);
		int level = 0;
		while(!queue.isEmpty()) {
			
			System.out.println("level "+level+" : ");
			//	같은 너비의 노드들 모두 탐색
			int size = queue.size();
			
			while(--size >= 0) {
				int current = queue.poll();	//	탐색 순서에 맞는 인덱스
				
				System.out.print(nodes[current]+"\t");
				
				//	현재 노드의 자식노드들의 인덱스를 다음에 순서가 되었을때 탐색되도록 큐에 넣어준다.
				//	왼쪽 자식노드
				if(current * 2 <= lastIndex)	queue.offer(current*2);
				//	오른쪽 자식노드
				if(current * 2 + 1 <= lastIndex)	queue.offer(current*2+1);
			}
			System.out.println();
			level++;
			
		}
	}
	
	
	public void dfsByPreOrder() {
		System.out.println("dfsByPreOrder");
		dfsByPreOrder(1);
		System.out.println();
	}
	public void dfsByInOrder() {
		System.out.println("dfsByInOrder");
		dfsByInOrder(1);
		System.out.println();
	}
	public void  dfsByPostOrderr() {
		System.out.println(" dfsByPostOrder");
		 dfsByPostOrder(1);
		System.out.println();
	}
	
	private void dfsByPreOrder(int current) {
		if(current>lastIndex)	return;
		//	현재 노드 방문
		System.out.print(nodes[current]+" ");
		//	현재노드의 자식노드들 방문
		
		dfsByPreOrder(current*2);
		dfsByPreOrder(current*2+1);
	}
	
	private void dfsByInOrder(int current) {
		if(current>lastIndex)	return;
		//	현재 노드 방문
		System.out.print(nodes[current]+" ");
		//	현재노드의 자식노드들 방문
		
		dfsByInOrder(current*2);
		dfsByInOrder(current*2+1);
	}
	
	
	private void dfsByPostOrder(int current) {
		if(current>lastIndex)	return;
		//	현재 노드 방문
		System.out.print(nodes[current]+" ");
		//	현재노드의 자식노드들 방문
		
		dfsByPostOrder(current*2);
		dfsByPostOrder(current*2+1);
	}
	
	
	
	
}
