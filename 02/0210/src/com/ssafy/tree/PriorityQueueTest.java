package com.ssafy.tree;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();	//	기본적으로 최소힙으로 동작
		
		pQueue.offer(10);
		pQueue.offer(30);
		pQueue.offer(5);
		pQueue.offer(50);
		pQueue.offer(20);
		
		
		
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
	}

}
