package step5;

import java.io.*;
import java.util.*;

//백준 2562번 최댓값과 최댓값 자릿수 구하기
public class maxCount {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9]; // 9개의 자연수
		
		int max = 0; // 최대값
		int count = 0; 
		int index = 0; //자릿수

		for (int i = 0; i < arr.length; i++) { // 배열의 길이만큼 입력하도록
			arr[i] = Integer.parseInt(br.readLine());  
		}

		for (int i = 0; i < arr.length; i++) { // N번 반복
			count++;  //카운트
			if (max < arr[i]) { // max 구하기
				max = arr[i];
				index = count; //index에 count 저장. 자릿수
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}