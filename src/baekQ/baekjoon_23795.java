package baekQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_23795 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		
		while (true) {
			String val = br.readLine();
			int N = Integer.parseInt(val); 
			
			if (N == -1) {
				break;
			}
			
			sum+=N;
		}
		sb.append(sum);
		System.out.print(sb);
	}
}
