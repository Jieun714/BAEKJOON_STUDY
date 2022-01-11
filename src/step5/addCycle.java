package step;

import java.io.*;

//백준 1110번 더하기 사이클
public class addCycle {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		int result = N;
        	
		while (true) {
			//ex. 26일때    ((26%10)*10) + ( ((26/10)+(N%10)) % 10 ) = 68 
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			count++; 
 
			if (result == N) { //동일하면 멈춤
				break;
			}
		}
		
		System.out.println(count);
	}
}
