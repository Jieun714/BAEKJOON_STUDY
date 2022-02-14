package baekQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 14502  DFS+BFS 문제
//DFS로 벽을 3개 만든 후, BFS로 바이러스 퍼트리기
//dfs - 깊이우선 탐색, bfs - 너비우선 탐색
class dot {
	int y, x;

	public dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class baekjoon_14502 {
	static int N, M, safe;
	static int[][] map, newMap;
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	static Queue<dot> q = new LinkedList<>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(safe); //안전지대 갯수 출력
	}

	//벽을 만들기 위한 dfs
	public static void dfs(int depth) {  
		if (depth == 3) { //3개의 벽을 세우면
			newMap = new int[N][M]; //추가한 벽을 포함한 새로운 배열
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newMap[i][j] = map[i][j]; //새로운 맵에 기존 맵 삽입
					
					if (newMap[i][j] == 2)
						q.offer(new dot(i, j)); //offer로 시작할 노드 삽입
				}
			}
			bfs();  //바이러스를 퍼트릴 bfs 호출
			
			return;
		}
		
		for (int i = 0; i < N; i++) { //재귀
			for(int j=0; j<M; j++) {		
				if(map[i][j] == 0) { //빈칸이면 
					map[i][j] =1;  
					
					dfs(depth + 1);
					
					map[i][j] =0;
				}
			}	
		}
	}

	// 바이러스를 퍼트리기 위한 bfs
	public static void bfs() {
		while (!q.isEmpty()) { //큐가 빌 때까지
			dot now = q.poll(); //삭제 
			for (int i = 0; i < 4; i++) { //상하좌우라서 사이즈 4
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if (ny >= 0 && ny < N && nx < M && nx >= 0) {
					if (newMap[ny][nx] == 0) { //0(안전지대)이면 
						newMap[ny][nx] = 2;  //바이러스 삽입
						q.offer(new dot(ny, nx)); 
					}
				}
			}
		}
		countSafe();
	}

	public static void countSafe() { //안전지대 찾기
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 0) { 
					count++; //배열의 값이 0인 지점 ++
				}
			}
		}
		safe = Math.max(safe, count); //최대를 찾음
	}
}
