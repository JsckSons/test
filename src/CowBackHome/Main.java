package CowBackHome;


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
		
		dijkstra(M,1);
	}
	
	static void dijkstra(int start,int end) {
		ajustList = new PriorityQueue<int[]>(N,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[1];
			}
			
		});
		
		for(int i=1;i<visited.length;i++) {
			visited[i] = 2000005;
		}
		ajustList.add(new int[] {start,start,0});
		while(!ajustList.isEmpty()) {
			int curr[] = ajustList.poll();
			if(curr[1] == end) {
				break;
			}
			
			for(int i=0;i<list[curr[0]].size();i++) {
				int next[] = list[curr[1]].get(i).clone();
				if(next[2] + curr[2] < visited[next[0]]) {
					visited[next[0]] = next[2];
					ans += next[2];
					ajustList.add(next);
				}
			}
			
		}
		System.out.println(ans);
	}
}