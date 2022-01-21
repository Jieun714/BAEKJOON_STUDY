package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 11399번 ATM
//그리디 알고리즘. 시간의 합의 최솟값 구하기
public class baekjoon_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());  //사람의 수
		int[] pArr = new int[N]; //시간 배열. 배열의 길이는 사람 수만큼
		int minTime = 0;  //최소시간
		int sum = 0;  //누적합
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pArr[i] = Integer.parseInt(st.nextToken());  //시간배열에 값 담기
		}
		
		Arrays.sort(pArr);  //시간 배열 정렬
		for(int j=0; j<N; j++) { 
			minTime += pArr[j];  //최소시간에 배열의 값을 더함
			sum += minTime;  //누적합
		}
		
		System.out.print(sum);
	}
}
