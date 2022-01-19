package step14;

import java.io.*;
import java.util.*;

//백준 14888번 연산자 끼워넣기
public class jaekjoon_14888 {

	//재귀부분에서 최댓값과 최솟값을 갱신시키기 떄문에, MAX의 값을 MIN_VALUE로 잡음
	public static int MAX = Integer.MIN_VALUE;  //최댓값
	public static int MIN = Integer.MAX_VALUE;  //최솟값
	public static int[] operator = new int[4];	//연산자 개수  // + - * %
	public static int[] arr; //숫자 배열
	public static int n; //숫자의 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); //수의 갯수
		arr = new int[n]; //수만큼 배열 생성
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());  //해당하는 배열의 길이만큼 값을 넣음
		}
		
		// + - * %
		st = new StringTokenizer(br.readLine());  //for문 밖에 선언해야됨. 
		for(int j=0; j<4; j++) { //해당하는 연산자의 갯수를 정함. 최소는 0부터
			operator[j] = Integer.parseInt(st.nextToken());   //해당하는 배열의 길이만큼 값을 넣음
		}
		
		dfs(arr[0], 1);
		 
		System.out.println(MAX); //최댓값 먼저
		System.out.println(MIN); //최솟값 
	}
	
	public static void dfs(int num, int idx) {
		if(idx == n) { //인덱스 값과 n(수의 값)이 동일할 떄
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {  //연산자의 개수가 1이상인 경우
				operator[i]--; //해당 연산자를 1감소시킨다
				
//				if로 사용하거나 switch롤 사용 가능.
//				if(i == 0) dfs(num + arr[idx], idx+1); 
//				else if(i == 1) dfs(num - arr[idx], idx+1);
//				else if(i == 2) dfs(num * arr[idx], idx+1);
//				else if(i == 3) dfs(num / arr[idx], idx+1);
//				
				switch(i) {
				case 0: dfs(num + arr[idx], idx+1); break; 
				case 1: dfs(num - arr[idx], idx+1); break;
				case 2: dfs(num * arr[idx], idx+1); break;
				case 3: dfs(num / arr[idx], idx+1); break;
				}	
				operator[i]++;  //재귀호출이 종료되면 다시 해당 연산자 개수를 복구함
			}
		}
	}
}
