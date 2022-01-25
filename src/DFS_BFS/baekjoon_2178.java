package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//���� 2178�� �̷�ã��
//�ʺ�켱 Ž��(BFS)
//1: �̵� ������ ĭ, 0: �̵� �Ұ����� ĭ
public class baekjoon_2178 {
	static int N, M; // ��, ��
	static int[][] map; // �̷� ����
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> queue = new LinkedList<>(); // bfs �˰����� ���� ť ����

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		check[0][0] = true;
		bfs(0, 0);
		System.out.print(map[N - 1][M - 1]);
	}

	static void bfs(int x, int y) {
		queue.add(new int[] { x, y }); // queue.offer(idx); // ó�� ���۳�� �߰�

		while (!queue.isEmpty()) { // ť�� ���� �ʾ��� ��
			int val[] = queue.poll(); // queue.poll();
			check[x][y] = true; // �湮�ߴٴ� �ʱⰪ

			int nx = val[0];
			int ny = val[1];

			for (int i = 0; i < 4; i++) { // �¿���Ϸ� �̵��ϱ� ���� 4
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) { //�ش� ������ ����� ��
					continue;  //�����ϵ���
				}
				if (check[nextX][nextY] || map[nextX][nextY] == 0) {
					continue;
				}

				queue.add(new int[] { nextX, nextY });  //���� �湮 ������ ť�� ����
				map[nextX][nextY] = map[nx][ny] + 1;  //��ǥ�� +1
				check[nextX][nextY] = true;  //�湮 �Ϸ�

			}
		}
	}
}