package network;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static int N;
	static int M;
	static int[] visited;
	static Queue<int[]> ajustList ;
	static LinkedList<int[]>[] list ;
	static int[] parent;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("C://Users/Administrator/Desktop/input_case.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new int[M+1];
		list = new LinkedList[M+1];
		
		for(int i=1;i<M+1;i++) {
			list[i] = new LinkedList<int[]>();
		}
		
		int S;
		int E;	
		int D;
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			list[S].add(new int[] {S,E,D});
			list[E].add(new int[] {E,S,D});
		}
		
	}
	
	/*
	 * static findParent(int son) {
	 * 
	 * }
	 */
	
}