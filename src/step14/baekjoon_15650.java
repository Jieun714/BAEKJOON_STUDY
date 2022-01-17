package step14;

import java.io.*;
import java.util.*;

//백준 15650번 백트랙킹문제 - N과 M
//백트래킹은 해당 범위 내에서 조건을 추가하여 값의 유망성을 판단함. 
//백트랭킹 방법: DFS(깊이우선), BEF(너비우선)
//https://st-lab.tistory.com/115 참고
public class baekjoon_15650 {
	public static int arr[]; // 결과를 저장하는 배열
	//public static boolean check[];  //중복을 체크할 필요가 없어, check 배열은 사용하지 않음
	public static int n, m;
	public static StringBuilder sb = new StringBuilder(); // 배열의 값을 한줄에 같이 출력하기 위해 stringbuilder를 사용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열

		arr = new int[m];

		dfs(1, 0); // 함수 실행
		System.out.println(sb); // StringBuilder에 저장된 값 출력

	}
	
	public static void dfs(int at, int depth) { // dfs 함수 생성
		if (depth == m) { //깊이가 m이랑 같을 때
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(' '); // append로 값을 추가 // ' ' 이어서 공백 추가
			}
			sb.append('\n'); // 한줄 띄어서 다음 값을 넣도록함
			return;
		}

		for (int j =at; j <= n; j++) {
			arr[depth] = j;
			dfs(j + 1, ++depth); // 재귀호출, 현재 i 값보다 다음 재귀에서 더 커야함. 그래서 i+1과 depth+1을 해줌
			depth--; //++를 사용할 경우 --는 필수
		}
	}

}
