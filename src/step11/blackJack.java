package step11;

import java.io.*;
import java.util.*;

//백준 2798 블랙잭, m을 넘지 않으면서 m에 가까운 카드 세 장의 합
//https://velog.io/@im_lily/%EB%B0%B1%EC%A4%80-2798-%EB%B8%94%EB%9E%99%EC%9E%AD 코드 참조
public class blackJack {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 카드의 개수
		int m = Integer.parseInt(st.nextToken()); // 딜러의 숫자

		int[] arr = new int[n];
		int max = 0; //딜러의 수와 가장 가까운 수
		
		st = new StringTokenizer(br.readLine()); // 초기화 해줘야함
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i+1; j < arr.length - 1; j++) {
				for (int k = j+1; k < arr.length; k++) {
					int sum = 0; // 세 개의 카드를 더한 합
					sum += arr[i] + arr[j] + arr[k];
					
					if(sum<=m) {
						max = Math.max(max, sum); // 최댓값 비교하여 저장
					}
				}
			}
		}
		System.out.println(max);
	}

}
