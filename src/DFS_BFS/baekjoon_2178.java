package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2178번 미로찾기
//너비우선 탐색(BFS)
//1: 이동 가능한 칸, 0: 이동 불가능한 칸
public class baekjoon_2178 {
	static int N, M; // 행, 열
	static int[][] map; // 미로 지도
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> queue = new LinkedList<>(); // bfs 알고리즘을 위해 큐 생성

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
		queue.add(new int[] { x, y }); // queue.offer(idx); // 처음 시작노드 추가

		while (!queue.isEmpty()) { // 큐가 비지 않았을 때
			int val[] = queue.poll(); // queue.poll();
			check[x][y] = true; // 방문했다는 초기값

			int nx = val[0];
			int ny = val[1];

			for (int i = 0; i < 4; i++) { // 좌우상하로 이동하기 때문 4
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) { //해당 범위를 벗어날을 때
					continue;  //무시하도록
				}
				if (check[nextX][nextY] || map[nextX][nextY] == 0) {
					continue;
				}

				queue.add(new int[] { nextX, nextY });  //다음 방문 지점을 큐에 넣음
				map[nextX][nextY] = map[nx][ny] + 1;  //좌표를 +1
				check[nextX][nextY] = true;  //방문 완료

			}
		}
	}
}