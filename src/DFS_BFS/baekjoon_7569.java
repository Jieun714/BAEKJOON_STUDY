package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 7569 토마토
//익은 토마토를 기준으로 퍼져나가야하기 때문에, BFS 사용
//가로세로높이가 다 있기떄문에, 2차원 배열이 아닌 3차원 배열 사용, 상하좌우위아래 
//1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 없는 칸
class Point {
	int row;
	int col;
	int height;

	public Point(int height, int col, int row) { //높이 세로 가로 순
		this.col = col;
		this.row = row;
		this.height = height;
	}
}

public class baekjoon_7569 {
	static int M, N, H;  //가로,세로,높이
	static int[][][] map;
	static int[] rowArr = { 0, 0, -1, 1, 0, 0 }; // 상 하 좌 우 위 아래
	static int[] colArr = { -1, 1, 0, 0, 0, 0 };
	static int[] heightArr = { 0, 0, 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());  //가로 
		N = Integer.parseInt(st.nextToken());  //세로
		H = Integer.parseInt(st.nextToken());  //높이

		map = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());

					if (map[i][j][k] == 1) {
						q.add(new Point(i, j, k));
					}
				}
			}
		}
//		bfs();
//		System.out.print(sb);
		System.out.print(bfs());
	}

	public static int bfs() {
		while (!q.isEmpty()) {
			Point point = q.poll();

			int h = point.height;
			int r = point.row;
			int c = point.col;

			for (int i = 0; i < 6; i++) { // 상하좌우위아래 6방향을 돔
				int nHeight = h + heightArr[i];
				int nRow = r + rowArr[i];
				int nCol = c + colArr[i];

				// 가로 세로 높이 범위
				if (nRow >= 0 && nCol >= 0 && nHeight >= 0 && nRow < M && nCol < N && nHeight < H) {
					if (map[nHeight][nCol][nRow] == 0) { // 익지 않은 토마토만
						q.add(new Point(nHeight, nCol, nRow)); // 익은 토마토 추가

						map[nHeight][nCol][nRow] = map[h][c][r]+1; // 익은 날짜 추가
					}
				}
			}
		}
		int days = Integer.MIN_VALUE; // 최대날짜

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
//						sb.append(-1); 
						return -1;
					}

					days = Math.max(days, map[i][j][k]);
				}
			}
		}

		if (days == 1) {
//			sb.append(0);
			return 0;
		} else {
//			sb.append(days-1);
			return days-1;
		}
	}
}
