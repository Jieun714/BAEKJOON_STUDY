package baekQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 14503 로봇청소기
//인접한 칸을 탐색 = DFS 사용
class loc {
	int y, x;

	loc(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class baekjoon_14503 {
	static int N, M, R, C, D; // NM은 세로가로, RC는 좌표, D는 방향
	static int count = 1; //출발지점 포함
	static int[][] map;
	static int dy[] = { -1, 0, 1, 0 };  //북동남서
	static int dx[] = { 0, 1, 0, -1 };
	static Queue<loc> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(R, C, D);
		System.out.println(count);
	}

	public static void dfs(int r, int c, int d) { //rc는 좌표, d는 방향
		map[r][c] = 2;   //방문한 좌표는 2로 변경
		
		//현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색(문제에 있는 내용)
		//0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
			
			int ny = r + dy[d];
			int nx = c + dx[d];

			if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
				if(map[ny][nx] == 0) { //좌표가 빈곳이면
					count++; //청소지역 카운트
					dfs(ny, nx, d);
					return; //로봇은 후진만 할 수 있기에 여기서 리턴을 해줌
				}
			}
		}

		// 네 방향 모두 청소(2)가 이미 되어있거나 벽(1)인 경우에는
		int back = (d + 2) % 4;  //반대로 후진
		//후진
		int by = r + dy[back];
		int bx = c + dx[back];
		
		if (by >= 0 && by < N && bx >= 0 && bx < M && map[by][bx] != 1) {
			dfs(by, bx, d);
		}
	}
}
