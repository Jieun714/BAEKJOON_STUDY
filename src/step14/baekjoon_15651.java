package step14;

import java.io.*;
import java.util.StringTokenizer;

//백준 15651번 백트랙킹문제 - N과 M
//같은 수 가능
public class baekjoon_15651 {
	public static int[] arr;
	public static int n, m;
	public static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //행
		m = Integer.parseInt(st.nextToken()); //열
		
		arr = new int[m]; //열 배열
		
		dfs(n,m,0); //깊이 0부터 탐색
		
		System.out.print(sb);
	}
	
	public static void dfs(int n, int m, int depth) {
		if (depth == m) { //열
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(' '); //결과를 배열에 담음
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 1; i <= n; i++) { //행
			arr[depth] = i;
			dfs(n,m,++depth);
			depth--;
		}
	}
}
