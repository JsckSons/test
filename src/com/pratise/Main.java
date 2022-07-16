package com.pratise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Main{

    static int start = 0;
    static int end = 0;
    public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		//String str = sc.nextLine();
		 
		String str1 = sc.nextLine();// print(str); start = 0; end = 0; print(str1);
		str1 = str1.substring(2).toLowerCase();
        int parseInt = Integer.parseInt(str1, 16);
        System.out.println(parseInt);
        Map s = new HashMap();
        Iterator iterator = s.entrySet().iterator();
        while(iterator.hasNext()) {
        	Object obj = iterator.next();
        }
        boolean hasNext = iterator.hasNext();
    }
    public static void print(String str){
        if(end == str.length()){
            return;
        }else{
        	start = end;
            if(str.length() - start>=8){
                end += 8;
                System.out.println(str.substring(start,end));
            }else{
                end += (str.length() - start);
                String temp = "";
                for(int i=0;i<8 +start - str.length();i++){
                    temp += "0";
                }
                System.out.println(str.substring(start,end) + temp);
            }
            print(str);
        }
    }
}