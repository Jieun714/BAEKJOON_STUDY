package step5;

import java.io.*;
import java.util.*;

//백준 10818번 최대, 최소 구하기  //배열사용
public class minMax {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N]; // N만큼 배열 생성

		for (int i = 0; i < N; i++) { // 배열에 데이터 삽입
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 배열에 데이터가 삽입된 후 min과 max 선언
		int min = arr[0]; // 최소
		int max = arr[0]; // 최대

		for (int i = 1; i < N; i++) { // N번 반복
			if (min > arr[i]) { // min 구하기
				min = arr[i];
			}
			if (max < arr[i]) { // max 구하기
				max = arr[i];
			}
		}
		System.out.println(min + " " + max);
	}
}
