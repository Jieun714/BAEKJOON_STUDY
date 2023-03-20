package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자: 이지은
 * 문제: 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하는 프로그램을 작성하시오
 * 입력: 첫 줄에 정수 N이 주어진다.
 * 출력: 입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오
 */

public class B2018_수들의합5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0; //자연수의 합으로 나타내는 가지수 
		
		int start = 1; //자연수 1부터 시작
		
		while(start<=N) {
			int sum = 0;
			for(int i=start; i<N+1; i++) {
				sum += i;
				if(sum == N) {
					cnt++;
					break;
				}else if(sum > N) { 
					break;
				}
			}
			start++; 
		}
		System.out.println(cnt);
	}
}
