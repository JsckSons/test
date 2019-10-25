package com.order;


import java.io.IOException;
import java.util.Scanner;

public class Main{
	
	static int N;
	static int M;
	static int[] price;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("C://Users/Administrator/Desktop/input_case.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		price = new int[N+1];
		result = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			price[i]= sc.nextInt();
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(j<price[i]) {
					result[i][j] = result[i-1][j] ;
				}else if(j == price[i]) {
					result[i][j] = result[i-1][j] +1;
				}else {
					result[i][j] = result[i-1][j] + result[i-1][j-price[i]];
				}
			}
		}
		
		System.out.println(result[N][M]);
		
	}
}