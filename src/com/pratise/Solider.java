package com.pratise;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Eage{
	int M;
	int FM ;
	int cost;
	
	public Eage(int M,int FM,int cost) {
		this.M = M;
		this.FM = FM;
		this.cost = cost;
	}
}

public class Solider {
		
	static int M;
	static int FM;
	static int MAX = 10001;
	static int[] parent = new int [MAX*3];
	static Queue<Eage> pq ;
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int caseNum  = sc.nextInt();
		Comparator<Eage> comparetor = new Comparator<Eage>() {

			@Override
			public int compare(Eage o1, Eage o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
			
		};
		for(int i=0;i<caseNum;i++) {
			
			pq = new PriorityQueue<Eage>(comparetor);
			M  = sc.nextInt();
			FM  = sc.nextInt();
			int line = sc.nextInt();
			init();
			int S;
			int E;
			int cost;
			for(int j=0;j<line;j++) {
				S = sc.nextInt();
				E = sc.nextInt() + M;
				cost = sc.nextInt();
				pq.add(new Eage(S,E,-cost));
			}
			solve();
		}
	}
	
	public static void solve() {
		int res = 0;
		Eage eage;
		while(!pq.isEmpty()) {
			eage = pq.poll();
			if(!checkUnion(eage.FM,eage.M)) {
				union(eage.FM,eage.M);
				res += eage.cost;
				unionAll(eage.FM);
			}
			
		}
		System.out.println(10000*(M+FM)+res);
	}
	
	
	public static int findParent(int son) {
		if(son != parent[son]) {
			parent[son] = findParent(parent[son]);
		}
		return parent[son];
	}
	
	public static void union(int a,int b) {
		int A = findParent(a);
		int B = findParent(b);
		if(A != B) {
			parent[A] = B;
		}
	}
	
	public static void init() {
		parent = new int[M+MAX+FM];
		for(int i=0;i<FM+ MAX+M;i++) {
			parent[i] = i;
		}
	}
	
	public static boolean checkUnion(int a,int b) {
		return findParent(a) == findParent(b);
	}
	
	public static void unionAll(int son) {
		
		for(int i=0;i<son;i++) {
			if( findParent(son) == findParent(parent[i])) {
				union(son ,parent[i]);
			}
		}
	}
}

