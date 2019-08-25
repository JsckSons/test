package com.pratise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Castal {
	
	static int N;
	static int M;
	static int[] parent;
	static List<Integer> checkList;
	static int[] result;
	static int counter;
	static int room;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Set<Integer> sets = new HashSet<Integer>();
		parent = new int[N*M];
		result = new int[N*M];
		checkList = new LinkedList<Integer>();
		init();
		int currVal ;
		int temp;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				currVal = sc.nextInt();
				
				temp = 1&currVal;
				if(temp != 1 && j-1>=0) {//西墙 左
					if(!connect( i*M+j,i*M+j-1)) {
						join( i*M+j,i*M+j-1);
						checkRealation(i*M+j);
					}
				}
				
				temp = 2&currVal;
				if(temp != 2 && i-1>=0) {//北墙 上
					if(!connect( i*M+j,(i-1)*M+j)) {
						join( i*M+j,(i-1)*M+j);
						checkRealation(i*M+j);
					}
				}
				
				temp = 4&currVal;
				if(temp != 4 && j+1<M) {//东墙 右
					if(!connect( i*M+j,i*M+j+1)) {
						join( i*M+j,i*M+j+1);
						checkRealation(i*M+j);
					}
				}
				
				temp = 8&currVal;
				if(temp != 8 && i+1<N) {//南墙 下
					if(!connect( i*M+j,(i+1)*M+j)) {
						join( i*M+j,(i+1)*M+j);
						checkRealation(i*M+j);
					}
				}
			}
		}
		
		for(int i=0;i<parent.length;i++ ) {
			if(sets.contains(parent[i])) {
				result[parent[i]] ++  ;
			}else {
				sets.add(parent[i]);
				result[parent[i]] = 1;
			}
		}
		
		System.out.println(sets.size());
		Arrays.sort(result);
		System.out.println(result[result.length-1]);
	}
	
	public static void init() {
		for(int i=0;i<N*M;i++) {
			parent[i] = i;
		}
	}
	
	public static void join(int a,int b) {
		int A = findParent(a);
		int B = findParent(b);
		if(A != B) {
			parent[A] = B;
		}
	}
	
	
	public static int findParent(int son) {
		if(son == parent[son]) {
			return parent[son];
		}else {
			parent[son] = findParent(parent[son]);
		}
		return parent[son];
	}
	
	public static boolean connect(int a,int b) {
		int A = findParent(a);
		int B = findParent(b);
		return A == B;
	}
	
	public static void checkRealation(int node) {
		for(int i=0;i<node;i++) {
			if(connect(i,node)) {
				join(i,node);
			}
		}
		
	}
}

