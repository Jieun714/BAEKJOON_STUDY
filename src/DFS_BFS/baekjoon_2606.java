package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//���� 2606�� ���̷���
//��ü�� �� ���� ������, BFS�� DFS�� ǰ
public class baekjoon_2606 {
	public static int N, M; // ��ǻ�� ���� ��ǻ�� �� ��
	public static int count; // ���̷����� �ɸ��� �Ǵ� ��ǻ���� ��
	public static int[][] arr; // �湮
	public static boolean[] check; // �湮�ߴ� �� üũ�ϴ� �迭
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // ��ǻ�� ��
		M = Integer.parseInt(br.readLine()); // ��ǻ�� �� ��

		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1]; // �� �迭�� ũ�Ⱑ ���� +1 �ΰ�

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		dfs(1); // 1�� ��ǻ�Ϳ��� ����
		System.out.println(count);

		bfs(1);
		System.out.println(count);
	}

	public static int dfs(int idx) {
		check[idx] = true;
		for (int i = 1; i < N + 1; i++) {
			if (arr[idx][i] == 1 && !check[i]) { // if (!check[i]) {
				count++; // ���̷����� �ɸ�(�湮��) ��ǻ�� ��
				dfs(i); // dfs�� ����
			}
		}
		return count;
	}

	//BFS. �ʺ�켱 //ť ���
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx); // ó�� ���۳�� �߰�
		
		while (!queue.isEmpty()) { // ť�� ���� �ʾ��� ��
			idx = queue.poll();
			check[idx] = true; // ó�� ���۳�� �湮ó��

			for (int i = 1; i < N + 1; i++) {
				if (arr[idx][i] == 1 && !check[i]) { // �ش��ϴ� �迭�� 1�̰�, �湮���� �ʾ��� ��
					queue.add(i); // ó�� ���۳�� �߰�
					check[i] = true; // ó�� ���۳�� �湮ó��
					count++;
				}
			}
		}
	}
}
