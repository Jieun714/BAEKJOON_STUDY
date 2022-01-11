package step;

import java.io.*;
import java.util.*;

public class minMax {

	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		String arr[] = N.split(" ");
		
		int min = Integer.parseInt(arr[0]);//최솟값
		int max = Integer.parseInt(arr[0]); //최대값
		
		for(int i=0; i<arr.length; i++) {
			int a = Integer.parseInt(arr[i]);
			
			if(a <= min) {
				min = a;
			}else if(a >= max) {
				max = a;
			}
		}
		
		System.out.println(min+" "+max);

	}

}
