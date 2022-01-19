package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*	���� 1260�� DFS�� BFS
	���̿켱�� �ʺ�켱 Ž�� ���
	�湮�� �� �ִ� ������ �������� ���, ��ȣ�� ���� �ͺ��� �湮�ϵ��� ��. ������ �����
	DFS�� ����Լ� �Ǵ� ����
	BFS�� ť
*/
public class dfs_bfs {
	public static int N, M, V;
	public static int[][] arr; // ������ ���� ���� �迭
	public static boolean[] check; // �湮�� ������� Ȯ���ϴ� �迭
	public static StringBuilder sb = new StringBuilder();
	public static Stack<Integer> stack = new Stack<>(); // ���ü���
	public static Queue<Integer> queue = new LinkedList<Integer>(); //bfs �˰����� ���� ť ����

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // ������ ����
		M = Integer.parseInt(st.nextToken()); // ������ ����
		V = Integer.parseInt(st.nextToken()); // (Ž���� ������)������ ��ȣ

		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1]; // �� �迭�� ũ�Ⱑ ���� +1 �ΰ�

		for (int i = 0; i < M; i++) { // ������ ������ŭ �ݺ�
			// ������ �����ϴ� �� ������ ��ȣ�� �Է�
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// ���� ������ �� �ʱ�ȭ
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dfs(V); // Ž���� ������ ������ ��ȣ�� ����.
//		System.out.println();
		sb.append("\n");
		check = new boolean[N+1];  //bfs�� ���� �迭 �缱��
		bfs(V);
		System.out.println(sb);
	}

	// ���̿켱 //��� ���(��Ͱ� ���ú��� ª��, ����)
	public static void dfs(int idx) {
//		if (check[idx]) { // �湮�� ���� ���� ��
//			return;
//		}
		check[idx] = true; // ���۳�� �湮ó��
//		System.out.print(idx + " ");

		sb.append(idx+" ");  //�ּ� Ǯ� StringBuilder ��� ����.
		for (int i = 1; i < N + 1; i++) { // �湮�� ����� ������ ��带 ã��
			if (arr[idx][i] == 1 && !check[i]) { // if (!check[i]) {
				dfs(i); // dfs�� ����
			}
		}
	}

	// ���̿켱 //���� ���
	public static void dfs_stack(int idx) {
		stack.push(idx); // ���۳�带 �־���
		check[idx] = true; // ���۳�� �湮ó��

		while (!stack.isEmpty()) { // ������ ��� ���� ������ ��� �ݺ�
			int val = stack.pop();
			System.out.print(val + " ");

			for (int i = 1; i < N + 1; i++) {
				if (arr[val][i] == 1 && !check[i]) { // if (!check[i]) {
					dfs_stack(i); // �ݺ�
				}
			}
		}
	}

	// �ʺ�켱 //ť ���
	public static void bfs(int idx) { 
		queue.add(idx); //queue.offer(idx); // ó�� ���۳�� �߰�
		check[idx] = true; // ó�� ���۳�� �湮ó��

		while (!queue.isEmpty()) { //ť�� ���� �ʾ��� ��
			int val = queue.remove();  //queue.poll();
//			System.out.print(val + " ");
			sb.append(val+" ");
			
			for (int i = 1; i < N+1; i++) {
				if (arr[val][i] == 1 && !check[i]) { //�ش��ϴ� �迭�� 1�̰�, �湮���� �ʾ��� ��
					queue.add(i);  //queue.offer(i);
					check[i] = true;
				}
			}
		}
	}
}
