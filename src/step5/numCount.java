package step5;

import java.io.*;
import java.util.*;

//백준 2577번 숫자의 갯수 구하기
//세 개의 수를 받아서 곱한 다음 사용된 숫자의 갯수를 구함
//블로그 https://st-lab.tistory.com/45 일부 참고해서 작성
public class numCount {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[3]; // 3개의 자연수
		int[] num = new int[10];  //0부터 9까지 숫자의 배열

		int count = 0;
		int index = 0; // 자릿수

		for (int i = 0; i < arr.length; i++) { // 배열의 길이만큼 입력하도록
			arr[i] = Integer.parseInt(br.readLine());
		}

		int a = arr[0]; 
		int b = arr[1];
		int c = arr[2];

		String sum = String.valueOf(a * b * c); //곱한 값을 String 형식으로 변환

		for (int i = 0; i < sum.length(); i++) {
			num[(sum.charAt(i) - 48)]++; //0~9에 해당하는 숫자의 갯수를 카운팅
		}

		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]); //결과를 출력
		}
	}
}