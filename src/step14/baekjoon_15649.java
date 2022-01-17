package step14;

import java.io.*;
import java.util.*;

//백준 15649번 백트랙킹문제 - N과 M
//백트래킹은 해당 범위 내에서 조건을 추가하여 값의 유망성을 판단함. 
//백트랭킹 방법: DFS(깊이우선), BEF(너비우선)
//https://st-lab.tistory.com/114  참고
public class baekjoon_15649 {
	public static int arr[]; //결과를 저장하는 배열
	public static boolean check[]; //숫자의 방문여부를 체크하는 배열(여부를 체크하는 것이기 떄문에 boolean을 사용함
	public static StringBuilder sb = new StringBuilder(); //배열의 값을 한줄에 같이 출력하기 위해 stringbuilder를 사용
	
	public static void dfs(int n, int m, int depth) {  //dfs 함수 생성
		if(depth == m) {
			for(int i=0; i<arr.length;i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');  //한줄 띄기
			return;
		}
		
		for(int j=0; j<n; j++) {
			if(!check[j]) { //방문하지 않았을 때
				check[j] = true;
				arr[depth] = j+1;
				/*
					depth++는 변수 값 자체가 1 증가하기 때문에, 재귀에서 빠져나오도 증가된 값은 그대로 유지됨. 그래서 depth--를 사용해줘야함
					depth+1은 자바 내부에서 임시로 depth+1 값을 복사하여 해당 값을 사용하기 때문에 재귀에서 빠져나오면 값은 발화됨
				*/
				dfs(n,m,++depth);   //dfs(n,m,depth++)
				check[j] = false;
				depth--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());  //행
		int m = Integer.parseInt(st.nextToken());  //열
		
		arr = new int[m];
		check = new boolean[n];
		
		dfs(n,m,0); //함수 실행
		System.out.println(sb);  //StringBuilder에 저장된 값 출력 

	}

}
