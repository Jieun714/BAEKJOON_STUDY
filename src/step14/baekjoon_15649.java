package step14;

import java.io.*;
import java.util.*;

//���� 15649�� ��Ʈ��ŷ���� - N�� M
//��Ʈ��ŷ�� �ش� ���� ������ ������ �߰��Ͽ� ���� �������� �Ǵ���. 
//��Ʈ��ŷ ���: DFS(���̿켱), BEF(�ʺ�켱)
//https://st-lab.tistory.com/114  ����
public class baekjoon_15649 {
	public static int arr[]; //����� �����ϴ� �迭
	public static boolean check[]; //������ �湮���θ� üũ�ϴ� �迭(���θ� üũ�ϴ� ���̱� ������ boolean�� �����
	public static StringBuilder sb = new StringBuilder(); //�迭�� ���� ���ٿ� ���� ����ϱ� ���� stringbuilder�� ���
	
	public static void dfs(int n, int m, int depth) {  //dfs �Լ� ����
		if(depth == m) {
			for(int i=0; i<arr.length;i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');  //���� ���
			return;
		}
		
		for(int j=0; j<n; j++) {
			if(!check[j]) { //�湮���� �ʾ��� ��
				check[j] = true;
				arr[depth] = j+1;
				/*
					depth++�� ���� �� ��ü�� 1 �����ϱ� ������, ��Ϳ��� ���������� ������ ���� �״�� ������. �׷��� depth--�� ����������
					depth+1�� �ڹ� ���ο��� �ӽ÷� depth+1 ���� �����Ͽ� �ش� ���� ����ϱ� ������ ��Ϳ��� ���������� ���� ��ȭ��
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
		
		int n = Integer.parseInt(st.nextToken());  //��
		int m = Integer.parseInt(st.nextToken());  //��
		
		arr = new int[m];
		check = new boolean[n];
		
		dfs(n,m,0); //�Լ� ����
		System.out.println(sb);  //StringBuilder�� ����� �� ��� 

	}

}
