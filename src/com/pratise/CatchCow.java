package com.pratise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CatchCow {
	
	static int N;
	static int M;
	static Node currNode;
	static Node nextNode;
	static Set<Integer> visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Queue<Node> queue = new LinkedList<Node>();
		visited = new HashSet<Integer>();
		queue.add(new Node(N,0));
		
		while(!queue.isEmpty()) {
			currNode = queue.poll();
			if(currNode.number == M) {
				System.out.println(currNode.step);
				break;
			}else {
				//向前
				if(!visited.contains(currNode.number+1)) {
					nextNode = new Node(currNode.number+1,currNode.step+1);
					queue.add(nextNode);
					visited.add(currNode.number+1);
				}
				//向后
				if(!visited.contains(currNode.number-1)) {
					nextNode = new Node(currNode.number-1,currNode.step+1);
					visited.add(currNode.number+1);
					queue.add(nextNode);
				}
				//心灵移动
				if(!visited.contains(currNode.number+currNode.number)) {
					visited.add(currNode.number+1);
					nextNode = new Node(currNode.number+currNode.number,currNode.step+1);
					queue.add(nextNode);
				}
			}
			
			
		}
	}
	
	
}
class Node{
	int number;
	int step;
	Node(int number,int step){
		this.number = number;
		this.step = step;
	}
	
}
