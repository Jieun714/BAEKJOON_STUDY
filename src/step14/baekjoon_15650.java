package step14;

import java.io.*;
import java.util.*;

//���� 15650�� ��Ʈ��ŷ���� - N�� M
//��Ʈ��ŷ�� �ش� ���� ������ ������ �߰��Ͽ� ���� �������� �Ǵ���. 
//��Ʈ��ŷ ���: DFS(���̿켱), BEF(�ʺ�켱)
//https://st-lab.tistory.com/115 ����
public class baekjoon_15650 {
	public static int arr[]; // ����� �����ϴ� �迭
	//public static boolean check[];  //�ߺ��� üũ�� �ʿ䰡 ����, check �迭�� ������� ����
	public static int n, m;
	public static StringBuilder sb = new StringBuilder(); // �迭�� ���� ���ٿ� ���� ����ϱ� ���� stringbuilder�� ���

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // ��
		m = Integer.parseInt(st.nextToken()); // ��

		arr = new int[m];

		dfs(1, 0); // �Լ� ����
		System.out.println(sb); // StringBuilder�� ����� �� ���

	}
	
	public static void dfs(int at, int depth) { // dfs �Լ� ����
		if (depth == m) { //���̰� m�̶� ���� ��
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(' '); // append�� ���� �߰� // ' ' �̾ ���� �߰�
			}
			sb.append('\n'); // ���� �� ���� ���� �ֵ�����
			return;
		}

		for (int j =at; j <= n; j++) {
			arr[depth] = j;
			dfs(j + 1, ++depth); // ���ȣ��, ���� i ������ ���� ��Ϳ��� �� Ŀ����. �׷��� i+1�� depth+1�� ����
			depth--; //++�� ����� ��� --�� �ʼ�
		}
	}

}
