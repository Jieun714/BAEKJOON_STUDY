package Graph;

import java.io.*;
import java.util.*;

//백준 3055번 고슴도치 탈출 문제
//BFS를 사용. 너비 우선 탐색
//범위를 벗어날 경우 예외처리 필수
//물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다 == 물을 먼저 이동시키고 이후 고슴도치를 이동.
class Point { // 위치를 파악하기 위해 클래스 선언
	int y;
	int x;
	char type;

	public Point(int y, int x, char type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Point [y=" + y + ", x=" + x + ", type=" + type + "]";
	}
}

public class baekjoon_3055 {
	static int R, C; // R:행, C:열
	static char[][] map; // 고슴도치 위치 지도
	static int[][] dp;
	static Queue<Point> queue = new LinkedList<>();; // BFS를 사용하기 때문에 Queue를 선언
	static boolean foundAnswer; // 디폴트 true //이동 할 수 없을 때 비교하기 위한 변수
	static Point st;

	// 좌, 우, 위, 아래
	static int[] MX = { -1, 1, 0, 0 };
	static int[] MY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // 행
		C = sc.nextInt(); // 열

		map = new char[R][C]; // 입력받은 값으로 초기화
		dp = new int[R][C]; // 기록
		st = null;

		// 입력을 받고 starting point를 잡음
		for (int r = 0; r < R; r++) { // 행
			String line = sc.next();
			for (int c = 0; c < C; c++) { // 열
				map[r][c] = line.charAt(c); // 각 자리의 값을 지도 배열에 담음

				if (map[r][c] == 'S') { // S는 고슴도치
					st = new Point(r, c, 'S');
				} else if (map[r][c] == '*') { // *는 비어 있는 곳
					queue.add(new Point(r, c, '*'));
				}
			}
		}
		
		queue.add(st); // starting point를 따로 뺴두었다가 마지막에 삽입

		while (!queue.isEmpty()) { // 큐에 비어있지 않으면
			// 1. 큐에서 꺼내옴
			Point p = queue.poll(); 
			// 2. 목적지인가
			if (p.type == 'D') {  //만약 목적지에 도착했으면
				System.out.println(dp[p.y][p.x]);
				foundAnswer = true; 
				break;
			}
			// 3. 연결된 곳을 순회 -> 좌우위아래
			for (int i = 0; i < 4; i++) { //좌우위아래로만 이동 할 수 있으므로 범위가 4
				int tx = p.x + MX[i];
				int ty = p.y + MY[i]; 
				
				// 4. 갈 수 있는가? (공통)
				if (ty >= 0 && ty < R && tx >= 0 && tx < C) { //입력받은 행렬의 길이를 벗어나지 않도록
					if (p.type == '.' || p.type == 'S') { // 고슴도치이거나 비어 있다면
						if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
							// 5. 체크인 -> dp에 현재+1을 기록
							dp[ty][tx] = dp[p.y][p.x] + 1;
							// 6. 큐에 넣음
							queue.add(new Point(ty, tx, map[ty][tx]));
						}
					} else if (p.type == '*') { // 4. 갈 수 있는가? (물) -> 맵을 벗어나지 않고
						if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
							// 5. 체크인 -> 지도에 * 표기
							map[ty][tx] = '*';
							// 6. 큐에 넣음
							queue.add(new Point(ty, tx, '*'));
						}
					}
				}
			}
		}
		if (foundAnswer == false) { // 길이 없다면
			System.out.println("KAKTUS");
		}
	}
}
