package step11;

import java.io.*;
import java.util.*;

//백준 2231번 분헤합
//n = m + 100의 자리 + 10의 자리 + 1의 자리
//브루트 포스: 조합 가능한 모든 문자열을 하나씩 대입해 보는 방식으로 암포를 해독하는 방법
public class baekjoon_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 자연수 n 입력 받음

		int result = 0;

		for (int i = 0; i < n; i++) {
			int m = i;
			int sum = 0; // 각 자릿수 합

			while (m>0) { // m의 값이 0이 아닐 때
				sum += m % 10;   // 각 자릿수를 더함
				m /= 10;
			}

			if ((sum +i) == n) { // 생성자 일때
				result = i;
				break;
			}

		}
		System.out.println(result);
	}
}
