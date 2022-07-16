package com.pratise;
import java.util.Scanner;

public class T1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int startRow = 0;
        int startCol = 0;
        int num = 0;
        
        String firstChar = "";
        String lastChar = "";
        String[] arr = str.split(";");
        for(int i=0;i<arr.length;i++){
            if(checkOk(arr[i])){
                firstChar = str.substring(0,1);
                lastChar = str.substring(1,3);
                num = Integer.parseInt(lastChar);
                if("A".equals(firstChar)){
                    startRow = startRow - num;
                }else if("D".equals(firstChar)){
                    startRow = startRow + num;
                }else if("W".equals(firstChar)){
                     startCol = startCol - num;
                }else{
                    startCol = startCol + num;
                }
            }
        }
        System.out.println(startRow + "," + startCol);
    }
    
    static boolean checkOk(String str){
        if(str.length() != 3){
            return false;
        }
        String firstChar = str.substring(0,1);
        if(!"A".equals(firstChar)&&!"D".equals(firstChar)&&!"W".equals(firstChar)&&!"S".equals(firstChar)){
            return false;
        }
        
        String lastChar = str.substring(1,3);
        try{
            int result = Integer.parseInt(lastChar);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
}