package step14;

import java.io.*;
import java.util.StringTokenizer;

//���� 15651�� ��Ʈ��ŷ���� - N�� M
//���� �� ����
public class baekjoon_15651 {
	public static int[] arr;
	public static int n, m;
	public static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //��
		m = Integer.parseInt(st.nextToken()); //��
		
		arr = new int[m]; //�� �迭
		
		dfs(n,m,0); //���� 0���� Ž��
		
		System.out.print(sb);
	}
	
	public static void dfs(int n, int m, int depth) {
		if (depth == m) { //��
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(' '); //����� �迭�� ����
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 1; i <= n; i++) { //��
			arr[depth] = i;
			dfs(n,m,++depth);
			depth--;
		}
	}
}
