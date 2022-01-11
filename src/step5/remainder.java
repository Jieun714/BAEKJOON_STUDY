package step5;

import java.io.*;
import java.util.*;

//백준 3052번 나머지 구하기
//10개의 입력된 수의 나머지의 갯수 구하기
public class remainder {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[10]; // 10개를 입력 받음

		int num = 0;
		int count = 0; // 자릿수

		for (int i = 0; i < arr.length; i++) { // 배열의 길이만큼 입력하도록
			arr[i] = Integer.parseInt(br.readLine())%42; //배열에는 나머지만 담음
		}

		//배열 안의 값을 비교해야하기 때문에 이중 for문 사용
		for (int i = 0; i < arr.length; i++) {
			num = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) { //나머지가 동일하면
					num++; //
				}	
			}
			if (num == 0) { //num이 0이면 서로 다른 갯수
				count++; // 갯수 늘림
			}
		}
		System.out.println(count); // 결과를 출력
	}
}
