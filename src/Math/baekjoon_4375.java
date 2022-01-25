package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// StringBuilder로는 왜 잘못된 값이 출력되는 지 모르겠음
//백준 4375번 1
//2와 5로 나누어 떨어지지 않는 정수
public class baekjoon_4375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break; // null이면 멈추도록
			}
			int n = Integer.parseInt(s);
			int result = 0;

			for (int i = 1; i <= n; i++) {
				result = result * 10 + 1; // 자리수를 업
				result %= n;  
				if (result == 0) { // 나머지가 0일 때
//					sb.append(i).append('\n'); 
					System.out.println(i);
					break;
				}	
			}
//			System.out.print(sb);
		}
	}
}
